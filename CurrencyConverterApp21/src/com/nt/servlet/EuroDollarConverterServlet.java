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


@WebServlet("/eurourl")
public class EuroDollarConverterServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw= res.getWriter();
		//set ContentType
		res.setContentType("text/html");
		//read form data
		float value= Float.parseFloat(req.getParameter("currency"));
		//B.logic
		float euroAmt=value/89.0f;
		pw.println("<h1 style='color:red;text-align:center'> Converted amount is = "+ euroAmt+" of indian rupess "+value+"</h1>");
		pw.println("<h1 style='color:red;> <a href='input.html'>home</a></h1>");
		
		ServletContext sc1=getServletContext();
		ServletContext sc2=sc1.getContext("/USDollarConverterApp22");
		RequestDispatcher rd = sc2.getRequestDispatcher("/dollarurl");
		rd.include(req, res);
		pw.close();
	}
	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
		
	}//doPost(-,-)
}//doclass(-,-)
