<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="name" required="true"%>
<%@ attribute name="className" %>
<%@ variable name-given="maps" variable-class="java.util.HashMap" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select name="${name}" class="${className }">
<c:forEach items="${maps}" var="map">
	<option value="${map.key }">${map.value }</option>
</c:forEach>
</select>
