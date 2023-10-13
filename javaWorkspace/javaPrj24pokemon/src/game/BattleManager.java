package game;

import main.Main;
import mob.Pokemon;

public class BattleManager {
	
	public void battleStart() {
		selectRandomEnemy();
		
		Pokemon winner = null;
		while(true) {
			winner = fight(Main.userPokemon, Main.enemyPokemon);
			if(winner != null) {break;}
			winner = fight(Main.enemyPokemon, Main.userPokemon);
			if(winner != null) {break;}
		}
		System.out.println(winner.name + "의 승리 ! ! !");
	}
	
	public Pokemon fight(Pokemon attacker, Pokemon defender) {
		// attacker 공격
		attacker.bodyAttack();
		int damege = attacker.atk - defender.def; // 데미지 계산
		System.out.println("데미지 [ " + damege + " ]");
		defender.hp -= damege; // 데미지 적용
		System.out.println(defender.name + "의 남은 체력 : " + defender.hp);
		
		// defender가 죽었는지 판단. 죽었으면 승자 리턴.
		if(defender.hp <= 0) {
			return attacker;
		} else {
			return null;
		}
	}

	public void selectRandomEnemy() {
		int random = (int)(Math.random() * 3 + 1);
		
		switch(random) {
			case 1: Main.enemyPokemon = Main.p1; break;
			case 2: Main.enemyPokemon = Main.p2; break;
			case 3: Main.enemyPokemon = Main.p3; break;
			default: System.out.println("잘못 입력하셨습니다.");
		}
	}

}
