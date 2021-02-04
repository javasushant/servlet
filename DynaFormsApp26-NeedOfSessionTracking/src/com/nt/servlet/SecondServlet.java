package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/secondurl")
public class SecondServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print writer stream
				PrintWriter pw= res.getWriter();
				//setContentType 
				res.setContentType("text/html");
				
		//read form1.html page
				String nm= req.getParameter("name");
				String ft= req.getParameter("father");
				
				/*
				 * String hname=req.getParameter("hname"); String
				 * hfname=req.getParameter("hfname"); String ms1=req.getParameter("ms2");
				 */
				
				String f1= req.getParameter("f2t1");
				String f2= req.getParameter("f2t2");
				//write b.logic
				pw.println("<h1>"+nm+"  "+ft+"  "+"</h1>");
				
				/* pw.println("<h1>"+hname+"  "+hfname+"  "+ms1+"</h1>"); */
				
				pw.println("<h1>"+f1+"  "+f2+"  "+"</h1>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
