

<%@page isELIgnored="false"  %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- creating data having scope and name -->

<c:set var="msg" value="Welcome to JSP" scope="request" />

<!-- Display the message -->
Value :: <c:out value="${msg}"/> &nbsp;&nbsp;&nbsp; Value :: ${msg}  <br>

<!-- Remove the data from scope -->
<c:remove var="msg" scope="request"/>

<!-- Display the message -->
Value :: <c:out value="${msg}"/> &nbsp;&nbsp;&nbsp; Value :: ${msg}<br>