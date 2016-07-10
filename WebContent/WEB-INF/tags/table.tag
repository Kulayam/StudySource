<%@ tag body-content="empty" language="java" pageEncoding="UTF-8"%>
<%@ tag trimDirectiveWhitespaces="true" %>
<%@ attribute name="id" required="true" %>
<%@ attribute name="pw" required="true" %>
<table>
	<tr>
		<th>아이디</th>
		<td><input type="text" name="id" value="${id}" ></td>
	</tr>
	<tr>
		<th>비밀번호</th>
		<td><input type="password" name="pw" value="${pw}" ></td>
	</tr>
</table>