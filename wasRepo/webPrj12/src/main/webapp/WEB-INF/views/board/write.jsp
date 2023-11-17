<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    h1 {
        text-align: center;
    }
    dl {
        width: 50%;
        margin: 30px auto;
    }
    dl dd {
        margin: 0;
        margin-top: 20px;
    }
    input[type=text] {
        width: 100%;
        padding: 15px 10px;
        border: 1px solid #ddd;
        box-sizing: border-box;
        font-size: 16px;
        border-radius: 5px;
    }
    textarea {
        width: 100%;
        padding: 10px;
        border: 1px solid #ddd;
        box-sizing: border-box;
        border-radius: 5px;
    }
    input[type=submit] {
        width: 100%;
        padding: 10px 5px;
        background-color: #4d1e1e;
        color: #fff;
        border: none;
        border-radius: 30px;
        font-size: 20px;
        cursor: pointer;
    }
</style>
</head>
<body>
    <h1>게시글 작성</h1>

    <hr>

    <form action="/app12/board/write" method="post">
        
        <dl>
            <dt><input type="text" name="boardTit" placeholder="제목을 입력해주세요."></dt>
            <dd><textarea name="boardCont" placeholder="내용을 입력해주세요" cols="30" rows="10"></textarea></dd>
            <dd><input type="submit" value="작성완료"></dd>
        </dl>

    </form>
</body>
</html>