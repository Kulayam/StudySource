<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<form action="${context}/Login" method="post">
ID : <input type="text" name="id" required="required" />
PW : <input type="password" name="pw" required="required" />
<button type="submit">로그인</button>
</form>