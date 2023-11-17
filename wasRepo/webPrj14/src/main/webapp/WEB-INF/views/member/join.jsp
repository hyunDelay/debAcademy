<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
    <html>
    <head>
        <meta charset="UTF-8">
        <title>회원가입</title>
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
                background-color: rgb(84, 39, 110);
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
            }
        </style>
    </head>
    <body>
        <h1>회원가입</h1>
        <hr>
        <form action="/app14/member/join" method="POST">
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
                        <th scope="row"><label for="memberPwd2">비밀번호 확인</label></th>
                        <td><input type="password" id="memberPwd2" name="memberPwd2"></td>
                    </tr>
                    <tr>
                        <th scope="row"><label for="memberNick">닉네임</label></th>
                        <td><input type="text" id="memberNick" name="memberNick"></td>
                    </tr>
                    <tr>
                        <td colspan="2"><input type="submit" value="회원가입"></td>
                    </tr>
                </tbody>
            </table>
        </form>
    
    </body>
    </html>