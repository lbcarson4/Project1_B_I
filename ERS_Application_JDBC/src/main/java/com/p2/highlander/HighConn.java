package com.p2.highlander;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HighConn {
	
	public Connection conn;
	public static HighConn db = new HighConn();
	
	//(Connection conn = DriverManager.getConnection(url, username, password))

	private HighConn() {
		try {
			String url = "jdbc:oracle:thin:@lestercarson.cij8ici48e2h.us-east-2.rds.amazonaws.com:1521:ORCL";
			String username = "lbcarson4";
			String password = "Lbc49681ataws";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException d) {
			d.printStackTrace();
		}
	}
}