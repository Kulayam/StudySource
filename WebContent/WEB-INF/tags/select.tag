<%@ tag body-content="empty" language="java" pageEncoding="UTF-8"%>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag dynamic-attributes="selMap" %>
<%@ attribute name="name" required="true"  %>
<%@ attribute name="className"   %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<select name="${name }" class="${className }">
	<c:forEach items="${selMap }" var="map">
		<option value="${map.key }">${map.value }</option>	
	</c:forEach>
</select>