package manager;

import main.Main;
import mob.Pokemon;
import util.MyUtil;

public class BattleManager {

	public void startBattle() {
		
		boolean isFinish = false;
		
		// 유저 vs 적
		
		// 두 포켓몬의 정보 출력
		printPokemonInfo();
		
		while(true) {
			// 유저 행동 입력받기
			int num = scanUserAction();
			
			// fight
			isFinish = fight(Main.userPokemon, Main.enemyPokemon, num);
			if(isFinish) {
				System.out.println("유저 승리!");
				return;
			}
			
			// 적 행동 랜덤으로 진행
			isFinish = fight(Main.enemyPokemon, Main.userPokemon, MyUtil.getRandomInt(1, 2));
			if(isFinish) {
				System.out.println("유저 패배...");
				System.out.println("----- 배틀 종료 -----");
				return;
			}
		}
		
	}

	private int scanUserAction() {
		// 행동 목록 보여주기
		printActionList();
		// 유저 입력받기
		int num = Main.sc.nextInt();
		
		return num;
	}

	private boolean fight(Pokemon attacker, Pokemon defender, int num) {
		// 공격 메소드 호출
		switch(num) {
		case 1: attacker.bodyAttack(); break;
		case 2: attacker.skill(); break;
		}
//		switch(num) {
//		case 1: System.out.println(attacker + "의 몸통박치기! 효과는 굉장했다!"); break;
//		case 2: System.out.println(attacker + "의 스킬! 효과는 굉장했다!");
//		}
		// 데미지계산
		int dmg = attacker.getAtk() * num - defender.getDef();
		// 체력감소
		defender.setHp(defender.getHp() - dmg);
		System.out.println(defender.getName() + "(은)는 데미지 [" + dmg + "]를 받았다! 남은 체력은 " + defender.getHp() + "!");
		// 죽었는지 체크
		if(defender.getHp() <= 0) {
			System.out.println(defender.getName() + "(은)는 전투불능..");
			return true;
		} else {
			return false;
		}
	}

	private void printActionList() {
		System.out.println("-- 원하시는 동작의 번호를 입력하세요 --");
		System.out.println("1. 몸통박치기");
		System.out.println("2. 스킬사용");
	}

	private void printPokemonInfo() {
		System.out.println("야생의 [ " + Main.enemyPokemon.getName() + " ] (이)가 나타났다!");
		System.out.println("[ " + Main.userPokemon.getName() + " ] 전투준비!");
	}

}
