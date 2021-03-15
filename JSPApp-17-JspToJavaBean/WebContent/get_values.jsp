<%@ page import="com.nt.beans.Student"%>
<h1 style="color:red;text-align:center">Set_values.jsp</h1>

<!-- ce=reate and locate java bean property values -->
<jsp:useBean id="st" class="com.nt.beans.Student" scope="session"/>

<b><jsp:getProperty property="sno" name="st"/></b><br>
<b><jsp:getProperty property="sname" name="st"/></b><br>
<b><jsp:getProperty property="avg" name="st"/></b><br>