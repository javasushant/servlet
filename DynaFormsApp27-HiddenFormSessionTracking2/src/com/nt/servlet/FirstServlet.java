package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/firsturl")
public class FirstServlet extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		// get print writer stream
		PrintWriter pw = res.getWriter();
		// setContentType
		res.setContentType("text/html");

		// reading form1.html page
		String name = req.getParameter("name");
		String father = req.getParameter("father");
		String ms2 = req.getParameter("ms");
		// write b.logic
		if (ms2.equalsIgnoreCase("married")) {
			pw.println("<b><h1 style='color:red;text-align:center'>Married Person Life Details in Form2</h1></b>");
			pw.println("<form action='secondurl' method='post'>");
			pw.println("<table border='1' bgcolor='cyan' align='center'>");
			pw.println("<tr><td>Spouse Name : </td><td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>NO. of kids : </td><td><input type='text' name='f2t2'></td></tr>");
			
			pw.println("<tr><td><input type='hidden' name='hname' value='"+name+"'></td></tr>");
			pw.println("<tr><td><input type='hidden' name='hfname' value ='"+father+"'></td></tr>");
			pw.println("<tr><td><input type='hidden' name='hms' value='" +ms2+ "'></td></tr>");
			
			pw.println("<tr><td> Submition : </td><td><input type='submit' value='submit'></td></tr>");
			

			pw.println("</table>");
			pw.println("</form>");
		} else {
			pw.println("<b><h1 style='color:red;text-align:center'>Married Person Life Details in Form2</h1></b>");
			pw.println("<form action='secondurl' method='post'>");
			pw.println("<table border='1' bgcolor='cyan' align='center'>");
			pw.println("<tr><td>When to marry : </td><td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>Why to marry : </td><td><input type='text' name='f2t2'></td></tr>");
			
			pw.println("<tr><td><input type='hidden' name='hname' value='"+name+"'></td></tr>");
			pw.println("<tr><td><input type='hidden' name='hfname' value ='"+father+"'></td></tr>");
			pw.println("<tr><td><input type='hidden' name='hms' value='" +ms2+ "'></td></tr>");
			pw.println("<tr><td> Submition : </td><td><input type='submit' value='submit'></td></tr>");
			pw.println("</table>");
			pw.println("</form>");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
