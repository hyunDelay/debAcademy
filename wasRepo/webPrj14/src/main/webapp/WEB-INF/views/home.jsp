<%@page import="com.kh.app.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    	MemberVo loginMember = (MemberVo)session.getAttribute("userData");
    	String name = "게스트";
    	if(loginMember != null){
    		name = loginMember.getMemberNick();
    	}
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>webPrj14 프로젝트</title>
</head>
<body>
	<h1>홈페이지</h1>
	
	<hr>
	<br>
	<h2><%= name %>님 환영합니다</h2>
	<br>
	<br>
	<%if(loginMember == null){%>
		<a href="/app14/member/join">회원가입</a>
		<br>
		<a href="/app14/member/login">로그인</a>
	<%} else {%>
		<a href="/app14/member/logout">로그아웃</a>
	<%}%>
	
</body>
</html>