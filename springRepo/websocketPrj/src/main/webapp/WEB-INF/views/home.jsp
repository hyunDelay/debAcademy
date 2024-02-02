<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>채팅</title>
</head>
<body>

	<h1>채팅</h1>
	
	<form id="formTag">
		<input type="text" name="msg">
		<input type="submit" value="전송">
	</form>
	
	<div id="msgArea"></div>

<script>
	const ws = new WebSocket("ws://localhost:8080/app/chatserver");
	
	ws.onopen = () => {console.log("open!");};
	ws.onclose = () => {console.log("onclose!");};
	ws.onerror = () => {console.log("onerror!");};
	ws.onmessage = (serverMsg) => {
		console.log("서버에서 메시지 받음");
		const msgArea = document.querySelector("#msgArea");
		let str = "<p>" + serverMsg.data + "</p>";
		msgArea.innerHTML += str;
	};
	
	// 전송 버튼 누르면 동작하는 함수
	const formTag = document.querySelector("#formTag");
	formTag.addEventListener("submit", (e) => {
		e.preventDefault();
		
		// 웹소켓 이용해서 메세지 보내기
		const inp = document.querySelector("input[name=msg]");
		ws.send(inp.value);
	});
	
</script>

</body>
</html>