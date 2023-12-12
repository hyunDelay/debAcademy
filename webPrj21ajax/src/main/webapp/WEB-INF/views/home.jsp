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
	<hr>
	<button onclick="sendData();">서버한테 데이터 보내기</button>
	
<script>
	function loadData(){
		fetch('/app21/board/list')
		.then((resp) => {return resp.json();})
		.then((data) => {console.log(data);});
	}
	function sendData(){
		
		const x = {str: "hello"};
		
		fetch('/app21/test', {
			method: 'post',
			body: JSON.stringify(x)
		})
		.then( resp => resp.json() )
		.then( data => console.log(data))
		.catch(() => {console.log('catch블럭 실행');})
		;
		
	}
</script>
</body>
</html>