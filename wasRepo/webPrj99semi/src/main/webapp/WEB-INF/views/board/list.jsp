<%@page import="java.util.Map"%>
<%@page import="com.kh.app.page.vo.PageVo"%>
<%@page import="com.kh.app.board.vo.BoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	List<BoardVo> boardVoList = (List<BoardVo>) request.getAttribute("boardVoList");
	PageVo pvo = (PageVo)request.getAttribute("pvo");
	
	Map<String, String> searchMap = (Map<String, String>) request.getAttribute("searchMap");
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
			
			<div class="search-area">
				<form action="/app99/board/search" method="get">
					<select name="searchType">
						<option value="title">제목</option>
						<option value="content">내용</option>
					</select>
					<input type="text" name="searchValue" placeholder="검색할 내용을 입력하세요">
					<input type="submit" value="검색">
				</form>
			</div>
			
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
						<th scope="col">카테고리</th>
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
						<td class="agn_c"><%= vo.getCategoryName() %></td>
						<td><%= vo.getTitle() %></td>
						<td class="agn_c"><%= vo.getWriterNick() %></td>
						<td class="agn_c"><%= vo.getHit() %></td>
						<td class="agn_c"><%= vo.getEnrollDate() %></td>
					</tr>
					<% } %>
				</tbody>
			</table>

			<% if(loginMember != null){ %>
			<div class="btn_box">
				<button onclick="location.href='/app99/board/write'">글쓰기</button>
			</div>
			<% } %>
			
			
			<ul class="paging">
				<% if(pvo.getStartPage() != 1){ %>
					<li><a href="/app99/board/list?pno=<%= pvo.getStartPage() - 1 %>">이전</a></li>
				<% } %>
				
				<% for(int i = pvo.getStartPage(); i < pvo.getEndPage() + 1; i++){ %>
					<% if(pvo.getCurrentPage() == i){ %>
						<li class="on"><a><%= i %></a></li>
					<% } else { %>
						<li><a href="/app99/board/list?pno=<%= i %>"><%= i %></a></li>
					<% } %>
				<% } %>
				
				<% if(pvo.getEndPage() != pvo.getMaxPage()){ %>
					<li><a href="/app99/board/list?pno=<%= pvo.getEndPage() + 1 %>">다음</a></li>
				<% } %>
			</ul>
		</main>
		
	</div>
<script>

	const trArr = document.querySelectorAll("main table tbody tr");
	trArr.forEach(tr => {
		tr.addEventListener('click', handleClick);
	})
	function handleClick(e){
		const trTag = e.currentTarget;
		const no = trTag.children[0].innerText;
		location.href = '/app99/board/detail?no=' + no + '&currPage=<%= pvo.getCurrentPage() %>';
	}
	
	<% if(searchMap != null){ %>
		function setSearchArea(){

			// 옵션태그 세팅
			const optArr = document.querySelectorAll('.search-area form option');
			const searchType = "<%= searchMap.get("searchType") %>";
			for(let i = 0; i < optArr.length; i++){
				if(optArr[i].value === searchType){
					optArr[i].selected = true;
					break;
				}
			}

			// 인풋태그 세팅
			const searchValueTag = document.querySelector('.search-area form input[name=searchValue]');
			searchValueTag.value = "<%= searchMap.get("searchValue") %>";
		}
		setSearchArea();

		function setPageArea(){
			
			const aTagArr = document.querySelectorAll('.paging a');
			for(let i = 0; i < aTagArr.length; i++){
				aTagArr[i].href = aTagArr[i].href.replace("list", "search");
				aTagArr[i].href += "&searchType=<%= searchMap.get("searchType") %>";
				aTagArr[i].href += "&searchValue=<%= searchMap.get("searchValue") %>";
			}
			
		}
		setPageArea();
	<% } %>

	
	

</script>
</body>
</html>