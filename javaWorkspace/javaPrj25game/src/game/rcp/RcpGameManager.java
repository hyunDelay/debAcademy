package game.rcp;

import main.Main;

public class RcpGameManager {
	
	public void startGame() {
		
		String status = "";
		
		while(true) {
			System.out.println("가위 바위 보 중 하나를 입력하세요.");
			
			// 컴퓨터 패 준비
			String com = "";
			int num = (int)(Math.random() * 3 + 1);
			
			switch(num) {
				case 1: com = "가위"; break;
				case 2: com = "바위"; break;
				default: com = "보";
			}
			
			// 유저 패 준비
			String user = Main.scanUserInput();
			
			// 유저 패 이상하면 다시 준비
			if(!user.equals("가위") && !user.equals("바위") && !user.equals("보")) {
				System.out.println("잘못 입력하셨습니다. 다시 시도해주세요");
				continue;
			}

			// 판단
			if (com.equals(user)) {
				status = "draw";
			} else if ((com.equals("가위") && user.equals("보")) || (com.equals("바위") && user.equals("가위")) || (com.equals("보") && user.equals("바위"))) {
				status = "lose";
			} else if(com.equals("가위") && user.equals("바위") || com.equals("바위") && user.equals("보") || com.equals("보") && user.equals("가위")) {
				status = "win";
			}
			                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                            
			// 판단 결과에 따라 출력문 실행
			System.out.println("유저 <<" + user + ">> VS 컴퓨터 <<" + com + ">>");
			if(status.equals("win")) {
				System.out.println("유저가 이겼습니다!");
				
				// 재경기 희망 여부 체크
				System.out.println("재경기 하시겠습니까? y/n");
				String reply = Main.scanUserInput();
				
			    if(reply.equals("n")) {
			    	break;
			    } else {
					System.out.println("게임을 다시 시작합니다.");
			    }
			    
			} else if(status.equals("draw")) {
				System.out.println("비겼습니다.");
			} else if(status.equals("lose")) {
				System.out.println("유저가 졌습니다...");
			} 
			
		}
		System.out.println("=========게임을 종료합니다.");
		
	}

}
