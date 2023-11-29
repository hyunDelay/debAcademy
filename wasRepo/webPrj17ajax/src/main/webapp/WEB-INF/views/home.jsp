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
	<button onclick="f01();">버튼</button>
	<h2></h2>
	<h3></h3>
<script>
	function f01(){
		
		// 서버한테 요청보내기
		//fetch(주소, 옵션);
		fetch("/app17/test")
		.then( (resp) => { return resp.json() } ) // 데이터 가공
		.then( (x) => { // 가공된 데이터로 할수있는거 하기
			console.log(x);
			const hh = document.querySelector('h2');
			const hh3 = document.querySelector('h3');
			hh.textContent = x.title;
			hh3.textContent = x.content;
		} );
		
	}
</script>
</body>
</html>