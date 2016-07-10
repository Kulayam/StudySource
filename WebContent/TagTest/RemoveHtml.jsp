<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <c:set var="dateEL" value="<%= new Date() %>" />
<tg:removeHtml trim="true">
	<font size="10"> 현재 <style>시간</style>은 ${dateEL} 입니다. </font>
</tg:removeHtml>
