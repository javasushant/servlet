
<%@page import="java.util.Calendar"%>
<%! 
	public String getMsg(String msg){
	//get calender object
	Calendar cal = Calendar.getInstance();
	//get current hour of the day
	int hour = cal.get(Calendar.HOUR_OF_DAY);
	//generate with message
	if(hour<12)
		return "Good Mornning "+msg;
	else if(hour<16)
		return "Good AfterNoon "+msg;
	else if(hour<20)
		return "Good Evening "+msg;
	else
		return "Good Night "+msg;
}

%>

<h1 style= "color:red;text-align:center">Welcome to my JSP Page</h1>
<br>
<h1 style= "color:green;text-align:center">Date and time :: <%=new java.util.Date() %></h1>
<br>
<% String msg = request.getParameter("name"); %>
<br>
<h3 style= "color:blue;text-align:center">
The wish message is :: <%=getMsg("rocky") %>
</h3>