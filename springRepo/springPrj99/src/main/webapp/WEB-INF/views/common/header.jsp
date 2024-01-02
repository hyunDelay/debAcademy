<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
	* {margin: 0; padding: 0; box-sizing: border-box;}
	.wrap {width: 100%; height: 100vh; box-sizing: border-box;}
	header {
		display: flex; flex-direction: column; justify-content: center; gap: 10px;
		position: relative;
		width: 100%;
		height: 150px;
		background-color: #f5f5f5;
	 	align-items: center;
		box-shadow: 0px 0px 11px 4px rgba(0, 0, 0, .1);
	}
	header h1 {text-align: center; cursor: pointer;}
	nav {display: flex; justify-content: center; gap: 10px;}
	nav a {display: flex; padding: 10px 15px; text-decoration: none; color: #333;}
	nav a:hover {background-color: #333; color: #fff;}
	.loginArea {
		position: absolute;
		top: 50%;
		right: 10px;
		transform: translateY(-50%);
	}
	.loginArea form {
		display: flex;
		flex-wrap: wrap;
		justify-content: space-between;
		gap: 5px;
		width: 200px;
	}
	.loginArea input {
		border: 1px solid #ddd;
		background-color: #fff;
		box-sizing: border-box;
		padding: 6px 15px;
		font-size: 14px;
	}
	.loginArea input:focus {
		outline: none;
		border-color: #333;
	}
	.loginArea button {
		width: calc(50% - 5px);
		padding: 0 15px;
		height: 30px;
		box-sizing: border-box;
		border: none;
		background-color: #333;
		color: #fff;
		cursor: pointer;
	}
	.loginArea > div {display: flex; justify-content: center; gap: 5px; flex-wrap: wrap; font-size: 14px;}
	.loginArea > div span {font-weight: 600;} 
	.loginArea > div button {
		width: 50%;
		padding: 0 15px;
		height: 30px;
		border-radius: 30px;
		box-sizing: border-box;
		border: none;
		background-color: #333;
		color: #fff;
		cursor: pointer;
	}
</style>
<header>
	<h1 onclick="location.href='/app/home'">FINAL99</h1>
	<div class="loginArea">
		<c:if test="${empty loginMember}">
			<form action="/app/member/login" method="post">
				<input type="text" name="id" placeholder="아이디를 입력해주세요.">
				<input type="password" name="pwd" placeholder="비밀번호를 입력해주세요.">
				<button>로그인</button>
				<button type="button" onclick="location.href='/app/member/join'">회원가입</button>
			</form>
		</c:if>
		<c:if test="${not empty loginMember}">
			<div>
				<span>${loginMember.nick}</span>님 환영합니다!
				<br/>
				<button onclick="location.href='/app/member/logout'">로그아웃</button>
			</div>
			
		</c:if>
	</div>
	<nav>
		<a href="/app/board/list">게시판</a>		
		<a href="">공지사항</a>		
		<a href="">갤러리</a>		
		<a href="">마이페이지</a>		
	</nav>
</header>