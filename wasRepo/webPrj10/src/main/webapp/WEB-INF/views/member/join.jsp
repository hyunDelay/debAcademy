<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<h1>회원가입</h1>
	<form action="/app10/member/join" method="post">
		<label for="memberId">아이디 : </label><input type="text"  id="memberId" name="memberId"/>
		<br>
		<label for="memberPwd1">비밀번호 : </label><input type="password"  id="memberPwd1" name="memberPwd1"/>
		<br>
		<label for="memberPwd2">비밀번호 확인 : </label><input type="password"  id="memberPwd2" name="memberPwd2"/>
		<br>
		<label for="memberNick">닉네임 : </label><input type="text"  id="memberNick" name="memberNick"/>
		<br><br>
		<input type="submit" value="회원가입">
	</form>
</body>
</html>