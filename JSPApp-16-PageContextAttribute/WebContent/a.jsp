
<b>form a.jsp</b>
<!-- Create different Scopes of attribut -->

<% 
	pageContext.setAttribute("attr1", "val1"); //default scope is page s ope
	pageContext.setAttribute("attr2", "val2",pageContext.REQUEST_SCOPE);
	pageContext.setAttribute("attr3", "val3",pageContext.SESSION_SCOPE);
	pageContext.setAttribute("attr4", "val4",pageContext.APPLICATION_SCOPE);

		
%>
<!-- forwarding request to b.jsp -->
<jsp:forward page="b.jsp"/>