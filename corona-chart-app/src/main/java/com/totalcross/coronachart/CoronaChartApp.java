package com.totalcross.coronachart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;

import com.totalcross.coronachart.CoronaChart.Data;
import com.totalcross.coronachart.util.Colors;

import totalcross.io.ByteArrayStream;
import totalcross.io.IOException;
import totalcross.json.JSONArray;
import totalcross.json.JSONException;
import totalcross.json.JSONObject;
import totalcross.net.HttpStream;
import totalcross.net.URI;
import totalcross.net.ssl.SSLSocketFactory;
import totalcross.sys.Convert;
import totalcross.sys.Settings;
import totalcross.sys.Vm;
import totalcross.ui.Button;
import totalcross.ui.Check;
import totalcross.ui.Label;
import totalcross.ui.MainWindow;
import totalcross.ui.event.UpdateListener;
import totalcross.ui.font.Font;
import totalcross.ui.gfx.Color;
import totalcross.util.Date;
import totalcross.util.InvalidDateException;

public class CoronaChartApp extends MainWindow {

    Check offlineCheck = new Check("Online Data");
    final static int ANIMATION_TIME = 5000;
    int currentAnimationTime = 0;
    int nextStopTime = 0;
    int index = 0;
    JSONArray dates;
    JSONArray array;
    String date;
    JSONObject item;
    CoronaChart.Series<MyDate, Integer> confirmedSeries;
    CoronaChart.Series<MyDate, Integer> recoveredSeries;
    CoronaChart.Series<MyDate, Integer> deathsSeries;
    CoronaChart<MyDate, Integer> cc;
    List<Data<MyDate, Integer>> confirmedList = new ArrayList<>();
    List<Data<MyDate, Integer>> recoveredList = new ArrayList<>();
    List<Data<MyDate, Integer>> deathsList = new ArrayList<>();
    public static Date firstDay;
    JSONObject response;
    String secretKey = "<YOUR KEY FROM RAPIDAPI HERE>";

    UpdateListener updateListener = new UpdateListener() {

        @Override
        public void updateListenerTriggered(int elapsedMilliseconds) {
            // Calculates when to update the screen for the animation
            if (currentAnimationTime != 0) {
                currentAnimationTime += elapsedMilliseconds;
            } else {
                currentAnimationTime += 1;
            }
            if (currentAnimationTime >= nextStopTime && index != confirmedList.size()) {
                switch (MyDate.mode) {
                    case MyDate.MONTH:
                        if (confirmedList.get(index).x.toDate().equals(firstDay) || confirmedList.get(index).x.day == 1
                                || index == confirmedList.size() - 1) {
                            cc.changeIndex(index);
                        }
                        break;
                    case MyDate.WEEK:
                        if (confirmedList.get(index).x.exactlyXWeeksSinceDate(MyDate.firstDay)) {
                            cc.changeIndex(index);
                        }
                        break;
                    case MyDate.DAY:
                        cc.changeIndex(index);
                        break;
                }
                if (index != confirmedList.size() - 1) {
                    index++;
                } else {
                    MainWindow.getMainWindow().removeUpdateListener(this);
                }
                nextStopTime = (int) (ANIMATION_TIME * easeInQuad(1.0 * index / confirmedList.size()));
            }
        }
    };

    public CoronaChartApp() {
        setUIStyle(Settings.MATERIAL_UI);
        // Filling the lists with confirmed, recovered and death cases
        fillData();
    }

