<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>회원가입</title>
    <style>
        .joinGroup {
            display: flex;
            flex-direction: column;
            gap: 10px;
            list-style: none;
            width: 327px;
            margin: 0 auto;
            padding-left: 0;
        }
        .joinGroup li {
            display: flex;
            align-items: center;
        }
        .joinGroup li > label {
            display: block;
            width: 150px;
        }
        .joinGroup li:last-child div {
            display: flex;
            align-items: center;
            flex-wrap: wrap;
            width: calc(100% - 150px);
            gap: 5px;
        }
        .joinGroup li:last-child span {
            display: flex;
        }
        .joinGroup + input[type=submit] {
            display: block;
            width: 327px;
            padding: 8px 20px;
            border: none;
            box-sizing: border-box;
            background-color: #333;
            color: #fff;
            margin: 40px auto 20px;
            cursor: pointer;
        }
        .req {
            color: rgb(189, 6, 6);
            font-weight: 900;
        }
    </style>
</head>
<body>

	<div id="wrap">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>

			<h1 align="center">회원가입</h1>

            <form action="/app99/member/join" method="post" onsubmit="return checkValidate();">
                <ul class="joinGroup">
                    <li>
                        <label for="memberId">아이디<span class="req">*</span></label>
                        <input type="text" id="memberId" name="memberId">
                    </li>
                    <li>
                        <label for="memberPwd">비밀번호<span class="req">*</span></label>
                        <input type="password" id="memberPwd" name="memberPwd">
                    </li>
                    <li>
                        <label for="memberPwd2">비밀번호 확인<span class="req">*</span></label>
                        <input type="password" id="memberPwd2" name="memberPwd2">
                    </li>
                    <li>
                        <label for="memberNick">닉네임<span class="req">*</span></label>
                        <input type="text" id="memberNick" name="memberNick">
                    </li>
                    <li>
                        <label for="memberNick">전화번호</label>
                        <input type="tel" id="memberPhone" name="memberPhone">
                    </li>
                    <li>
                        <label for="memberNick">이메일</label>
                        <input type="email" id="memberEmail" name="memberEmail">
                    </li>
                    <li>
                        <label for="memberNick">주소</label>
                        <input type="text" id="memberAddress" name="memberAddress">
                    </li>
                    <li>
                        <label for="">취미</label>
                        <div>
                            <span>
                                <input type="checkbox" name="memberchk" value="game" id="game">
                                <label for="game">game</label>
                            </span>
                            <span>
                                <input type="checkbox" name="memberchk" value="cook" id="cook">
                                <label for="cook">cook</label>
                            </span>
                            <span>
                                <input type="checkbox" name="memberchk" value="workout" id="workout">
                                <label for="workout">workout</label>
                            </span>
                            <span>
                                <input type="checkbox" name="memberchk" value="java" id="java">
                                <label for="java">java</label>
                            </span>
                            <span>
                                <input type="checkbox" name="memberchk" value="js" id="js">
                                <label for="js">js</label>
                            </span>
                            <span>
                                <input type="checkbox" name="memberchk" value="sql" id="sql">
                                <label for="sql">sql</label>
                            </span>
                        </div>
                    </li>
                </ul>
                
                <input type="submit" value="회원가입">

            </form>

		</main>
		
	</div>

<script>
    function checkValidate(){

        // 아이디 길이
        const memberId = document.querySelector('main input[name=memberId]').value;
        const memberIdRegex = /^[a-z0-9]{4,12}$/;

        if(!memberIdRegex.test(memberId)){
            alert("아이디를 올바르게 입력해주세요.");
            document.querySelector('main input[name=memberId]').focus();
            return false;
        }

        // 패스워드 일치여부
        const memberPwd = document.querySelector('main input[name=memberPwd]').value;
        const memberPwd2 = document.querySelector('main input[name=memberPwd2]').value;

        if(memberPwd !== memberPwd2){
           alert("비밀번호와 비밀번호 확인이 일치하지 않습니다."); 
           document.querySelector('main input[name=memberPwd]').focus();
           return false;
        }

        // 패스워드 길이
        if(memberPwd.length < 4){
           alert("비밀번호는 4글자 이상이어야 합니다."); 
           document.querySelector('main input[name=memberPwd]').focus();
           return false;
        }

        // 닉네임에 부적절한 단어
        const memberNick = document.querySelector('main input[name=memberNick]').value;
        if(memberNick.includes('admin')){
            document.querySelector('main input[name=memberNick]').focus();
            alert('부적절한 닉네임 입니다.');
            return false;
        }

        // 전화번호 형식 (정규식)
        const phoneRegex = /^01[0-9]-\d{4}-\d{4}$/;
        const memberPhone = document.querySelector('main input[name=memberPhone]').value;
        if (memberPhone !== '' && !phoneRegex.test(memberPhone)) {
            alert('전화번호 형식이 맞지않습니다.');
            return false;
        }

        // 이메일 형식 (정규식)
        const memberEmail = document.querySelector('main input[name=memberEmail]').value;
        const emailRegex = /^[a-zA-Z0-9._-]+@[a-zA-Z0-9.-]+\.[a-zA-Z]{2,4}$/;
        if (memberEmail !== '' && !emailRegex.test(memberEmail)) {
            alert('이메일 형식이 맞지않습니다.');
            return false;
        }

        return true;
    }
</script>
</body>
</html>