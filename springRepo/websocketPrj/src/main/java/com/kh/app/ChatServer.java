package com.kh.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

// implements WebSocketHandler (인터페이스로 할 시)
public class ChatServer extends TextWebSocketHandler {
	
	private List<WebSocketSession> sessionList = new ArrayList<WebSocketSession>();

	// 소켓 연결 되었을 때 동작할 내용
	@Override
	public void afterConnectionEstablished(WebSocketSession session) throws Exception {
		System.out.println("연결되었습니다.");
		sessionList.add(session); // 모든세션을 ArrayList에 담음
	}

	// 메세지 받았을 때 동작할 내용
	@Override
	public void handleMessage(WebSocketSession session, WebSocketMessage<?> message) throws Exception {
//		System.out.println("메세지 받았습니다.");
//		System.out.println(message.getPayload());
		
		// 연결된 모든 세션에 메세지 보냄 // broadcast 브로드캐스트
		TextMessage x = new TextMessage(message.getPayload().toString()); // 문자열타입
		for (WebSocketSession webSocketSession : sessionList) { // ArrayList에 뿌려줌
			webSocketSession.sendMessage(x);
		}
	}

	// 소켓 연결 끊겼을 때 동작할 내용
	@Override
	public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
		System.out.println("연결이 끊겼습니다.");
		sessionList.remove(session); // 세션끊기면 ArrayList에서 삭제
	}
	
}
