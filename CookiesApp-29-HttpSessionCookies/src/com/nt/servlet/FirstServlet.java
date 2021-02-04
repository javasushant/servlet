package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
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
			Cookie ckt1 = new Cookie("p1",name);
			Cookie ckt2 = new Cookie("p2",father);
			Cookie ckt3 = new Cookie("p3",ms2);
			ckt3.setMaxAge(2*60);
			res.addCookie(ckt1);res.addCookie(ckt2);res.addCookie(ckt3);
			
			Cookie ckt4 = new Cookie("p4","value 1");
			Cookie ckt5 = new Cookie("p5","value 2");
			ckt4.setMaxAge(2*60);
			ckt5.setMaxAge(2*60);
			res.addCookie(ckt4);
			res.addCookie(ckt5);
			
			pw.println("<tr><td> Submition : </td><td><input type='submit' value='submit'></td></tr>");
			

			pw.println("</table>");
			pw.println("</form>");
		} else {
			pw.println("<b><h1 style='color:red;text-align:center'>Married Person Life Details in Form2</h1></b>");
			pw.println("<form action='secondurl' method='post'>");
			pw.println("<table border='1' bgcolor='cyan' align='center'>");
			pw.println("<tr><td>When to marry : </td><td><input type='text' name='f2t1'></td></tr>");
			pw.println("<tr><td>Why to marry : </td><td><input type='text' name='f2t2'></td></tr>");
			
			Cookie ckt1 = new Cookie("p1","name");
			Cookie ckt2 = new Cookie("p2","father");
			Cookie ckt3 = new Cookie("p3","ms2");
			ckt3.setMaxAge(2*60);
			res.addCookie(ckt1);res.addCookie(ckt2);res.addCookie(ckt3);
			
			Cookie ckt4 = new Cookie("p4","value 1");
			Cookie ckt5 = new Cookie("p5","value 2");
			ckt4.setMaxAge(2*60);
			
			ckt5.setMaxAge(2*60);
			res.addCookie(ckt4);
			res.addCookie(ckt5);
			
			pw.println("<tr><td> Submition : </td><td><input type='submit' value='submit'></td></tr>");
			
			pw.println("</table>");
			pw.println("</form>");
		}
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
