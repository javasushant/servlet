package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HtmlServlet extends HttpServlet {
	static {
		System.out.println("HtmlServlet static block");
	}
	public HtmlServlet() {
		System.out.println("HtmlServlet.HtmlServlet() 0-prama");
	}
	@Override
	public void init(ServletConfig cg) throws ServletException {
		System.out.println("HtmlServlet.init() initialization");
		System.out.println("db user name ::  "+cg.getInitParameter("dbuser"));
		System.out.println("db pwd name ::  "+cg.getInitParameter("dbpwd"));
	}
	@Override
	public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		System.out.println("HtmlServlet.service(-,-)");
		  PrintWriter pw=null;
       //get PrintWriter 
		 pw=res.getWriter();
		 //set response content type
		 res.setContentType("text/html");
		 //write b.logic 
		 pw.println("<table border='1'  style='color:red'>");
		 pw.println("<tr> <th>Cricketer name  </th> <th> Role </th> <th> JersyNo </th> <th> NickName  </th> </tr>");
       pw.println("<tr> <td> Kohli </td> <td> captain </td> <td> 18</td> <td>Run Machine </td> </tr>");
		 pw.println("<tr> <td> Dhoni </td> <td> Ass.Captain </td> <td> 7</td> <td>Mr.Cool </td> </tr>");
		 pw.println("<tr> <td> Rohit </td> <td> Vice.Captain </td> <td> 45</td> <td> Hit Man </td> </tr>");
		 pw.println("<tr> <td> Panth </td> <td> Ameture Batsman </td> <td> 17</td> <td> WrostFellow </td> </tr>");
		 pw.println("</table>");
		 //close stream
		 pw.close();
	}
}
