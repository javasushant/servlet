<%@ page isELIgnored="false" import="java.util.* "%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- traditional for loop -->
<table border="1" bgcolor="cyan">
	<c:forEach var="i" begin="1" end="20" step="1">
		<tr>
			<td>2*${i}=</td>
			<td>${2*i}</td>
		</tr>
	</c:forEach>
</table>
<!-- Enhanced for loop -->

<jsp:scriptlet><![CDATA[String name[] = new String[] { "Raja", "Rani", "Suresh", "Naresh" };
request.setAttribute("nameList", name);
List<String> sizeList = new ArrayList();
sizeList.add("M");
sizeList.add("S");
sizeList.add("L");
sizeList.add("XL");
request.setAttribute("sizeList", sizeList);]]></jsp:scriptlet>

<b> The name are ::</b>
<br>
<br>

<c:forEach var="name" items="${nameList}">
	${name}<br>
</c:forEach>
<br>
<b>The Size are :: </b>
<br>
<br>
<c:forEach var="size" items="${sizeList}">
${size} <br>
</c:forEach>