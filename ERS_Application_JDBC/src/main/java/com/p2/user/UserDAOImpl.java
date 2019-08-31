package com.p2.user;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.p2.highlander.HighConn;

public class UserDAOImpl implements UserDAO {

	@Override
	public void insertUser(User u) {

		try {
			PreparedStatement ps = HighConn.conn.prepareStatement("INSERT INTO ERS_USERS VALUES(?,?,?,?,?,?)");
			ps.setString(1, u.getUsername());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getFirstname());
			ps.setString(4, u.getLastname());
			ps.setString(5, u.getEmail());
			ps.setString(6, u.getRole());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User selectUserByUsernameAndPassword(String name, String pass) {

		User u = null;
		try {
			PreparedStatement ps = HighConn.conn.prepareStatement("SELECT * FROM ERS_USERS WHERE REIU_USERNAME = ? AND REIU_PASSWORD = ?");
			ps.setString(1, name);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				u = new User(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return u;

	}
}