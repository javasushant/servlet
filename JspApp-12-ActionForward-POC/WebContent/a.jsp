
<%
	float radius = 14.14f;
	float area = 3.14f * radius * radius; %>
	
<jsp:forward page="b.jsp">
	<jsp:param name="BKName" value="CRJ"/>
	<jsp:param value="<%=area %>" name="carea"/>
</jsp:forward>