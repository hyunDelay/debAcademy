package game;

import java.util.HashSet;
import java.util.Set;

import card.Card;
import card.CardDeck;
import main.Main;

public class Judgment {

	// 판단
	public void scoreJudgment() {
		
		// 유저의 제일 점수높은 단계를 보여줌
		scoreCal(Main.userCard[0], Main.userCard[1], Main.userCard[2]);
		int userScore = Main.score;
		System.out.println("------------- 컴퓨터 패 -------------");
		Main.npcCard[0].cardDeck();
		Main.npcCard[1].cardDeck();
		Main.npcCard[2].cardDeck();
		scoreCal(Main.npcCard[0], Main.npcCard[1], Main.npcCard[2]);
		int npcScore = Main.score;
		
		if(userScore > npcScore) {
			System.out.println("===========================================");
			System.out.println("================= 유저 승리!! ================");
			System.out.println("===========================================");
		} else {
			System.out.println("===========================================");
			System.out.println("================= 유저 패배.. ================");
			System.out.println("===========================================");
		}
		
	}
	
	// 유저 점수계산
	public void scoreCal(Card player1, Card player2, Card player3) {
		Main.score = 0;
		
		// 20. 갑오, 끗
		int[] GGt = new int[3];
		GGt[0] = (player1.getCardKey() + player2.getCardKey()) % 10;
		GGt[1] = (player1.getCardKey() + player3.getCardKey()) % 10;
		GGt[2] = (player2.getCardKey() + player3.getCardKey()) % 10;
		for(int i = 0; i < GGt.length; i++) {
			switch(GGt[i]) {
			case 1: System.out.println("[ 한끗 ]"); Main.score = 10;  break;
			case 2: System.out.println("[ 두끗 ]"); Main.score = 15; break;
			case 3: System.out.println("[ 세끗 ]"); Main.score = 20; break;
			case 4: System.out.println("[ 네끗 ]"); Main.score = 25; break;
			case 5: System.out.println("[ 5끗 ]"); Main.score = 30; break;
			case 6: System.out.println("[ 6끗 ]"); Main.score = 35; break;
			case 7: System.out.println("[ 7끗 ]"); Main.score = 40; break;
			case 8: System.out.println("[ 8끗 ]"); Main.score = 45; break;
			case 9: System.out.println("[ 갑오 ]"); Main.score = 50; break;
			}
		}
		
		// 19. 세륙
		if (player1.getCardNum() == 4 && player2.getCardNum() == 6 ||
		     player1.getCardNum() == 6 && player2.getCardNum() == 4 ||
		     player1.getCardNum() == 4 && player3.getCardNum() == 6 ||
		     player1.getCardNum() == 6 && player3.getCardNum() == 4 ||
		     player2.getCardNum() == 4 && player3.getCardNum() == 6 ||
		     player2.getCardNum() == 6 && player3.getCardNum() == 4 ) {
		    System.out.println("[ 장사 ]");
		    Main.score = 60;
		}
		
		// 18. 장사
		if (player1.getCardNum() == 4 && player2.getCardNum() == 10 ||
		     player1.getCardNum() == 10 && player2.getCardNum() == 4 ||
		     player1.getCardNum() == 4 && player3.getCardNum() == 10 ||
		     player1.getCardNum() == 10 && player3.getCardNum() == 4 ||
		     player2.getCardNum() == 4 && player3.getCardNum() == 10 ||
		     player2.getCardNum() == 10 && player3.getCardNum() == 4 ) {
		    System.out.println("[ 장사 ]");
		    Main.score = 60;
		}

		// 17. 장삥
		if (player1.getCardNum() == 1 && player2.getCardNum() == 10 ||
		     player1.getCardNum() == 10 && player2.getCardNum() == 1 ||
		     player1.getCardNum() == 1 && player3.getCardNum() == 10 ||
		     player1.getCardNum() == 10 && player3.getCardNum() == 1 ||
		     player2.getCardNum() == 1 && player3.getCardNum() == 10 ||
		     player2.getCardNum() == 10 && player3.getCardNum() == 1 ) {
		    System.out.println("[ 장삥 ]");
		    Main.score = 60;
		}
		
		// 16. 구삥
		if (player1.getCardNum() == 1 && player2.getCardNum() == 9 ||
		     player1.getCardNum() == 9 && player2.getCardNum() == 1 ||
		     player1.getCardNum() == 1 && player3.getCardNum() == 9 ||
		     player1.getCardNum() == 9 && player3.getCardNum() == 1 ||
	     	 player2.getCardNum() == 1 && player3.getCardNum() == 9 ||
			 player2.getCardNum() == 9 && player3.getCardNum() == 1 ) {
		    System.out.println("[ 구삥 ]");
		    Main.score = 70;
		}
		
		// 15. 독사
		if (player1.getCardNum() == 1 && player2.getCardNum() == 4 ||
		     player1.getCardNum() == 4 && player2.getCardNum() == 1 ||
		     player1.getCardNum() == 1 && player3.getCardNum() == 4 ||
		     player1.getCardNum() == 4 && player3.getCardNum() == 1 ||
		     player2.getCardNum() == 1 && player3.getCardNum() == 4 ||
		     player2.getCardNum() == 4 && player3.getCardNum() == 1 ) {
		    System.out.println("[ 독사 ]");
		    Main.score = 80;
		}
		
		// 14. 알리
		if (player1.getCardNum() == 1 && player2.getCardNum() == 2 ||
		     player1.getCardNum() == 2 && player2.getCardNum() == 1 ||
		     player1.getCardNum() == 1 && player3.getCardNum() == 2 ||
		     player1.getCardNum() == 2 && player3.getCardNum() == 1 ||
		     player2.getCardNum() == 1 && player3.getCardNum() == 2 ||
		     player2.getCardNum() == 2 && player3.getCardNum() == 1 ) {
		    System.out.println("[ 알리 ]");
		    Main.score = 90;
		}
		
		// 3. 땡처리
		Set<Integer> cardNumSet = new HashSet<>();
		for (Card card : new Card[]{player1, player2, player3}) {
	        int cardNum = card.getCardNum();
	        if (cardNumSet.contains(cardNum)) {
	            // 중복된 숫자를 발견한 경우
	            System.out.print("[ " + cardNum + "땡 ]");
	            switch (cardNum) {
	                case 1: Main.score = 100; break;
	                case 2: Main.score = 200; break;
	                case 3: Main.score = 300; break;
	                case 4: Main.score = 400; break;
	                case 5: Main.score = 500; break;
	                case 6: Main.score = 600; break;
	                case 7: Main.score = 700; break;
	                case 8: Main.score = 800; break;
	                case 9: Main.score = 900; break;
	                case 10: Main.score = 1000; break;
	                default: break;
	            }
	        } else {
	            cardNumSet.add(cardNum); // 숫자를 HashSet에 추가
	        }
	    }
		
		// 2. 13광땡 = 18광땡
		if ((player1.getCardKey() == 1 && player2.getCardKey() == 5 && player3.getCardKey() == 15) ||
		    (player1.getCardKey() == 1 && player2.getCardKey() == 15 && player3.getCardKey() == 5) ||
		    (player1.getCardKey() == 5 && player2.getCardKey() == 1 && player3.getCardKey() == 15) ||
		    (player1.getCardKey() == 5 && player2.getCardKey() == 15 && player3.getCardKey() == 1) ||
		    (player1.getCardKey() == 15 && player2.getCardKey() == 1 && player3.getCardKey() == 5) ||
		    (player1.getCardKey() == 15 && player2.getCardKey() == 5 && player3.getCardKey() == 1)) {
		    System.out.println("[ 13광땡 ]!");
		    Main.score = 1100;
		}

		if ((player1.getCardKey() == 1 && player2.getCardKey() == 18 && player3.getCardKey() == 15) ||
		    (player1.getCardKey() == 1 && player2.getCardKey() == 15 && player3.getCardKey() == 18) ||
		    (player1.getCardKey() == 18 && player2.getCardKey() == 1 && player3.getCardKey() == 15) ||
		    (player1.getCardKey() == 18 && player2.getCardKey() == 15 && player3.getCardKey() == 1) ||
		    (player1.getCardKey() == 15 && player2.getCardKey() == 1 && player3.getCardKey() == 18) ||
		    (player1.getCardKey() == 15 && player2.getCardKey() == 18 && player3.getCardKey() == 1)) {
		    System.out.println("[ 18광땡 ]!");
		    Main.score = 1100;
		}
		

		// 1. 38광땡
		if ((player1.getCardKey() == 5 && player2.getCardKey() == 15 && player3.getCardKey() == 15) ||
			(player1.getCardKey() == 15 && player2.getCardKey() == 5 && player3.getCardKey() == 15) || 
			(player1.getCardKey() == 15 && player2.getCardKey() == 15 && player3.getCardKey() == 5)) {
		    System.out.println("[ 삼팔광땡 ]!!! 축하합니다");
		    Main.score = 1200;
		}
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
}
