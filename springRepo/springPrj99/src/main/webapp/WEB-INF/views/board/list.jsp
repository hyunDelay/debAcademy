<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	main {padding: 30px; display: flex; align-items: center; justify-content: center;}
	.tbl {width: 80%;}
	table {border-top: 1px solid #333; border-collapse: collapse; width: 100%;}
	table th,
	table td {
		border-bottom: 1px solid #ddd;
		padding: 6px 10px;
		text-align: center;
		font-size: 14px;
	}
</style>
</head>
<body>
	<div class="wrap">
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		<main>

			<div class="tbl">
				<table>
					<colgroup>
						<col width="10%">
						<col width="*">
						<col width="20%">
						<col width="20%">
					</colgroup>
					<thead>
						<tr>
							<th scope="col">번호</th>
							<th scope="col">제목</th>
							<th scope="col">글쓴이</th>
							<th scope="col">작성일</th>
						</tr>
					</thead>
					<tbody>
						<!-- <c:forEach items="${boardVoList}" var="boardVo">
							<tr>
								<td>${boardVo.no}</td>
								<td>${boardVo.title}</td>
								<td>${boardVo.writerNo}</td>
								<td>${boardVo.enrollDate}</td>
							</tr>
						</c:forEach> -->
					</tbody>
				</table>
			</div>
			
		</main>
	</div>

<script>
	 
	// const voList = [
	// 	{
	// 		no: '1',
	// 		title: '제목111',
	// 		content: '내용111'
	// 	},
	// 	{
	// 		no: '2',
	// 		title: '제목222',
	// 		content: '내용222'
	// 	},
	// 	{
	// 		no: '3',
	// 		title: '제목333',
	// 		content: '내용333'
	// 	}
	// ];
	fetch('/app/board/rest/list')
	.then(resp => resp.json())
	.then(data => { console.log(data) })
	;
	const voList = [];

	const mainDiv = document.querySelector('.tbl');
	let str = ''
            + '<table>'
            + '<thead>' 
            + '<tr>'
            + '<th>' + '번호' + '</th>'
            + '<th>' + '제목' + '</th>'
            + '<th>' + '내용' + '</th>'
            + '</tr>'
            + '</thead>' 
            + '<tbody>' 
            + '<tr>'
            + '<td>' + voList[0].no + '</td>'
            + '<td>' + voList[0].title + '</td>'
            + '<td>' + voList[0].content + '</td>'
            + '</tr>'
            + '<tr>'
            + '<td>' + voList[1].no + '</td>'
            + '<td>' + voList[1].title + '</td>'
            + '<td>' + voList[1].content + '</td>'
            + '</tr>'
            + '<tr>'
            + '<td>' + voList[2].no + '</td>'
            + '<td>' + voList[2].title + '</td>'
            + '<td>' + voList[2].content + '</td>'
            + '</tr>'
            + '</tbody>' 
            + '</table>';

	mainDiv.innerHTML = str;
</script>
</body>
</html>