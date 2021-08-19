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
			util = new SQLiteUtil(Settings.appPath,"HomeAssitant.db");
			createTableLigths();
			createTableHistoricLigths();
			createTableHitoricTemp();
			createTableHitoricInfo();
		} catch (SQLException e) {
			
			e.printStackTrace();
			
		}
	}
	
	public static DatabaseManager getInstance() {
		
		if(instance == null) {
			instance = new DatabaseManager();
		}
		
		return instance;
	}
	public void createTableLigths() {
		
		try {
			
			Statement st = util.con().createStatement();
			st.execute("create table IF NOT EXISTSLigths( "
            + "idLigth int primary key auto_increment,"
            + "ligth varchar(10) not null unique"
            + ");");

			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void createTableHistoricLigths() {
		
		try {
			
			Statement st = util.con().createStatement();
			st.execute("create table HistoricLights("
            +    "idHistoricLigth int primary key auto_increment,"
      		+    "nameLigth varchar (10) not null,"
            +    "foreign key (nameLigth) references Ligths(ligth),"
            +    "statusLigth varchar(3) not null,"
            +    "dataLigth datetime not null"
            +    ");");

			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	public void createTableHitoricTemp() {
		
		try {
			
			Statement st = util.con().createStatement();
			st.execute("create table HistoricTemp("
            +   "idTemp int primary key not null unique,"
            +   "Temp int not null unique,"
            +   "dataTemp datetime not null"
            +    ");");

			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void createTableHitoricInfo() {
		
		try {
			
			Statement st = util.con().createStatement();
			st.execute("create table Info("
            +   "idInfo int primary key auto_increment,"
            +   "info varchar (20) not null unique"
            +   ");");

			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
/* 	public Boolean insertUsers(User user) {
		
		Boolean success = true;
		
		try {
		
			String sql = "INSERT INTO USERS VALUES (?,?,?,?)";
			PreparedStatement st = util.con().prepareStatement(sql);
			
			st.setString(1, user.getName());
			st.setString(2, user.getPhone());
			st.setString(3, user.getMail());
			st.setString(4, user.getPassword());
			
			st.executeUpdate();
			st.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			success = false;
		}
		
		return success;
	} */
	
/* 	public ArrayList<User> getUsers() {
		
		ArrayList<User> users = new ArrayList<>();
		
		try {
			
			Statement st = util.con().createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM USERS");
			
			while (rs.next()){
				
				User user = new User();
				user.setName(rs.getString("NAME"));
				user.setPhone(rs.getString("PHONE"));
				user.setMail(rs.getString("EMAIL"));
				user.setPassword(rs.getString("PASSWORD"));
				
				users.add(user);
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return users;
	} */
}

