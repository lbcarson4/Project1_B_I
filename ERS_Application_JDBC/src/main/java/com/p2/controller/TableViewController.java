package com.p2.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.p2.reimbursment.Reimbursement;
import com.p2.reimbursment.ReimbursementDAOImpl;

public class TableViewController {
	
	private final static Logger loggy = Logger.getLogger(TableViewController.class);
	
	public static String View(HttpServletResponse response) {
		
		ReimbursementDAOImpl reimDAOImpl = new ReimbursementDAOImpl();
		List<Reimbursement> reims = reimDAOImpl.selectAllReimbursments();
		
		try {
			response.getWriter().write(new ObjectMapper().writeValueAsString(reims));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		loggy.info("Reimbursement infomation was pulled from the database.");
		
		return "/view_reim.html";
	}
}