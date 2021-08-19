package com.totalcross.database;

import java.sql.SQLException;
import totalcross.sql.Connection;
import totalcross.sql.PreparedStatement;
import totalcross.sql.ResultSet;
import totalcross.sql.Statement;

public class DAO {

   /*  String Kitchen =  "kitchen";
    public void initUI() {


        String sqlKitchen = "insert into Ligths(idLigth,ligth)"
       + "value('?','?');";
        String sqlLivingRoom;
        String sqlPorch;
        String sqlGarage;
        Connection dbcon = DatabaseManager.getConnection();
        PreparedStatement ps =  dbcon.prepareStatement(sqlKitchen);
       
        ps.setString(1, Kitchen);
        ps.executeUpdate();
		ps.close();

    }
    public boolean insertCPF(String cpf) throws SQLException {

		boolean success = false;
		Connection dbcon = DatabaseManager.getConnection();
		String sql = "insert into person values(?)";
		PreparedStatement ps = dbcon.prepareStatement(sql);
		ps.setString(1, cpf);

		int i = ps.executeUpdate();
		ps.close();

		if (i > 0) {
			success = true;
		} else {
			success = false;
		}
		return success;
	} */
}
