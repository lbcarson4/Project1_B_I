package com.p2.controller;

import javax.servlet.http.HttpServletRequest;

import com.p2.user.User;
import com.p2.user.UserDAOImpl;

public class LoginController {

	public static String Login(HttpServletRequest request) {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDAOImpl userDAOImpl = new UserDAOImpl();
		User user = new User();		
		user = userDAOImpl.selectUserByUsernameAndPassword(username, password);
		
		//runs if user is empty
		if (user == null) {
			return "/index.html";
		}
		
		//determines if user is employee or financial_manager
		if(username.equals(user.getUsername()) && password.equals(user.getPassword())) {
			request.getSession().setAttribute("User", user);
			if (user.getRole().equals("EMPLOYEE")) {
				return "/start_page.html";
			} else if (user.getRole().equals("F_N")) {
				return "/start_page_fm.html";
			}
		}
		
		return "/index.html";		
		
	}
}