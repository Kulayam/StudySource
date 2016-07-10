<%@ tag language="java" pageEncoding="UTF-8"%>
<jsp:useBean id="now" class="java.util.Date" />
<fmt:formatDate value="${now }" pattern="yyyy-MM-dd" var="nowDate" />
<c:out value="${nowDate }" />