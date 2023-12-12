<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	li, ul {
		list-style: none;
		margin: 0;
		padding: 0;
	}
	.gallery-area {
		display: flex;
		flex-wrap: wrap;
		gap: 20px;
		padding: 20px;
		box-sizing: border-box;
	}
	.gallery-area li {
		width: calc(33.33% - 14px);
		padding: 20px;
		box-sizing: border-box;
		border: 1px solid #ddd;
		cursor: pointer;
	}
	.gallery-area li .img {
		width: 100%;
		height: 125px;
		overflow: hidden;
	}
	.gallery-area li .img img {
		display: block;
		width: 100%;
		height: 125px;
	}
	.gallery-area li span {
		display: block;
		padding-top: 5px;
		font-size: 14px;
	}
	.paging {
		display: flex;
		justify-content: center;
		list-style: none;
		margin: 40px auto 20px;
	}
	.paging a {
		display: block;
		padding: 5px 10px;
		color: #333;
		text-decoration: none;
		font-size: 14px;
	}
	.paging li.on a,
	.paging a:hover {
		background-color: #333;
		color: #fff;
	}
	.top-area {
		display: flex;
		justify-content: flex-end;
		padding: 20px 20px 0 20px;
		margin-top: 20px;
		box-sizing: border-box;
	}
	.top-area button {
		display: block;
		padding: 8px 20px;
		background-color: #333;
		border: none;
		cursor: pointer;
		color: #fff;
	}
</style>
</head>
<body>
	<div id="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		
		<main>
			
			<div class="gallery">

				<div class="top-area">
					<button onclick="location.href='/app99/gallery/write'">작성하기</button>
				</div>

				<ul class="gallery-area">
					<c:forEach items="${galleryVoList}" var="vo">
						<li>
							<div class="img"><img src="${vo.src}" alt="${vo.originName}"></div>
							<span>${vo.title}</span>
						</li>					
					</c:forEach>
				</ul>

				<ul class="paging">
					<li><a href="">이전</a></li>
					<li><a href="">1</a></li>
					<li><a href="">2</a></li>
					<li><a href="">3</a></li>
					<li><a href="">4</a></li>
					<li><a href="">5</a></li>
					<li><a href="">다음</a></li>
				</ul>

			</div>

		</main>
	</div>
</body>
</html>