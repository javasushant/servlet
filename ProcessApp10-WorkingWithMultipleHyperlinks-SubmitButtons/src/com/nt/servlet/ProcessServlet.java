package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ProcessServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// set response content type
		res.setContentType("text/html");
		//get a print writer stream from res obj
		PrintWriter pw = res.getWriter();
		//read special request param
		String pval = req.getParameter("s1");
		//read form data only for submit buttons generated  request
		float val1=0,val2=0;
		if(!pval.equalsIgnoreCase("link1") && !pval.equalsIgnoreCase("link2")) {
			val1 = Float.parseFloat(req.getParameter("t1"));
			val2 = Float.parseFloat(req.getParameter("t2"));
		}
		 if(pval.equalsIgnoreCase("add")) {
			pw.println("<h1 style = 'color:red;text-align:center'> Addition (sum) is  "+(val1+val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("sub")) {
			pw.println("<h1 style = 'color:red;text-align:center'> Substraction (sub) is  "+(val1 - val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("mul")) {
			pw.println("<h1 style = 'color:red;text-align:center'> Multiplication (mul) is  "+(val1 * val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("div")) {
			pw.println("<h1 style = 'color:red;text-align:center'> Division (Div) is  "+(val1/val2)+"</h1>");
		}
		else if(pval.equalsIgnoreCase("link1")) {
			pw.println("<h1 style = 'color:red;text-align:center'> Sys Date and Time  :   "+ new Date()  +"</h1>");
		}
		else {
			pw.println("<h1 style = 'color:red;text-align:center'> System Property  "+System.getProperti es()  +"</h1>");
		}
		pw.println("<br><br> <a href='input.html'>home </a>");
		//close stream
		pw.close();
	}//doGet()
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
