<%@ page import="com.nt.beans.Student" %>
<h1 style="color:red;text-align:center">Set_values.jsp</h1>
<!-- create/Locate java bean class object -->

<jsp:useBean id="st" class="com.nt.beans.Student" scope="session"/>

<%-- <jsp:setProperty property="sno" name="st" value="101"/>
<jsp:setProperty property="sname" name="st" value="Rockey"/>
<jsp:setProperty property="avg" name="st" value="45.5f"/> --%>

<%-- <jsp:setProperty property="sno" name="st" param="stno"/>
<jsp:setProperty property="sname" name="st" param="stname"/>
<jsp:setProperty property="avg" name="st" param="stavg"/>
<br> --%>

<jsp:setProperty property="*" name="st" />

<br>
<b>Values are set bean proprties</b>