<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String n1 = request.getParameter("n1");
    	String n2 = request.getParameter("n2");
    	
    	int result = Integer.parseInt(n1) + Integer.parseInt(n2);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>plus 페이지</title>
</head>
<body>
	<h1>plus 페이지</h1>
	<h2>out = resp.getWriter();</h2>
	<h2>결과 : <% out.println(result); %></h2>
</body>
</html>