<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:forEach items="${members}" var="member">
	ID : ${member.id}<br/>
	PW : ${member.pw }<br/>
</c:forEach>