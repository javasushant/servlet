package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/s1url")
public class Servlet1 extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		
		//set request attribute
		req.setAttribute("attr1", "val1");
		
		pw.println("<br><b> servlet-1 :: request attribute  "+req.getAttribute("attr1")+"</b>");
		System.out.println(" ");
		
		//HttSession object data pass
		HttpSession ses= req.getSession();
		ses.setAttribute("attr2", "val2");
		pw.println("<br><b> servlet-1:: Session attribute  "+ses.getAttribute("attr2")+"</b>");
		
		//Application/ServletContext attribute data pass 
		ServletContext sc=getServletContext();
		sc.setAttribute("attr3", "val3");
		pw.println("<br><b> servlet-1:: Application/ServletContext attribute  "+sc.getAttribute("attr3")+"</b>");
		
		RequestDispatcher rd= req.getRequestDispatcher("/s2url");
		rd.forward(req, res);
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}

