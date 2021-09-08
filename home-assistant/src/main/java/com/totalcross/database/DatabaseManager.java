package com.totalcross.database;

import java.sql.SQLException;
import totalcross.db.sqlite.SQLiteUtil;
import totalcross.sql.Statement;
import totalcross.sys.Settings;

public class DatabaseManager {

	private static DatabaseManager instance = null;
	private SQLiteUtil util;

	private DatabaseManager() {
		try {
			util = new SQLiteUtil(Settings.appPath, "HomeAssitant.db");
			createTableLigths();
			createTableHistoricLigths();
			createTableHitoricTemp();
			createTableHitoricInfo();
		} catch (SQLException e) {
			// throw new RuntimeException(e);
			e.printStackTrace();
			return;
		}
	}

	public static DatabaseManager getInstance() {
		if (instance == null) {
			instance = new DatabaseManager();
		}
		return instance;
	}

	public void createTableLigths() {
		try {
			Statement st = util.con().createStatement();
			st.execute("create table IF NOT EXISTS Ligths(" + "idLigth integer primary key autoincrement,"
					+ "ligth varchar(10) not null unique);");

			st.close();

		} catch (SQLException e) {
			// throw new RuntimeException(e);
			e.printStackTrace();
			return;
		}
	}

	public void createTableHistoricLigths() {
		try {
			Statement st = util.con().createStatement();
			st.execute("CREATE TABLE IF NOT EXISTS HistoricLights (" + "	idHistoricLigth	INTEGER,"
					+ "	nameLigth	TEXT NOT NULL," + "	statusLigth	TEXT NOT NULL, "
					+ "	dataLigth	datetime NOT NULL, " + "	PRIMARY KEY(idHistoricLigth AUTOINCREMENT), "
					+ "	FOREIGN KEY(nameLigth) REFERENCES Ligths(ligth) " + ");");

			st.close();
		} catch (SQLException e) {
			// throw new RuntimeException(e);
			e.printStackTrace();
			return;
		}
	}

	public void createTableHitoricTemp() {
		try {
			Statement st = util.con().createStatement();
			st.execute("create table IF NOT EXISTS HistoricTemp(" + "idTemp integer primary key not null autoincrement,"
					+ "Temp int not null unique," + "dataTemp datetime not null" + ");");

			st.close();
		} catch (SQLException e) {
			// throw new RuntimeException(e);
			e.printStackTrace();
			return;
		}
	}

	public void createTableHitoricInfo() {
		try {
			Statement st = util.con().createStatement();
			st.execute("create table IF NOT EXISTS HistoricInfo(" + "idInfo integer primary key autoincrement,"
					+ "info varchar (20) not null unique" + ");");

			st.close();
		} catch (SQLException e) {
			// throw new RuntimeException(e);
			e.printStackTrace();
			return;
		}
	}
}
