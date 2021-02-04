package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
				 pw.println("<h1 style='color:red;text-align:center'> All cookies are </h1>");
				Cookie cookies[] = req.getCookies();
				for(Cookie ck:cookies) {
					pw.println("<br><b> "+ck.getName()+"   "+ck.getValue()+" </b>");
				}
			
				
				String f1= req.getParameter("f2t1");
				String f2= req.getParameter("f2t2");
				//write b.logic
				
				
				pw.println("<h1>"+f1+"  "+f2+"  "+"</h1>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
