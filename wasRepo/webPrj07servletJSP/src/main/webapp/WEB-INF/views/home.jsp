<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String k01 = (String)request.getAttribute("k01");
    	String color = (String)request.getAttribute("color");
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webPrj07servletJSP</title>
</head>
<body>

	<h1>홈 JSP</h1>
	<h2><%= k01 %></h2>
	<h2><%= color %></h2>
	
</body>
</html>