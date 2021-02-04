package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(value="/test1")
//@WebServlet(value={"/test1","/test2"})
//@WebServlet({"/test1","/test2"})
//@WebServlet(urlPatterns={"/test1","/test2"})
//@WebServlet(name="Pool" ,value={"/test1","/test2"})
@WebServlet(name="Pool" ,value={"/test1","/test2"}, loadOnStartup = 1)
public class AnnotationBasedTest extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		System.out.println("AnnotationBasedTest.init()");
	}
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//setcontent type
		res.setContentType("text/html");
		//get printWriter stream
		PrintWriter pw = res.getWriter();
		ServletConfig cg = getServletConfig();
		
		//b.logic
		pw.println("<h1>"+ new java.util.Date()+"  "+cg.getServletName()+"</h1>");
	}
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
