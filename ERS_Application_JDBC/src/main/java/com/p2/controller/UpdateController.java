package com.p2.controller;

import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import com.p2.reimbursment.Reimbursement;
import com.p2.reimbursment.ReimbursementDAOImpl;
import com.p2.user.User;

public class UpdateController {

	public static String Update(HttpServletRequest request) {
		
		//getting the session that was set upon login in LoginController
		ReimbursementDAOImpl reimDAOImpl = new ReimbursementDAOImpl();
		String id = request.getParameter("id");
		Reimbursement reim = reimDAOImpl.selectReimbursmentById(Integer.parseInt(id));
		User user = (User) request.getSession().getAttribute("User");
		
		Date date= new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		String status = request.getParameter("status");
		
		reim.setResolved(ts);
		reim.setStatus(status);
		reim.setResolver(user.getUsername());
		reimDAOImpl.updateReimbursmentByStatus(reim);
		
		return "/start_page_fm.html";
	}
	
}