package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Locale;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LinkServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("EligiblityServlet.doGet(-,-)");
		//set content type for response object
		res.setContentType("text/html");
		//import Print writer from res object
		PrintWriter pw = res.getWriter();
		//read special request param value
		String val = req.getParameter("s1");
		//get All available locales
		Locale locales[] = Locale.getAvailableLocales();
		
		if(val.equalsIgnoreCase("link1")) {
			pw.println("All language  ::");
			for(Locale l:locales) {
				pw.println("<br><b>"+l.getDisplayLanguage()+"<b>");
			}
		}//if
		else if(val.equalsIgnoreCase("link2")) {
			pw.println("All Countries");
			for(Locale l :locales) {
				pw.println("<br><b>"+l.getDisplayCountry()+"<b>");
			}
		}// else if
		else {
			pw.println("System properties  ::  "+System.getProperties());
		}
		
		pw.println("<br><br><a href = 'links.html'>home</a>");
		pw.close();
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doPost(req, res);
	}
}
