<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<a href="${context }/Members" >멤버 확인하기</a>
<% HashMap<String, String> maps = new HashMap<String, String>();
	maps.put("key1", "value1");
	maps.put("key2", "value2");
	maps.put("key3", "value3");
%>
<select>
	<c:forEach items="<%=maps%>" var="map">
		<option value="${map.key }">${map.value }</option>
	</c:forEach>
</select>