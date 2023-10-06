package game;

import card.Card;
import card.CardDeck;
import card.January01;
import main.Main;

public class GameStart {
	
	public void gameStart() {
		
		// 이름출력
		printGameName();
		
		while(true) {

			System.out.println("[자바게임 섯다] 시작하시겠습니까? 1. 시작  2. 종료");
			
			int num = scanUserInput();

			if(num == 2) {
				return;
			} else if(num == 1) {
				CardReady();
				break;
			} else {
				System.out.println("잘못 입력하셨습니다.");
			}
		}
		
	}
	
	
	private void CardReady() {
		
		// 유저 패 준비
		userCardReady();
		// 컴터 패준비
		npcCardReady();
	}


	private void printGameName() {
		System.out.println("□□□■■□□□□□□■■□□□□□□□□□□□□■■□□□□□□□□□□□□□■■□■■□□□■■■■■□□□□■■□  * 게임방법");
		System.out.println("□□□■■□□□□□□■■□□□□□□□□□□□□■■□□□□□□□□□□□□□■■□■■□□■■■■■■■□□□■■□    1. 처음에 섯다패 2장을 랜덤으로 받습니다.");
		System.out.println("□□□■■■■■■■■■■□□■■■■■■■■■□■■□□■■■■■■■■■□□■■□■■□□■■□□□■■□□□■■□    2. 콜/하프 중 하나를 선택하여 게임을 진행합니다.");
		System.out.println("□□■■■■□□□□□■■□□■■□□□□□□□□■■□□□□□□□□□■■□□■■□■■□□■■□□□■■□□□■■□    3. 자신도 콜이고 컴퓨터도 콜이면 마지막패를 받습니다.");
		System.out.println("□■■□□□■■□□□■■□□■■□□□□□□□□■■□□□□□□□□□■■■■■■□■■□□■■■■■■■□□□■■□    4. 3장이 되는 순간 세장의 패중 제일 높은 점수의 패를 선정하여 판단합니다.");
		System.out.println("■■□□□□■■□□□■■□□■■□□□□□□□□■■■■□□□□□□■■□□□■■□■■□□□■■■■■□□□□■■□   -------------------------------------------------------");
		System.out.println("□□□□□□□□□□□■■□□■■□□□□□□□□■■□□□□□□□■■□□□□■■□■■□□□□□□□□□□□□□□□  * 패 족보");
		System.out.println("□□□□□□■■■□□□□□□■■■■■■■■■□■■□□□□□□■■□□□□□■■□■■□□□■■■■■■■■■■■□    1위 38광땡          4위 알리   7위 장삥   10위 갑오(9끗)");
		System.out.println("□□□□■■■□■■■□□□□□□□□□□□□□□■■□□□□□■■□□□□□□■■□■■□□□■■□□□□□□□■■□    2위 18광땡/13광땡    5위 독사   8위 장사    11위 8끗 ~ 1끗");
		System.out.println("□□■■■□□□□□■■■□□□□□□□□□□□□■■□□□□■■□□□□□□□■■□■■□□□■■■■■■■■■■■□    3위 10땡 ~ 1땡      6위 구삥   9위 세륙");
		
	}


	private int scanUserInput() {
		int num = Main.sc.nextInt();
		return num;
	}

	public void npcCardReady() {
		// 카드 준비
		Main.npcCard[0] = Main.npcCardList.randomCard(1);
		Main.npcCard[1] = Main.npcCardList.randomCard(1);
	}

	public void userCardReady() {
		
		// 카드 준비
		Main.userCard[0] = Main.userCardList.randomCard(1);
		Main.userCard[1] = Main.userCardList.randomCard(2);
		
		// 배정된 유저카드 출력
		Main.userCard[0].cardDeck();
		Main.userCard[1].cardDeck();
		
	}

}
