package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EligiblityServlet extends HttpServlet {
	
	public void processGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("EligiblityServlet.processGet(-,-)");
		//set content type for response object
		res.setContentType("text/html");
		//import Print writer from res object
		PrintWriter pw = res.getWriter();
		
		//set the form data for request object
		String name =req.getParameter("pname");
		int age = Integer.parseInt(req.getParameter("page"));
		String gender = req.getParameter("gender");
		
		// write the b.logic or execute processing 
		pw.println("<h1 style = 'background-color:yellow ; text-align:center'> SHADI.COM </h1>");
		if(gender.equalsIgnoreCase("M")) {
			if(age<21)
				pw.println("<h1 style = 'background-color:cyan ; text-align:center'>  Line 1  Mr  "  +name+" u r not eligible to get married </h1>");
			else if(age>21 && age<60)
				pw.println("<h1 style = 'background-color:aqua ; text-align:center'>Line  2  Mr  "+name+" u r  eligible to marriage </h1>");
			
			else
				pw.println("<h1 style = 'background-color:aqua ; text-align:center'>Line  3  Mr  "+name+" u r  eligible to die </h1>");
			
		}
		else {
			if(age<18)
				pw.println("<h1 style = 'background-color:cyan ; text-align:center'> Line 4   Ms  "  +name+" u r not eligible to get married but think once</h1>");
			else if(age>18 && age<60)
				pw.println("<h1 style = 'background-color:aqua ; text-align:center'>Line  5  Mr  "+name+" u r  eligible to marry</h1>");
			
			else
				pw.println("<h1 style = 'background-color:aqua ; text-align:center'>Line 6  Ms  "+name+" u r eligible to getdie</h1>");
			
		}
		pw.println("name  :"+name+"   age  :"+age+"   gender    "+gender);
		pw.println("<br><a href  = 'input.html'>Home</a>");
		pw.close();
	}//doGet(-,-)
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("EligiblityServlet.doPost(-,-)");
		
		processGet(req,res);
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("EligiblityServlet.doGet(-,-)");
		processGet(req,res);
	}
}
