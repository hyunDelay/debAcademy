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
        table {
            width: 400px;
            margin: 50px auto;
            border-top: 1px solid #000;
        }
        table th {
            text-align: left;
        }
        table th,
        table td {
            padding: 10px 6px;
            box-sizing: border-box;
            border-bottom: 1px solid #ddd;
        }
        table tr:last-child td,
        table tr:last-child th {
        border-bottom: none;
        }
        table td input {
            width: 100%;
            box-sizing: border-box;
            padding: 8px 6px;
            border: 1px solid #ddd;
            font-size: 14px;
        }
        table td input[type=submit] {
            display: block;
            width: 100%;
            box-sizing: border-box;
            padding: 10px 0;
            background-color: rgb(146, 30, 30);
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
    </style>
</head>
<body>
	<h1>로그인</h1>
    <hr>
    <form action="/app13/member/login" method="POST">
        <table>
            <colgroup>
                <col width="120px" />
                <col width="*" />
            </colgroup>
            <tbody>
                <tr>
                    <th scope="row"><label for="memberId">아이디</label></th>
                    <td><input type="text" id="memberId" name="memberId"></td>
                </tr>
                <tr>
                    <th scope="row"><label for="memberPwd">비밀번호</label></th>
                    <td><input type="password" id="memberPwd" name="memberPwd"></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="로그인"></td>
                </tr>
            </tbody>
        </table>
    </form>

</body>
</html>