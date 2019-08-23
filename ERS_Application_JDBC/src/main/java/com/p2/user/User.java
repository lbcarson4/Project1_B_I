package com.p2.user;

public class User {

	String username, password, firstname, lastname, email, role;
	
	public User() {}

	public User(String username, String password, String firstname, String lastname, String email, String role) {
		this.username = username;
		this.password = password;
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.role = role;
	}
	
	public String getUsername() {return username;}
	public void setUsername(String username) {this.username = username;}
	public String getPassword() {return password;}
	public void setPassword(String password) {this.password = password;}
	public String getFirstname() {return firstname;}
	public void setFirstname(String firstname) {this.firstname = firstname;}
	public String getLastname() {return lastname;}
	public void setLastname(String lastname) {this.lastname = lastname;}
	public String getEmail() {return email;}
	public void setEmail(String email) {this.email = email;}
	public String getRole() {return role;}
	public void setRole(String role) {this.role = role;}

	@Override
	public String toString() {
		return "User [username=" + username + ", password=" + password + ", firstname=" + firstname + ", lastname="
				+ lastname + ", email=" + email + ", role=" + role + "]";
	}	
}