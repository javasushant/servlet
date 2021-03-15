<%@ page isELIgnored="true" %>
<% 
	String name=request.getParameter("ss");

	response.sendRedirect("https://www.google.com//search?q="+name);
%>