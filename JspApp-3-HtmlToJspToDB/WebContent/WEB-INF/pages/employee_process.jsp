<%@ page isELIgnored="false"%>
<%@page import="java.sql.*"%>

<%!private Connection con;
	private PreparedStatement ps1, ps2;

	public void jspInit() {
		//get Access to servletConfig obj directly
		ServletConfig cg = getServletConfig();
		//read form data
		String driver = cg.getInitParameter("driver");
		String url = cg.getInitParameter("url");
		String user = cg.getInitParameter("username");
		String pwd = cg.getInitParameter("password");
		try {
			//load JDBC driver class
			Class.forName(driver);
			//establish connection
			con = DriverManager.getConnection(url, user, pwd);
			//create PreaperedStatement
			ps1 = con.prepareStatement("INSERT INTO JSP_EMPLOYEE VALUES(EMP_SEQ.NEXTVAL,?,?,?)");
			ps2=con.prepareStatement("SELECT EMPNO,ENAME,ADDRS,SALARY FROM JSP_EMPLOYEE");

		} catch (SQLException se) {
			se.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}%>
<%
//READ S1 REQ PARAM VALUE TO KNOW WHEATHER REQUEST HAS COME FROM SUBMIT BUTTON OR HYPERLINK

String s1Val = request.getParameter("s1");
if (s1Val.equalsIgnoreCase("register")) {
	String name = request.getParameter("ename");
	String addrs = request.getParameter("eadd");
	float salary = Float.parseFloat(request.getParameter("salary"));
	//set values to insert to Quey Param
	ps1.setString(1, name);
	ps1.setString(2, addrs);
	ps1.setFloat(3, salary);
	//execute Quey
	int result = ps1.executeUpdate();
	// process the result
	if (result == 0) {
%>
<h1 style="color: green; text-align: center">Employee details is
	not registered</h1>
<%
} //if
else {
%>
<h1 style="color: green; text-align: center">Employee registered</h1>
<%
} //else
} //if
else{
	//execute the SELECT SQL query
	ResultSet rs= ps2.executeQuery();
	//process THE RESULTSET %>
	<table border="1" bgcolor="cyan" align="center">
	<tr><td>EmpNo</td><td>Ename</td><td>EMPADDRS</td><td>Salary</td> 
	<% while(rs.next()){ %>
	<tr>
	<td><%= rs.getInt(1) %></td>
	<td><%= rs.getString(2) %></td>
	<td><%= rs.getString(3) %></td>
	<td><%= rs.getFloat(4) %></td>
	</tr>
	<% }//while
		%>
	</table>
	<%
}//else
%>
<br>
<br>
<a href="employee_form.html">home</a>
<%!
	public void jspDestroy(){
	try{
		if(ps1!=null)
			ps1.close();
	}
	catch(SQLException se){
		se.printStackTrace();
	}
	try{
		if(con!=null)
			con.close();
	}
	catch(SQLException se){
		se.printStackTrace();
	}
}
%>






