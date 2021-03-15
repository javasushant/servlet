<b><h1 style="color:red;text-align:center">Additional request param Values </h1></b>
<br>
<%= new java.util.Date()%>
<br>
item name :: <%= request.getParameter("name") %><br>
item price :: <%=Float.parseFloat(request.getParameter("price")) %><br>
item qty :: <%=Integer.parseInt(request.getParameter("qty")) %><br>
item bill Amount :: <%=Float.parseFloat(request.getParameter("billAmt")) %><br>
<br>
 <a href="form.html">home</a>