package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;

public class LCTestServlet extends HttpServlet {
	static {
		System.out.println("LCTestServlet:: static block");
	}
	
	public LCTestServlet() {
		System.out.println("LCTestServlet.0-param constructor");
	}
	
	public   void init(ServletConfig cg) {
		System.out.println("LCTestServlet.init(-)");
		System.out.println("db user name ::  "+cg.getInitParameter("dbuser"));
		System.out.println("db pwd name ::  "+cg.getInitParameter("dbpwd"));
	}
	
	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		  System.out.println("LCTestServlet.service(-,-)");
		  //get PrintWriter 
		 PrintWriter pw = res.getWriter();
		  //set response content type
		  res.setContentType("text/html");
		  //write b.logic
		  pw.println("<h1 style='color:red;text-align:center'>Date and Time ::"+new java.util.Date()+"</h1>");
		  ServletConfig cg =null;
		  pw.println("db user name :: "+cg.getInitParameter("dbuser"));
		  //close stream
		  pw.close();
		 
	}//service
	@Override
	public void destroy() {
		System.out.println("LCTestServlet.destroy()");
	}
}//class
