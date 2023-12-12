<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>홈페이지</h1>
	<button onclick="loadData();">서버한테서 데이터 받아오기</button>
	
<script>
	function loadData(){
		fetch('/app21/board/list')
		.then((resp) => {return resp.json();})
		.then((data) => {console.log(data);});
	}
</script>
</body>
</html>