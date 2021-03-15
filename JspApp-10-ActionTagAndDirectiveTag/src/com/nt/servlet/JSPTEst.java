package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/testurl")
public class JSPTEst extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//SetContentType
		res.setContentType("text/html");
		//Get printWriter obj
		PrintWriter pw = res.getWriter();
		
		pw.println("Servlet response page "+new Date());
	}
}
