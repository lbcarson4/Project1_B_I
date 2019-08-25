package com.p2.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.http.HttpServletResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.p2.reimbursment.Reimbursement;
import com.p2.reimbursment.ReimbursementDAOImpl;

public class TableViewController {
	
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
		return "/view_reim.html";
	}
}