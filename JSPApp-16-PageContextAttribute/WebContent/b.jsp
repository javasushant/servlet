
<b>form b.jsp</b>
<b>attr1 (page scope) value :: <%=pageContext.getAttribute("attr1") %></b><br>
<b>attr1 (page scope) value :: <%=pageContext.findAttribute("attr1") %></b><br><br>
<hr><br>
<b>attr2(request scope) value ::<%= request.getAttribute("attr2")  %></b><br>
<b>attr2(request scope) value ::<%= pageContext.getAttribute("attr2",pageContext.REQUEST_SCOPE)  %></b><br>
<b>attr2(request scope) value ::<%= pageContext.findAttribute("attr2")  %></b><br>

<hr><br>
<b>attr3(Session scope) value ::<%= session.getAttribute("attr3")  %></b><br>
<b>attr3(Session scope) value ::<%= pageContext.getAttribute("attr3",pageContext.SESSION_SCOPE)  %></b><br>
<b>attr3(Session scope) value ::<%= pageContext.findAttribute("attr3")  %></b><br>
<hr><br>
<b>attr4(Application scope) value ::<%= application.getAttribute("attr4")  %></b><br>
<b>attr4(Application scope) value ::<%= pageContext.getAttribute("attr4",pageContext.APPLICATION_SCOPE)  %></b><br>
<b>attr4(Application scope) value ::<%= pageContext.findAttribute("attr4")  %></b><br>
<hr><br>



<!-- forwarding request to c.jsp -->
<jsp:forward page="c.jsp"></jsp:forward>