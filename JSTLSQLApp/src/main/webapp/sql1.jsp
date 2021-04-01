<%@ page isELIgnored="false" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!-- for DB connection -->
<sql:setDataSource var="ds"
					driver="oracle.jdbc.driver.OracleDriver"
					url="jdbc:oracle:thin:@localhost:1521:SYS"
					user="system"
					password="manager" />

<!-- for executing SQL Query -->
<sql:query var="rs" dataSource="${ds}" sql="SELECT EMPNO,ENAME,SAL,JOB FROM EMP" />

<!-- Process the ResultSet -->
<table border="1" bgcolor="cyan"  align="center">
<c:forEach var="row" items="${rs.rows}">
<tr>
<td>${row.EMPNO}</td>
<td>${row.ENAME}</td>
<td>${row.SAL}</td>
<td>${row.JOB}</td>
</tr>
</c:forEach>

</table>