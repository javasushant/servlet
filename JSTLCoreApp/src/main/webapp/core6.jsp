<%@ page isELIgnored="false" import="java.util.* "%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<b> All request headers and Values are</b>
<br>
<c:forEach var="h" items="${headerValues}">
	Header name :: ${h.key}
	Header Value are ::
	<c:forEach var="hv" items="${h.value}">
		${hv} &nbsp;&nbsp;&nbsp;&nbsp;
	</c:forEach>
	<br>
</c:forEach>