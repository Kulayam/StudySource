<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<c:url var="url" value="/board.jsp">
	<%-- <c:param name="bo_table" value="1_1" />
	<c:param name="w" value="u" /> --%>
</c:url>

${url}<br/>
${pageContext.request.contextPath}

<c:redirect url="${url}">
	<c:param name="bo_table" value="1_1" />
	<c:param name="w" value="u" />
</c:redirect>