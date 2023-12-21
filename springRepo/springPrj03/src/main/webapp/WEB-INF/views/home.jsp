<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
h1 {text-align: center}
.link {display: flex; gap: 20px; justify-content: center; border-bottom: 1px solid #333; padding-bottom: 10px;}
.link a {display: flex; padding: 10px 20px; color: #333; border-radius: 30px; text-decoration: none;}
.link a:hover,
.link a:active {color: #fff; background-color: #333;} 
</style>
</head>
<body>
	<h1>홈페이지</h1>
	<hr/>
	
	<div class="link">
		<a href="/app/board/list">게시글 목록</a>
		<a href="/app/board/write">게시글 작성</a>
	</div>
	
</body>
</html>
