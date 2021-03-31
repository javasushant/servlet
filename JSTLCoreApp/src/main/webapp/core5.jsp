<%@ page isELIgnored="false" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<b>All Request Param and Values Are </b>
<br>
<c:forEach var="p" items="${paramValues }">
	param name :: ${p.key}
	param Values :: 
	<c:forEach var="pv" items="${p.value}">
		${pv} &nbsp;&nbsp;&nbsp;&nbsp;
	
	</c:forEach>
	<br>
</c:forEach>