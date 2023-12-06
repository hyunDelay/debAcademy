<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>홈페이지</h1>
<h2>${x}</h2>
<hr>
<table border="1">
	<tbody>
		<c:forEach items="${voList}" var="vo">
			<tr>
				<td>${vo.title}</td>
				<td>${vo.writer}</td>
				<td>${vo.hit}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>

	<hr>
	<c:if test="${empty loginMember}">
		<h1>if문 통과했을때 나오는 글자</h1>
	</c:if>
	<hr>
	<c:forEach begin="0" end="9" step="1" var="i">
		<h3>${ i }</h3>
	</c:forEach>
	<hr>
	<c:choose>
		<c:when test=""></c:when>
		<c:when test=""></c:when>
		<c:when test=""></c:when>
	</c:choose>
</body>
</html>