    @Override
    public void initUI() {
        this.backColor = 0x131722;
        // Adding components do UI
        Label lblTitle = new Label("Coronavirus (COVID-19) charts and stats", CENTER);
        lblTitle.setForeColor(Color.WHITE);
        lblTitle.setFont(Font.getFont(true, 36));
        add(lblTitle, LEFT, TOP + this.fmH, FILL, PREFERRED);

        Button btnStartStop = new Button("Start");
        // Adding the listener to start or stop the animation
        btnStartStop.addPressListener(e -> {
            if (btnStartStop.getText().equals("Start")) {
                restartAnimation();
                btnStartStop.setText("Stop");
            } else {
                MainWindow.getMainWindow().removeUpdateListener(updateListener);
                btnStartStop.setText("Start");
            }
        });

        BiFunction<String, Integer, Button> animationBtnFactory = (typeName, type) -> {
            Button btn = new Button(typeName);
            btn.addPressListener(e -> {
                changeDateDisplayMode(type);
                restartAnimation();
            });
            return btn;
        };

        add(btnStartStop, LEFT + this.fmH, AFTER + this.fmH);
        offlineCheck.setBackForeColors(this.backColor, Color.WHITE);
        offlineCheck.addValueChangeHandler(e -> {
            fillData();
        });
        add(offlineCheck, AFTER + this.fmH, CENTER_OF);
        add(animationBtnFactory.apply("Month", MyDate.MONTH), RIGHT - this.fmH, SAME);
        add(animationBtnFactory.apply("Week", MyDate.WEEK), BEFORE - this.fmH, SAME);
        add(animationBtnFactory.apply("Day", MyDate.DAY), BEFORE - this.fmH, SAME);

        try {
            // Setting the first CoronaChart
            MyDate.firstDay = confirmedList.get(0).x.toDate();
            confirmedSeries = new CoronaChart.Series<>(confirmedList);
            confirmedSeries.title = "Confirmed";
            confirmedSeries.color = Colors.COLOR_CONFIRMED_CASES;
            recoveredSeries = new CoronaChart.Series<>(recoveredList);
            recoveredSeries.title = "Recovered";
            recoveredSeries.color = Colors.COLOR_RECOVERED_CASES;
            deathsSeries = new CoronaChart.Series<>(deathsList);
            deathsSeries.title = "Deaths";
            deathsSeries.color = Colors.COLOR_DEATH_CASES;
            cc = new CoronaChart<>(confirmedSeries, recoveredSeries, deathsSeries);
            add(cc, LEFT, AFTER + this.fmH, FILL, FILL);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    private void fillData() {

        confirmedList.clear();
        recoveredList.clear();
        deathsList.clear();

        // Getting the information and filling the lists used to fill the CoronaChart
        if (offlineCheck.isChecked())
            response = getCoronavirusData("https://coronavirus-map.p.rapidapi.com/v1/summary/latest", HttpStream.GET);
        else
            response = new JSONObject(new String(Vm.getFile("request.json")));

        JSONObject data = response.getJSONObject("data");
        dates = data.names();
        array = data.toJSONArray(dates);
        for (int i = 0; i < array.length(); i++) {
            date = dates.getString(i);
            item = array.getJSONObject(i);
            MyDate myDate = new MyDate(Integer.parseInt(Convert.remove(date, "-")));
            confirmedList.add(new Data<MyDate, Integer>(myDate, item.getInt("total_cases")));
            recoveredList.add(new Data<MyDate, Integer>(myDate, item.getInt("recovered")));
            deathsList.add(new Data<MyDate, Integer>(myDate, item.getInt("deaths")));
        }

        // Sorts the data by date;
        Comparator<Data<MyDate, Integer>> dataComparator = (o1, o2) -> o1.x.compareTo(o2.x);
        Collections.sort(confirmedList, dataComparator);
        Collections.sort(recoveredList, dataComparator);
        Collections.sort(deathsList, dataComparator);
    }

    private void restartAnimation() {
        cc.reset();
        // Removes the animation and sets the variables to start another animation
        MainWindow.getMainWindow().removeUpdateListener(updateListener);
        index = 0;
        currentAnimationTime = 0;
        nextStopTime = 0;
        MainWindow.getMainWindow().addUpdateListener(updateListener);
    }

    double easeInQuad(double x) {
        // Used to ease the animation
        return x * x * x * x;
    }

    private void changeDateDisplayMode(int mode) {
        // Changes the mode of display on the chart(day, week or month)
        for (int i = 0; i < this.confirmedList.size(); i++) {
            this.confirmedList.get(i).x.changeMode(mode);
        }
    }

    JSONObject getCoronavirusData(final String url, String httpType) {
        // Gets the data from RapidAPI and return it to be used as the JSON
        String request = "";
        try {
            HttpStream.Options o = new HttpStream.Options();
            o.readTimeOut = 5000;
            o.socketFactory = new SSLSocketFactory();
            o.requestHeaders.put("x-rapidapi-host", "coronavirus-map.p.rapidapi.com");
            o.requestHeaders.put("x-rapidapi-key", secretKey);
            HttpStream hs = new HttpStream(new URI("https://coronavirus-map.p.rapidapi.com/v1/spots/summary"), o);
            ByteArrayStream bas = new ByteArrayStream(4096);
            bas.readFully(hs, 10, 4096);
            hs.close();
            String string = new String(bas.getBuffer(), 0, bas.available());
            request = string;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new JSONObject(request);
    }
}

class MyDate implements Comparable<MyDate> {
    int date;
    int day;
    int month;
    String s = null;
    public static final int DAY = 0;
    public static final int MONTH = 1;
    public static final int WEEK = 2;
    public static int mode = DAY;
    public static Date firstDay;

    public MyDate(int yyyyMMdd) {
        this.date = yyyyMMdd;
        this.day = this.date % 100;
        this.month = yyyyMMdd / 100 % 100;
        if (this.day == 1) {
            s = Date.monthNames[this.month].substring(0, 3);
        } else if (this.day == 10 || this.day == 19) {
            s = Integer.toString(this.day);
        }
    }

    public void changeMode(int mode) {
        MyDate.mode = mode;
        switch (mode) {
            case DAY:
                if (this.day == 1) {
                    s = Date.monthNames[this.month].substring(0, 3);
                } else if (this.day == 10 || this.day == 19) {
                    s = Integer.toString(this.day);
                } else {
                    s = null;
                }
                break;
            case MONTH:
                if (this.toDate().equals(firstDay) || this.day == 1) {
                    s = Date.monthNames[this.month].substring(0, 3);
                } else {
                    s = null;
                }
                break;
            case WEEK:
                if (exactlyXWeeksSinceDate(MyDate.firstDay)) {
                    s = weeksSinceDate(MyDate.firstDay);
                } else {
                    s = null;
                }
                break;
        }
    }

    public String weeksSinceDate(Date date) {
        return date != null ? Integer.toString(date.subtract(this.toDate()) / 7) : null;
    }

    public boolean exactlyXWeeksSinceDate(Date date) {
        return date != null ? date.subtract(this.toDate()) % 7 == 0 : false;
    }

    public int compareTo(MyDate o) {
        return this.date - o.date;
    }

    public Date toDate() {
        int year = this.date / 10000;
        Date myDate = null;
        try {
            myDate = new Date(year + "-" + this.month + "-" + this.day, Settings.DATE_YMD);
        } catch (InvalidDateException e) {
            e.printStackTrace();
        }
        return myDate;
    }

    @Override
    public String toString() {
        return s;
    }

}
