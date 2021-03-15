package com.nt.filter;

import java.io.IOException;

import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/marriageurl")
public class TimingCheckingFilter extends HttpFilter {
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		//system Date and Time
		LocalDateTime sysDate= LocalDateTime.now();
		//get Current hour
		int hour=sysDate.getHour()+1;
		if(hour<8 || hour>16) {
			//get printWritter
			PrintWriter pw=res.getWriter();
			//set response content type
			res.setContentType("text/html");
			//b.logic
			pw.println("<h1 style='color:red;text-align:center'>Request must be given between 9Am to 4 PM </h1>");
			return;
		}//if
		else {
			System.out.println("TimingCheckingFilter.before.foFilter(-,-)");
			chain.doFilter(req, res);
			System.out.println("TimingCheckingFilter.After.doFilter()");
		}//else
	}//dofilter
}//class
