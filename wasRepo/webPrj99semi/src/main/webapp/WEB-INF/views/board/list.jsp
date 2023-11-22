<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<BoardVo> boardVoList = (List<BoardVo>) request.getAttribute("boardVoList");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>리스트</title>
<link rel="stylesheet" href="/app99/resources/css/list.css">
</head>
<body>

	<div id="wrap">
	
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		<main>
			<h2>게시글 목록</h2>
			
			<table>
				<colgroup>
					<col width="">
					<col width="">
					<col width="">
					<col width="">
					<col width="">
				</colgroup>
				<thead>
					<tr>
						<th scope="col">글번호</th>
						<th scope="col">카테고리 번호</th>
						<th scope="col">제목</th>
						<th scope="col">작성자</th>
						<th scope="col">조회수</th>
						<th scope="col">작성일시</th>
					</tr>
				</thead>
				<tbody>
					<% for(BoardVo vo : boardVoList){ %>
					<tr>
						<td class="agn_c"><%= vo.getNo() %></td>
						<td class="agn_c"><%= vo.getCategoryNo() %></td>
						<td><%= vo.getTitle() %></td>
						<td class="agn_c"><%= vo.getWriterNick() %></td>
						<td class="agn_c"><%= vo.getHit() %></td>
						<td class="agn_c"><%= vo.getEnrollDate() %></td>
					</tr>
					<% } %>
				</tbody>
			</table>

			<div class="btn_box">
				<button onclick="location.href='/app99/board/write'">글쓰기</button>
			</div>
			
			<ul class="paging">
				<li><a href="">1</a></li>
				<li><a href="">2</a></li>
				<li><a href="">3</a></li>
				<li><a href="">4</a></li>
				<li><a href="">5</a></li>
				<li><a href="">다음</a></li>
			</ul>
			
		</main>
		
	</div>

</body>
</html>