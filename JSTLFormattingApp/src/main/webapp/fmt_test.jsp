<%@ page isELIgnored="false" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<fmt:setLocale value="hi_IN"/>

<!-- format the Number -->
<fmt:formatNumber var="fnumber" value="100000" type="currency"/><br>
Formatted Number is :: ${fnumber} <br>

<jsp:useBean id="dt" class="java.util.Date"/>
<fmt:formatDate value="${dt}" var="fdt" type="both"/>
<br>
Format Date :: ${fdt} <br>

<fmt:setBundle basename="com/nt/commons/App"/>
<fmt:message key="welcome.msg" var="msg1" />
<fmt:message key="goodbye.msg" var="msg2" />
 Message1 :: ${msg1}  &nbsp;&nbsp;  Message2 :: ${msg2}