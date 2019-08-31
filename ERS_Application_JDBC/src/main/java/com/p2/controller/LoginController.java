package com.p2.controller;

import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import com.p2.encrypt.EncryptPassword;
import com.p2.user.User;
import com.p2.user.UserDAOImpl;

public class LoginController {
	
	//logger
	private final static Logger loggy = Logger.getLogger(LoginController.class);

	public static String Login(HttpServletRequest request) {
		
		//declaring Variables
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		User user = new User();
		String key = "Clemson";
		
		//this is for inserting users
		//User user2 = new User("lbcarson5", "lbc5", "Lester", "Carson", "lbcarson4@gmail.com", "EMPLOYEE");
		//user2.setPassword(EncryptPassword.encrypt(user2.getPassword(), "Clemson"));
		//userDAOImpl.insertUser(user2);
		
		//selects user from the database using a username and the encrypted password
		user = userDAOImpl.selectUserByUsernameAndPassword(username, EncryptPassword.encrypt(password, key));
		
		//checks if user is empty
		if (user == null) {
			return "/index.html";
		}
		
		//decrypts the password
		user.setPassword(EncryptPassword.decrypt(user.getPassword(), key));
		
		//determines if user is employee or financial_manager
		if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			request.getSession().setAttribute("User", user);
			if (user.getRole().equals("EMPLOYEE")) {
				loggy.info(user.getUsername() + " who is a " + user.getRole() + " logged in to the system.");
				return "/start_page.html";
			} else if (user.getRole().equals("F_M")) {
				loggy.info(user.getUsername() + " who is a " + user.getRole() + " logged in to the system.");
				return "/start_page_fm.html";
			}
		}
		
		return "/index.html";		
		
	}
}