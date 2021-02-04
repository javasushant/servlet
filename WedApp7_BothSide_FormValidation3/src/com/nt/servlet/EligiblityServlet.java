package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EligiblityServlet extends HttpServlet {
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type for response object
		res.setContentType("text/html");
		//import Print writer from res object
		PrintWriter pw = res.getWriter();
		
		//set the form data for request object
		String name =req.getParameter("pname");
		String tage = req.getParameter("page");
//		int age = Integer.parseInt(req.getParameter("page"));
		String gender = req.getParameter("gender");
		String vStatus = req.getParameter("vFlag");
		
		// execute server side from validation logic when client form validation is n ot done
		int age= 0;
		if(vStatus.equalsIgnoreCase("no")) {
			// server side form validation	
		List<String> errList = new ArrayList();
		
		System.out.println(" WedApp doPost(-,-) form validation logic is executed ");
		if(name==null || name.equals("") || name.length()==0) {
			errList.add("Enter person valid name ");
		}
		else if(name.length()<4) {
			errList.add("person name must have 5 character");

		}
		
		if(tage==null || tage.equals("") || tage.length()==0) {
			errList.add("Enter age numeric value");
		}
		else {
			try {
				age = Integer.parseInt(tage); // numeric value
				if(age<1 || age>125) {// age range
					errList.add("Person age must be in the range of 1 to 125");
				}//if
			}//try
			catch(NumberFormatException nfe) {
				errList.add("Person age must be in numeric value");
			}
		}//else
		// Display form validation error message
		if(!errList.isEmpty()) {
			errList.forEach(msg->{  // java8 foEach() method with Lambda Expression
				pw.println("<li><span style = 'color:red'>"+msg+"</span></li>");
			});
			return ;
		}//if
		}//if
		else {
			 age = Integer.parseInt(tage);
		}//else
		
		// write the b.logic or execute processing 
		System.out.println(" B.logic execution ");
		if(gender.equalsIgnoreCase("M")) {
			if(age<21)
				pw.println("<h1 style = 'background-color:cyan ; text-align:center'>  Line 1  Mr  "  +name+" u r not eligible to get married </h1>");
			else
				pw.println("<h1 style = 'background-color:aqua ; text-align:center'>Line  2  Mr  "+name+" u r  eligible to get marry but think twice </h1>");
			
		}
		else {
			if(age<18)
				pw.println("<h1 style = 'background-color:cyan ; text-align:center'> Line 3   Ms  "  +name+" u r not eligible to get married but think once</h1>");
			else
				pw.println("<h1 style = 'background-color:aqua ; text-align:center'>Line 4  Ms  "+name+" u r eligible to marry but think thrice</h1>");
			
		}
		pw.println("name  :"+name+"   age  :"+age+"   gender    "+gender);
		pw.println("<br><a href  = 'input.html'>Home</a>");
		pw.close();
	}//dopost

}
