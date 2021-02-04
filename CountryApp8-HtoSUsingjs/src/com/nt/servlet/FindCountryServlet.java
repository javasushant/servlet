package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FindCountryServlet extends HttpServlet {
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// set content type 
		res.setContentType("text/html");
		//get a print stream from res object
		PrintWriter pw = res.getWriter();
		
		//read form data
		int countryCode = Integer.parseInt(req.getParameter("country"));
		//write b.logic / request processing logic
		String capitals[] = new String[] {"New Delhi", "Paris","Bejing","Berlin","WashingatonDC"};
		
		// write response / output  to response obj
		pw.println("<h1 style= 'color:red; text-align:center'> Capital City Name ::  "+capitals[countryCode]+"</h1>");
		pw.println("<a href ='input.html'>Home</a>");
		pw.close();
		
	}//doPost()
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, res);
	}//doGet
}
