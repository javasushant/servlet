<%@ page isELIgnored="false" import="java.util.*" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<c:catch var="e">
 <jsp:scriptlet>
 	int x = Integer.parseInt("10a");
 	out.println("x");
 </jsp:scriptlet>>
</c:catch>
<c:if test="${!empty e}">
<br> The execution raised is :: ${e}
</c:if>