package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/headurl")
public class HeaderServlet extends HttpServlet {
       
    
 
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get prnt Writer
		PrintWriter pw= res.getWriter();
		//set contenttype
		res.setContentType("text/html");
		
		pw.println("<marquee><h1>welcome to my page page"+new Date()+"</h1></marquee>");
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
