package com.nt.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nt.dto.StudentDTO;
import com.nt.service.IStudentMgmtService;
import com.nt.service.StudentMgmtServiceImpl;

public class MainControllerServlet extends HttpServlet {
	//create object for Service class 
	private IStudentMgmtService service;
	
	public void init() {
		System.out.println("MainControllerServlet.init()");
		try {
			service = new StudentMgmtServiceImpl();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//get print stream from req obj
		PrintWriter pw = res.getWriter();
		//set content type
		res.setContentType("text/html");
		//form data
		String name = req.getParameter("sname");
		String addrs = req.getParameter("sadd");
		int marks1= Integer.parseInt(req.getParameter("marks1"));
		int marks2= Integer.parseInt(req.getParameter("marks2"));
		int marks3= Integer.parseInt(req.getParameter("marks3"));
		
		//set dto class obj
		StudentDTO dto = new StudentDTO();
		dto.setSname(name);
		dto.setSadd(addrs);
		dto.setMarks1(marks1);
		dto.setMarks2(marks2);
		dto.setMarks3(marks3);
		
		
		//use service class
		try {
			String result = service.generateResult(dto);
			pw.println("<h1 style = 'color:red;bgcolor:gray;text-align:center'> Result is : "+result+" "+name+"</h1>" );
		} catch (Exception e) {
			pw.println("<h1 style = 'color:red;bgcolor:gray;text-align:center'> problem in Student registration</h1>" );
			e.printStackTrace();
		}
		
		//add home hyperlink
		pw.println("<h1><br><br><a href='Student_register.html'>home</a></h1>");
		//close stream
		pw.close();
	}
	
	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(req, res);
	}
		
}
