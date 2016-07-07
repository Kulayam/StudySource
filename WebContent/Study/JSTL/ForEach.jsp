<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	HashMap<String, String> map1 = new HashMap<String, String>();
    	map1.put("one", "1");
    	map1.put("two", "2");
    %>
<c:forEach items="${map1}" var="getM" begin="1">
	${getM.key}=${getM.value}<br/>
</c:forEach>
<c:set var="num" value="1,2,3,4,5,6"/>
<c:forTokens items="${num}" delims="," var="nums">${nums}<br/></c:forTokens>