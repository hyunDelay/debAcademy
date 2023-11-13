<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
	<title>회원가입</title>
</head>
<body>

	<h1>회원가입ㅋ</h1>
	
	<form action="/app08/member/join/processor">
		<label for="id">아이디 : </label> <input type="text" id="id" name="memberId" />
		<br>
		<label for="pwd">비밀번호 : </label> <input type="password" id="pwd" name="memberPwd" />
		<br>
		<label for="pwd2">비밀번호 확인 : </label> <input type="password" id="pwd2" name="memberPwd2" />
		<br>
		<label for="nick">닉네임 : </label> <input type="text" id="nick" name="memberNick" />
		<br>
		<br>
		<input type="submit" value="회원가입">
	</form>
	
</body>
</html>