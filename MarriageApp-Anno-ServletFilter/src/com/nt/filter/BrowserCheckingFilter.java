package com.nt.filter;

import java.io.IOException;

import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebFilter("/marriageurl")
public class BrowserCheckingFilter extends HttpFilter {
	static{
		System.out.println("BrowserCheckingFilter.Class Loading");
	}
	public BrowserCheckingFilter() {
		
		System.out.println("BrowserCheckingFilter:0-param constructor");
	}
	@Override
	public void init() throws ServletException {
		System.out.println("BrowserCheckingFilter.initialization");
	}
	@Override
	public void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		System.out.println("BrowserCheckingFilter.doFilter()");
		String browser=req.getHeader("user-agent");
		if(!browser.contains("Chrome")) {
			//get PrintWriter 
			PrintWriter pw=res.getWriter();
			pw.println("<h1 style='color:red;text-align:center'>Request must be given from Chrome browser </h1>");
			 return;
		}
		else {
			System.out.println("BrowserCheckingFilter.Before.doFilter()");
			chain.doFilter(req, res);
			System.out.println("BrowserCheckingFilter.After.doFilter()");
		}//else
	}//doFilter(-,-)
	@Override
	public void destroy() {
		System.out.println("BrowserCheckingFilter.destroy()");
	}
}
