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


@WebServlet("/s3url")
public class Servlet3 extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get printwriter
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		
		pw.println("<br><b> servlet-3 :: request attribute  "+req.getAttribute("attr1")+"</b>");
		System.out.println(" ");
		//HttSession object data pass
		HttpSession ses= req.getSession();
		pw.println("<br><b> servlet-3:: Session attribute  "+ses.getAttribute("attr2")+"</b>");
		
		//Application/ServletContext attribute data pass
		ServletContext sc=getServletContext();
//		sc.setAttribute("attr3", "val3");
		pw.println("<br><b> servlet-3:: Application/ServletContext attribute  "+sc.getAttribute("attr3")+"</b>");
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
