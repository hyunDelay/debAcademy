<%@page import="com.kh.app.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 알람
	String x = (String) session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
	
	// 로그인
	MemberVo loginMember = (MemberVo) session.getAttribute("loginMember");
	//session.removeAttribute("loginInfo");
	
%>
<script>
	<% if(x != null){ %>
    	alert('<%= x %>');
	<% } %>
</script>
<link rel="stylesheet" href="/app99/resources/css/header.css">
<header>
    <div></div>
    <div>
        <a href="/app99/home"><img src="/app99/resources/img/logo.svg" alt="로고이미지"></a>
    </div>
    <div>
        <form action="/app99/member/login" method="post">
            <div class="login-area">
            	<% if(loginMember == null){ %>
	            	<input type="text" name="memberId" placeholder="아이디">
	                <input type="password" name="memberPwd" placeholder="패스워드">
	                <input type="submit" value="로그인">
	                <button type="button" onclick="location.href='/app99/member/join';">회원가입</button>
            	<% } else { %>
            		<strong><%= loginMember.getMemberNick() %></strong>님 환영합니다!<br/>
            		<button type="button" onclick="location.href='/app99/home'">로그아웃</button>
            	<% } %>
                
            </div>
        </form>
    </div>
    <div>
        <nav>
            <a href="/app99/board/list">게시판</a>
            <a href="/app99/notice/list">공지사항</a>
            <a href="/app99/gallery/list">갤러리</a>
            <a href="/app99/member/edit">마이페이지</a>
        </nav>
    </div>
</header>

<div class="pop_dim">
    <div class="pop"><%= x %></div>
    <button class="close">닫기</button>
</div>

<script>
	<% if(x != null){ %>
		const pop_dim = document.querySelector('.pop_dim');
        pop_dim.classList.add('on');
	<% } %>
</script>
<script>
    const closeBtn = document.querySelector('.close');
    closeBtn.addEventListener('click', () => {
        const pop_dim = document.querySelector('.pop_dim');
        pop_dim.classList.remove('on');
    });
</script>