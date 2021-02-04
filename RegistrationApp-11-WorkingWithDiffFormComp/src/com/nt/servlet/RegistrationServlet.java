package com.nt.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegistrationServlet extends HttpServlet {
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		//set content type
		res.setContentType("text/html");
		//get printwriter stream
		PrintWriter pw = res.getWriter();
		// read form data;
		String name = req.getParameter("pname");
		int age = Integer.parseInt(req.getParameter("page"));
		String gender = req.getParameter("gender");
		String addrs = req.getParameter("paddrs");
		String ms = req.getParameter("ms");
		if(ms==null)
			ms= "Single";
		String qlfy = req.getParameter("qlfy");
		String hobbies[] = req.getParameterValues("hb");
		if(hobbies==null)
			hobbies= new String[] {"No hobbies is listed"};
		String languages[] = req.getParameterValues("languages");
		if(languages==null)
			languages = new String[] {"No languages is selected"};
		long phone = Long.parseLong(req.getParameter("phone"));
		String email=req.getParameter("email");
		int favNumber=Integer.parseInt(req.getParameter("favNumber"));
		String dob=req.getParameter("dob");
		String tob=req.getParameter("tob");
		String month=req.getParameter("birthMonth");
		String favColor=req.getParameter("favColor");
		long salary=Long.parseLong(req.getParameter("salary"));
		String fburl=req.getParameter("fburl");
		
		//b.logic  / request processing logic
		
		
		  pw.println("<h2 style='color:blue'>The submitted Details are  </h2>");
		  pw.println("<br><b> name::"+name+"</b>");
		  pw.println("<br><b> age::"+age+"</b>");
		  pw.println("<br><b> adrrs::"+addrs+"</b>");
		  pw.println("<br><b> gender::"+gender+"</b>");
		  pw.println("<br><b> Marital status::"+ms+"</b>");
		  pw.println("<br><b> Qualification::"+qlfy+"</b>");
		  pw.println("<br><b>hobies::"+Arrays.toString(hobbies)+"</b>");
		  pw.println("<br><b> languages::"+Arrays.toString(languages)+"</b>");
		  pw.println("<br><b> faviourite number::"+favNumber+"</b>");
		  pw.println("<br><b> faviourite color::"+favColor+"</b>");
		  pw.println("<br><b> Mobile number::"+phone+"</b>");
		  pw.println("<br><b> DOB::"+dob+"</b>");
		  pw.println("<br><b> TOB::"+tob+"</b>");
		  pw.println("<br><b> Birth Month::"+month+"</b>");
		  pw.println("<br><b> FB url::"+fburl+"</b>");
		  pw.println("<br><b> slaary::"+salary+"</b>");
		  pw.println("<br><b> email::"+email+"</b>");

		  //home hyperlink
		  pw.println("<br><br><a href='input.html'>home </a>");

		//close stream
		  pw.close();

		}//doGet(-,-)

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		doGet(req,res);
	}//doPost()
		
}//class
