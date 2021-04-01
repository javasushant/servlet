<%@ page isELIgnored="false" import="java.util.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!-- for DB connection -->
<sql:setDataSource var="ds"
					driver="oracle.jdbc.driver.OracleDriver"
					url="jdbc:oracle:thin:@localhost:1521:SYS"
					user="system"
					password="manager" />

<!-- for executing non-Select SQL Query -->
<sql:update dataSource="${ds}" sql="UPDATE EMP SET SAL=SAL+? WHERE EMPNO=?" var="count">
<sql:param value="1000" />
<sql:param >7499</sql:param>
</sql:update>
<b>No. of records that are effected ::${count}</b>


