<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <fmt:setLocale value="cn"/>
<c:set var="mb_id" value="user"/>
<fmt:bundle basename="resource.message">
	<fmt:message key="TITLE" /><br/>
	<fmt:message key="ETC" >
		<fmt:param value="${mb_id}" />
	</fmt:message>
</fmt:bundle> --%>


<fmt:setBundle basename="resource.message" var="message" scope="request"/>

<fmt:message bundle="${message }" key="TITLE" />