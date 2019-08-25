package com.p2.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RequestHelper {

	public static String process(HttpServletRequest request, HttpServletResponse response) {
		
		switch(request.getRequestURI()) {
		
		case "/ERS_Application_JDBC/Login.do":
			return LoginController.Login(request);
			
		case "/ERS_Application_JDBC/Create.do":
			return CreateController.Create(request);
			
		case "/ERS_Application_JDBC/Update.do":
			return UpdateController.Update(request);
			
		case "/ERS_Application_JDBC/TableView.do":
			return TableViewController.View(response);
			
		default:
			return "/index.html";
		}
	}
}