package com.p2.highlander;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HighConn {
	
	private Connection conn;
	private static String url = "jdbc:oracle:thin:@lestercarson.cij8ici48e2h.us-east-2.rds.amazonaws.com:1521:ORCL";
	private static String username = "lbcarson4";
	private static String password = "Lbc49681ataws";
	
	static {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

	private HighConn() {
		try {
			conn = DriverManager.getConnection(url, username, password);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static class Holder {
		public static final HighConn hc = new HighConn();
	}

	public static HighConn getInstance() {
		return Holder.hc;
	}

	public Connection getConn() {return conn;}
}