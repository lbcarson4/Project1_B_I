package com.p2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static String process(HttpServletRequest request, HttpServletResponse response) {
		
		switch(request.getRequestURI()) {
		//depending on the URI that comes with the request, this 
		//method chooses the corresponding controller and calls
		//the method within that controller
		
		case "/ERS_Application_JDBC/Login.do":
			return LoginController.Login(request);
			
		default:
			return "/index.html";
		}
	}
}