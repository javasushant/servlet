package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.EmployeeDTO;
import com.nt.service.EmployeeServiceMgmtImpl;
import com.nt.service.IEmployeeServiceMgmt;
@WebServlet("/controller")
public class MainControllerTest extends HttpServlet {
	private IEmployeeServiceMgmt emp;
	public void init() {
		try {
			emp=new EmployeeServiceMgmtImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		//get printWriter obj
		PrintWriter pw = res.getWriter();
		//read form data
		String Ename = req.getParameter("Ename");
		String Eadd = req.getParameter("Eadd");
		int basicSal = Integer.parseInt(req.getParameter("basicSal"));
		int hra = Integer.parseInt(req.getParameter("hra"));
		
		//create dto class obj
		EmployeeDTO dto = new EmployeeDTO();
		dto.setEname(Ename);
		dto.setEadd(Eadd);
		dto.setBasicSal(basicSal);
		dto.setHra(hra);
		
		//use main srervice class
		String result = null;
		try {
			result = emp.getService(dto);
			pw.println("<h1> RESULT IS SUBMITTED </h1>");
		}
		catch(Exception e) {
			pw.println("<h1> RESULT IS Not SUBMITTED </h1>");
			e.printStackTrace();
		}
		// Add home hyperlink
		pw.println("<a href = 'input.html'>HOME</a>");
		//close stream
		pw.close();
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req, res);
	}
}
