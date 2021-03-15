
<%
	String name =request.getParameter("name");
	float price=Float.parseFloat(request.getParameter("price"));
	int qty= Integer.parseInt(request.getParameter("qty"));
	float billAmt=price*qty;
	
	%>
	<%if(billAmt<5000){ %>
<jsp:forward page="b.jsp">
	<jsp:param value="<%=billAmt %>" name="billAmt"/>
</jsp:forward>
<% }
 else {%>
 NAME OF ITEM :: <%=name %>
 PRICE OF ITEM ::  <%= qty %>
 TOTAL BILL AMOUNT :: <%=billAmt%>
 <% }%>
 <br>
 <a href="form.html">home</a>