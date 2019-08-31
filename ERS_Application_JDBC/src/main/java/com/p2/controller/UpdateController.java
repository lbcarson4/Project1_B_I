package com.p2.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

import com.p2.reimbursment.Reimbursement;
import com.p2.reimbursment.ReimbursementDAOImpl;
import com.p2.user.User;

public class UpdateController {
	
	private final static Logger loggy = Logger.getLogger(UpdateController.class);

	public static String Update(HttpServletRequest request) {
		
		//getting the session that was set upon login in LoginController
		//Declaring variables
		ReimbursementDAOImpl reimDAOImpl = new ReimbursementDAOImpl();
		String id = request.getParameter("id");
		String status = request.getParameter("status");
		Reimbursement reim = reimDAOImpl.selectReimbursmentById(Integer.parseInt(id));
		User user = (User) request.getSession().getAttribute("User");
		
		//Get Timestamp
		Date date= new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		
		//fills in and updates reimbursement information
		reim.setResolved(ts);
		reim.setStatus(status);
		reim.setResolver(user.getUsername());
		reimDAOImpl.updateReimbursmentByStatus(reim);
		
		loggy.info(user.getUsername() + " " + reim.getStatus() + " reimbursement with the id of " + reim.getId());
		
		return "/start_page_fm.html";
	}
	
}