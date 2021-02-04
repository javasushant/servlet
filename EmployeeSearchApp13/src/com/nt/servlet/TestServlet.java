package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printWriter
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		//get Access ServletConfig obj
		ServletConfig cg = getServletConfig();
		pw.println("<br> TestServlet :: dbuser init value: "+cg.getInitParameter("dbuser"));
		pw.println("<br> Servlet class object name : "+cg.getServletName());
		pw.println("<br> Servletconfig object name : "+cg.getClass());
		
		//close stream
		pw.close();
		
	}//doGet(-)
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}
}
