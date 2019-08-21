package com.p2.controller;

import javax.servlet.http.HttpServletRequest;

import com.p2.user.User;
import com.p2.user.UserDAOImpl;

public class LoginController {

	public static String Login(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		User user = new User(username, password);
		
		user = userDAOImpl.selectUserByUsernameAndPassword(username, password);
		//we are retrieving an existing record by the pet's name
		//that the user provided on the login page and storing it into 
		//a pet object
		System.out.println(user);
		
		if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			//we are setting the session to the current logged in pet
			request.getSession().setAttribute("User", user);
			
			return "/start_page.html";
		}
		
		return "/index.html";		
		
	}
}