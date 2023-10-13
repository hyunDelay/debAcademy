package game.updown;

import main.Main;

public class UpDownGameManager {

	public void startGame() {
		
		// 시도횟수
		int cnt = 0;
		
		// 정답 준비
		int answer = (int)(Math.random() * 100 + 1);

		System.out.println("----- 업다운게임 -----");
		System.out.println("1 ~ 100 사이의 정수를 입력해주세요.");
		while(true) {
			// 유저입력받기
			System.out.print("정답 입력 : ");
			String num_ = Main.scanUserInput();
			int num = Integer.parseInt(num_);
			cnt++;
			
			// 판단
			if(num == answer) {
				System.out.println("정답입니다!");
				break;
			} else if(num > answer) {
				System.out.println("Down");
			} else {
				System.out.println("Up");
			}
		}
		
		// 시도 횟수 출력
		System.out.println("시도횟수 : " + cnt);
		
	}
	
}
