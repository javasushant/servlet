package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet( value = "/employeeurl", initParams = {@WebInitParam
		(name="jdbcurl" ,value="jdbc:oracle:thin:@localhost:1521:SYS"),
		@WebInitParam(name="jdbcclass" , value="oracle.jdbc.driver.OracleDriver"),
		@WebInitParam(name="user" , value="system1"),
		@WebInitParam(name="pwd" , value="manager")
                                                      })
public class EmployeeSearchServletTest extends HttpServlet {
	private static final String GET_EMP_DETAILS="SELECT EMPNO,ENAME,JOB,SAL FROM EMP WHERE EMPNO=?";
	
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get content type
		res.setContentType("text/html");
		//get stream from res obj
		PrintWriter pw = res.getWriter();
		
		Connection con= null;
		PreparedStatement ps= null;
		ResultSet rs=null;
		int no= 0;
		
		try {
			RequestDispatcher rd= req.getRequestDispatcher("/headurl");
			rd.include(req, res);
			no= Integer.parseInt(req.getParameter("no"));
			ServletConfig cg= getServletConfig();
			String clazz = cg.getInitParameter("jdbcclass");
			String url= cg.getInitParameter("jdbcurl");
			String user= cg.getInitParameter("user");
			String pwd= cg.getInitParameter("pwd");
			//load class
			Class.forName(clazz);
			con = DriverManager.getConnection(url,user,pwd);
			//make preapared statement
			if(con!=null)
				ps= con.prepareStatement(GET_EMP_DETAILS);
			//set the query param
			if(ps!=null){
				ps.setInt(1, no);
				//execute the query
				rs= ps.executeQuery();
			}
		
			
			//process the RS object
			if(rs!=null) {
				if(rs.next()) {
					  pw.println("<h1 style='color:blue;text-align:center'>Employee details are </h1>");
					  pw.println("<br><b> Emp number:: "+rs.getInt(1)+"</b>");
					  pw.println("<br><b> Emp name:: "+rs.getString(2)+"</b>");
					  pw.println("<br><b> Emp Desg:: "+rs.getString(3)+"</b>");
					  pw.println("<br><b> Emp Salary:: "+rs.getFloat(4)+"</b>");
				  }
				else {
					pw.println("<h1 style='color:red;text-align:center'>Employee  found </h1>");
				}
				
			}//if
			RequestDispatcher rd2=req.getRequestDispatcher("/footer.html");
			rd2.include(req, res);
		}
		
		catch(SQLException se) {
//			servlet as error servlet--------------
//			RequestDispatcher rd = req.getRequestDispatcher("errurl"); //as url pattern
//			rd.forward(req, res);
			ServletContext sc = getServletContext();
//			RequestDispatcher rd = sc.getRequestDispatcher("/errurl"); //as url pattern
//			RequestDispatcher rd= sc.getNamedDispatcher("emp");
//			rd.forward(req, res);
			
//			--jsp file as error page-----------
//			RequestDispatcher rd = req.getRequestDispatcher("error.jsp"); //file name
//			RequestDispatcher rd1 = sc.getRequestDispatcher("/errjspurl"); // urlpattern
			RequestDispatcher rd1 = sc.getNamedDispatcher("errjsp");  // logicall namee
			rd1.forward(req, res);
			se.printStackTrace();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		  finally {
			  //close jdbc objs
			  try {
				  if(rs!=null)
					  rs.close();
			  }
			  catch(SQLException se) {
				  se.printStackTrace();
			  }
			  try {
				  if(ps!=null)
					  ps.close();
			  }
			  catch(SQLException se) {
				  se.printStackTrace();
			  }
			  try {
				  if(con!=null)
					  con.close();
			  }
			  catch(SQLException se) {
				  se.printStackTrace();
			  }
		  }//finally
		
		
		 pw.println("<br><br> <a href='input.html'>home </a>");
		 
		 //close stream
		 pw.close();
	}

	
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}

}
