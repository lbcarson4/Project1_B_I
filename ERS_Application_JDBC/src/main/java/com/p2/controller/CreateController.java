package com.p2.controller;

import java.sql.Timestamp;
import java.util.Date;
import javax.servlet.http.HttpServletRequest;
import org.apache.log4j.Logger;
import com.p2.reimbursment.Reimbursement;
import com.p2.reimbursment.ReimbursementDAOImpl;
import com.p2.user.User;

public class CreateController {
	
	private final static Logger loggy = Logger.getLogger(CreateController.class);

	public static String Create(HttpServletRequest request) {

		String amount = request.getParameter("amount");
		String type = request.getParameter("type");
		String description = request.getParameter("description");
		
		Date date= new Date();
		long time = date.getTime();
		Timestamp ts = new Timestamp(time);
		
		User user = (User) request.getSession().getAttribute("User");
		Reimbursement reim = new Reimbursement();
		
		reim.setAmount(Integer.parseInt(amount));
		reim.setType(type);
		reim.setDescription(description);
		reim.setSubmitted(ts);
		reim.setAuthor(user.getUsername());
		reim.setStatus("PENDING");
		
		ReimbursementDAOImpl reimDAOImpl = new ReimbursementDAOImpl();
		reimDAOImpl.insertReimbursment(reim);
		loggy.info(user.getUsername() + " created a reimbursement.");

		return "/start_page.html";
	}
}