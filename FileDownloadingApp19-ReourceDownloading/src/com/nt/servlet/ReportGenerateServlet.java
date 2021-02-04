package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;


@WebServlet("/reporturl")
public class ReportGenerateServlet extends HttpServlet {
	private  static final String  GET_PROFILES_QUERY = "SELECT  PID,NAME,ADDRS,RESUME,PHOTO FROM  PERSON_PROFILE";
	@Resource(name="DsJndi")
	private DataSource ds;
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get PrintWriter
		PrintWriter pw= res.getWriter();
		//set ConentType
		res.setContentType("text/html");
		//establish a connection 
		try(Connection con = ds.getConnection()){
			try(PreparedStatement ps = con.prepareStatement(GET_PROFILES_QUERY)){
				try(ResultSet rs= ps.executeQuery(GET_PROFILES_QUERY)){
					//display ResultSet record as Html table content (report)
					pw.println("<h1 style ='color:red;text-align:ceneter'>Report Generation</h1>");
					pw.println("<table align='ceneter' bgcolor='cyan'>");
					pw.println("<tr> <td>PID</td> <td>PNAME</td><td>PADDRS</td><td>RESUME</td><td>PHOTO</td></tr>");
					while(rs.next()) {
						pw.println("<tr>");
							pw.println("<td>"+rs.getInt(1)+"</td><td>"+rs.getString(2)+"</td><td>"+rs.getString(3)+"</td><td>"+rs.getString(4)+"</td><td>"+rs.getString(5)+"</td>");
						pw.println("</tr>");
					}//while
					pw.println("</table>");
				}//try3
			}//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		pw.close();
	}//doGet(-)
	


	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
