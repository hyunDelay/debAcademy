package game;

import card.Card;
import main.Main;

public class GameManager {
	
	public void game() {

		// 번갈아가며 대결
		battle();
		
		// 승패 판단
		Judgment judgment = new Judgment();
		judgment.scoreJudgment();
	}

	public void battle() {

		Main.userCard[2] = null;
		
		// 3장째의 값이 null이 아닐때
		while(Main.userCard[2] == null) {
			// 유저 선택
			System.out.println("1. 콜  2. 하프");
			
			int num = scanUserInput();
			if(num == 1) {
				call();
				Main.userCallCard = true;
			} else if(num == 2) {
				half();
			}
			
			
			// 컴터 선택
			int comNum = (int)(Math.random() * 2 + 1);
			if(comNum == 1) {
				System.out.println("컴퓨터는 [콜]");
				Main.npcCallCard = true;
			} else {
				System.out.println("컴퓨터는 [하프]");
			}
			
			// 둘다 콜일때 카드 한장 더 배분
			if(Main.userCallCard == Main.npcCallCard) {
				Main.userCard[2] = Main.userCardList.randomCard(3);
				Main.npcCard[2] = Main.npcCardList.randomCard(3);
				
				// 배정된 유저 카드 출력
				System.out.println("-- 새로운 카드 --");
				Main.userCard[2].cardDeck();
				System.out.println("-- 기존카드 --");
				Main.userCard[0].cardDeck();
				Main.userCard[1].cardDeck();
			} else {
				System.out.println("게임을 계속 진행합니다.\n");
			}
		}
		
		
		
	}

	private void half() {
		System.out.println("[하프] 판돈의 2배 배팅합니다. 현재 게임은 돈이 구현되어있지 않습니다.");
	}

	private void call() {
		System.out.println("[콜] 판돈을 배팅합니다. 현재 게임은 돈이 구현되어있지 않습니다.");
		Main.userCallCard = true;
	}

	private int scanUserInput() {
		int num = Main.sc.nextInt();
		return num;
	}
	
}
