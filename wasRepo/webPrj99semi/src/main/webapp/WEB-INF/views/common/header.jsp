<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
    #wrap {
        width: 800px;
        border: 1px solid #333;
        margin: auto;
    }
    header {
        display: grid;
        grid-template-rows: 3fr 1fr;
        grid-template-columns: 2fr 4fr 2fr;
        width: 100%;
        height: 200px;
    }
    header div:last-child {
        grid-column: span 3;
    }
    header div:nth-child(2) {
        display: flex;
        align-items: center;
        justify-content: center;
    }
    header div:nth-child(3) form {
        display: flex;
        align-items: center;
        width: 100%;
        height: 100%;
    }
    header div img {
        height: 88px;
    }

    .login-area {
        display: grid;
        grid-template-rows: 1fr 1fr 1fr;
        grid-template-columns: 1fr 1fr;
    }
    .login-area input[name=memberId],
    .login-area input[name=memberPwd] {
        grid-column: span 2;
    }
    nav {
        display: flex;
        align-items: center;
        justify-content: space-evenly;
        height: 100%;
        background-color: #333;
    }
    nav a {
        text-decoration: none;
        color: #fff;
    }

    /* main */
    main {
        width: 100%;
    }
</style>

<header>
    <div></div>
    <div>
        <a href="/app99/home"><img src="/app99/resources/img/logo.svg" alt="로고이미지"></a>
    </div>
    <div>
        <form action="/app99/member/login" method="post">
            <div class="login-area">
                <input type="text" name="memberId" placeholder="아이디">
                <input type="password" name="memberPwd" placeholder="패스워드">
                <button type="button" onclick="location.href='/app99/member/join';">회원가입</button>
                <input type="submit" value="로그인">
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