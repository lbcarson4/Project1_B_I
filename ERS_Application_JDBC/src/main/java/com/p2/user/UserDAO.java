package com.p2.user;

public interface UserDAO {

	public void insertUser(User u);
	public User selectUserByUsername(String username);
	public User selectUserByUsernameAndPassword(String username, String password);
	public User selectUserByRole(String role);
	public User selectAllUsers();	
}