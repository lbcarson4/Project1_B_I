package com.p2.user;

public interface UserDAO {

	public void insertUser(User u);
	public User selectUserByUsernameAndPassword(String username, String password);
}