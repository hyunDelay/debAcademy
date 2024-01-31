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
    <form>
        <input type="text" name="id" placeholder="아이디 입력"><br/>
        <input type="password" name="pwd" placeholder="패스워드 입력"><br/>
        <input type="text" name="email" placeholder="이메일 입력">
        <button type="button" onclick="handleJoin()">가입하기</button>
    </form>

<script>

    const handleJoin = () => {
        // 객체저장
        const id = document.querySelector('input[name=id]').value;
        const pwd = document.querySelector('input[name=pwd]').value;
        const email = document.querySelector('input[name=email]').value;
        const formVo = {
            id: id,
            pwd: pwd,
            email: email,
        };

        // 요청
        fetch('http://127.0.0.1:8888/app/member', {
            method: 'post',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(formVo),
        })
        .then(resp => resp.json())
        .then(data => {
            if(data.msg === 'good'){
                alert('회원가입 성공!!!!!!!');
            } else {
                throw new Error();
            }
        })
        .catch(() => {
            alert('회원가입 실패ㅠㅠ');
        })
        ;
    }
    
</script>
</body>
</html>