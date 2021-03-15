
<%! 

	public void jspInit(){
	ServletConfig cg = getServletConfig();
	ServletContext sc = getServletContext();
	
	String dbuser = cg.getInitParameter("dbuser");
	String driver = sc.getInitParameter("driver");
}
%>

life cycle details <%= config.getInitParameter("dbuser") 
														%><br>
life cycle details<%=application.getInitParameter("driver") %>