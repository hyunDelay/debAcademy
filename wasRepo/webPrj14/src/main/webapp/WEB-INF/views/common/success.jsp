<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	String str = (String) request.getAttribute("str");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1><%= str %> 성공</h1>
	<hr/>
	<br/>
	<a href="/app14/home">홈으로 돌아가기</a>
</body>
</html>