package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


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
				
				HttpSession ses = req.getSession();
				String hname = (String) ses.getAttribute("name");
				String father = (String) ses.getAttribute("father");
				String ms1 = (String) ses.getAttribute("ms");
				
				
				String f1= req.getParameter("f2t1");
				String f2= req.getParameter("f2t2");
				//write b.logic
				pw.println("<h1>"+nm+"  "+ft+"  "+"</h1>");
				
				pw.println("<h1>"+hname+"  "+father+"  "+ms1+"</h1>");
				pw.println("Session id : "+ses.getId());
				long ms=ses.getCreationTime();
				Date d = new Date(ms);
				pw.println("<br> Session created time : "+d);
				long ms3= ses.getLastAccessedTime();
				Date d2 = new Date(ms3);
				pw.println("<br> Session last accesed time: "+d2);
				pw.println("<br>  Session max inactive time : "+ses.getMaxInactiveInterval());
				
				pw.println("<h1>"+f1+"  "+f2+"  "+"</h1>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
