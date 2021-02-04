package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/dollarurl")
public class USDollarConverterServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		//get PrintWriter
				PrintWriter pw= res.getWriter();
				//set ContentType
				res.setContentType("text/html");
				//read form data
				float value= Float.parseFloat(req.getParameter("currency"));
				//B.logic
				float dollarAmt=value/76.0f;
				pw.println("<h1 style='color:red;text-align:center'> Converted amount is = "+ dollarAmt+" of indian rupess "+value+"</h1>");
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
