<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	BoardVo vo = (BoardVo) request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/app99/resources/css/list.css">
</head>
<body>
    <div id="wrap">

        <%@ include file="/WEB-INF/views/common/header.jsp" %>
        <main>

            <h2>상세조회</h2>
            <table>
                <colgroup>
                    <col width="20%">
                    <col width="80%">
                </colgroup>
                <tbody>
                    <tr>
                        <th scope="row">카테고리</th>
                        <td>
                            <%= vo.getCategoryName() %>
                        </td>
                    </tr>
                    <tr>
                        <th scope="row">제목</th>
                        <td><%= vo.getTitle() %></td>
                    </tr>
                    <tr>
                        <th scope="row" colspan="2">작성자 : <%= vo.getWriterNick() %>  ㅣ 작성일시 : <%= vo.getEnrollDate() %>  ㅣ  조회수 : <%= vo.getHit() %></th>
                    </tr>
                    <tr>
                        <th scope="row">내용</th>
                        <td><%= vo.getContent() %></td>
                    </tr>
                </tbody>
            </table>

            <div class="btn_box">
                <button onclick="location.href='/app99/board/list'">목록</button>
                <% if(loginMember != null && loginMember.getNo().equals(vo.getWriterNo())){ %>
                <button onclick="location.href='/app99/board/delete?no=<%= vo.getNo() %>'">삭제</button>
                <button onclick="location.href='/app99/board/edit?no=<%= vo.getNo() %>'">수정</button>
                <% } %>
            </div>
        </main>

    </div>
</body>
</html>