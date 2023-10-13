package game;

import game.rcp.RcpGameManager;
import game.updown.UpDownGameManager;

public class GameManager {
	
	public void printGameInfo() {
		// 게임번호 안내
		System.out.println("\n\n");
		System.out.println("======== 메인 ========");
		System.out.println("1. 업다운게임");
		System.out.println("2. 가위바위보");
		System.out.println("3. 포켓몬");
		System.out.println("9. 게임종료");
		System.out.println("=====================");
	}

	public void startUpDown() {
		UpDownGameManager gm = new UpDownGameManager();
		gm.startGame();
	}

	public void startRcp() {

		RcpGameManager gm = new RcpGameManager();
		gm.startGame();
		
	}

	public void startPokemon() {

		System.out.println("----- 포켓몬 -----");
		System.out.println("준비중...");
		
	}

}
