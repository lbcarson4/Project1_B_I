package com.p2.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.p2.reimbursment.Reimbursement;
import com.p2.reimbursment.ReimbursementDAOImpl;
import com.p2.user.User;

public class TableViewController {
	
	private final static Logger loggy = Logger.getLogger(TableViewController.class);
	
	public static String View(HttpServletRequest request, HttpServletResponse response) {
		
		//Declared Variables
		List<Reimbursement> reims = null;
		ReimbursementDAOImpl reimDAOImpl = new ReimbursementDAOImpl();
		User user = (User) request.getSession().getAttribute("User");
		
		//Sorts what reimbursements you will get back, based on user role
		if (user.getRole().equals("EMPLOYEE")) {
			reims = reimDAOImpl.selectReimbursmentByAuthor(user.getUsername());
		} else if (user.getRole().equals("F_M")) {
			reims = reimDAOImpl.selectAllReimbursments();
		}
		
		//sends retrieved data from the database to the front end
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(reims));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		loggy.info("Reimbursement infomation was pulled from the database.");
		
		//redirects user to a different view table page based on the user role
		if (user.getRole().equals("EMPLOYEE")) {
			return "/view_reim.html";
		} else if (user.getRole().equals("F_M")) {
			return "/view_reim_fm.html";
		}
		
		return "/index.html";
	}
}