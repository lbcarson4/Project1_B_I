package com.p2.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.p2.controller.RequestHelper;

public class MasterServlet extends HttpServlet{
	
	private static final long serialVersionUID = -9067681520893503894L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		RequestHelper.process(req, res);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res)
		throws ServletException, IOException{
		
		String targetURL = RequestHelper.process(req, res);
		req.getRequestDispatcher(targetURL).forward(req, res);
	}
}