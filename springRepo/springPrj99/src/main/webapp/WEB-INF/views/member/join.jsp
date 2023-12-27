<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.join {
		display: flex;
		gap: 10px;
		flex-direction: column;
		width: 60%;
		margin: 0 auto;
		padding: 30px 0;
	}
	.join input {
		border: 1px solid #ddd;
		background-color: #fff;
		box-sizing: border-box;
		padding: 6px 15px;
		font-size: 14px;
	} 
	.join input:focus {
		outline: none;
		border-color: #333;
	}
	.join button {
		padding: 0 15px;
		height: 40px;
		box-sizing: border-box;
		border: none;
		background-color: #333;
		color: #fff;
		cursor: pointer;
	}
</style>
</head>
<body>
	<div class="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		<main>
			<form action="/app/member/join" method="post" class="join">
				<input type="text" name="id" placeholder="아이디를 입력해주세요.">
				<input type="text" name="pwd" placeholder="비밀번호를 입력해주세요.">
				<input type="text" name="nick" placeholder="닉네임을 입력해주세요.">
				<button>회원가입</button>
			</form>
		</main>
	</div>
</body>
</html>