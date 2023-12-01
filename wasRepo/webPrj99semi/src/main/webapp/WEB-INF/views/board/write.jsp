<%@page import="com.kh.app.board.vo.CategoryVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<BoardVo> boardVoList = (List<BoardVo>) request.getAttribute("boardVoList");
	List<CategoryVo> categoryVoList = (List<CategoryVo>) request.getAttribute("categoryVoList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
<link rel="stylesheet" href="/app99/resources/css/list.css">
</head>
<body>
    <div id="wrap">

		<%@ include file="/WEB-INF/views/common/header.jsp" %>
        <main>

            <h2>글쓰기</h2>
            <form action="/app99/board/write" method="post">
                <table>
                    <colgroup>
                        <col width="20%">
                        <col width="80%">
                    </colgroup>
                    <tbody>
                        <tr>
                            <th scope="row">카테고리</th>
                            <td>
                                <select name="category" id="">
                                	<% for(CategoryVo categoryVo : categoryVoList){ %>
                                    	<option value="<%= categoryVo.getNo() %>"><%= categoryVo.getName() %></option>
                                    <% } %>
                                </select>
                            </td>
                        </tr>
                        <tr>
                            <th scope="row">제목</th>
                            <td><input type="text" name="title"></td>
                        </tr>
                        <tr>
                            <th scope="row">내용</th>
                            <td><textarea name="content" id="" cols="30" rows="10"></textarea></td>
                        </tr>
                    </tbody>
                </table>

                <div class="btn_box">
                    <input type="submit" value="작성하기">
                </div>
            </form>
        </main>

    </div>
</body>
</html>