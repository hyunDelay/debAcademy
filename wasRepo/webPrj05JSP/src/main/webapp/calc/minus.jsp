<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    	String n1 = request.getParameter("n1");
    	String n2 = request.getParameter("n2");
    	
    	int result = Integer.parseInt(n1) - Integer.parseInt(n2);
    %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>minus 페이지</h1>
	<h2>out = resp.getWriter();</h2>
	out.print(vo.getTitle);
	이걸 간편하게 쓸수있음
	'\<\%\= %\>
	<h2>결과 : <% out.println(result); %></h2>
	<h2>결과 : <%= result %></h2>
</body>
</html>