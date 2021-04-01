<%@ page isELIgnored="false" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/xml"  prefix="x"  %>
<c:import url="orders.xml" var="doc"/>

<x:parse doc="${doc}" var="pdoc"/>

<b>Displaying All Orders </b><br>
<x:forEach select="$pdoc/orders/order" var="ord">
item name :: <x:out select="$ord/name"/><br>
item price :: <x:out select="$ord/price"/><br>
</x:forEach>

<b>Displaying All Orders Whose price >=10000 </b><br>
<x:forEach select="$pdoc/orders/order" var="ord">
<x:if select="$ord/price>=10000">
item name :: <x:out select="$ord/name"/><br>
item price :: <x:out select="$ord/price"/><br>
</x:if>

</x:forEach>