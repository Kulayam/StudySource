<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:catch var="ex">
	<%=5/0 %>
</c:catch>

<c:if test="${ex != null}">
	<c:out value="익셉션 발생" /><br/>
	${ex}
</c:if>