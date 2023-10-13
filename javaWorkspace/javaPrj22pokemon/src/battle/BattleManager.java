package battle;

import mob.Pokemn;

public class BattleManager {
	
	// 승자
	String winner = null; // 멤버변수
	
	Pokemn p1 = null;
	Pokemn p2 = null;
	
	// 포켓몬 생성 메소드
//	public void generatePokemon() {
//		p1 = new Pokemn();
//		p1.name = "피카츄";
//		p1.hp = 1000;
//		p1.atk = 30;
//		
//		p2 = new Pokemn();
//		p2.name = "파이리";
//		p2.hp = 1000;
//		p2.atk = 33;
//	}
	public Pokemn generatePokemon(String name, int hp) {
		Pokemn pokemon = new Pokemn();
		pokemon.name = name;
		pokemon.hp = hp;
		pokemon.atk = 0;
		return pokemon;
	}
	
	
	
	// 배틀 시작 메소드
	public void battleStart() {

		// 포켓몬 2마리 생성
		p1 = generatePokemon("피카츄", 5000);
		p2 = generatePokemon("파이리", 5000);

		
		// 반복문
		while(this.winner == null) {
			
			this.mobAttack(p1, p2);
			if(winner != null) {break;}
			this.mobAttack(p2, p1);
			if(winner != null) {break;}
			
		}
		
		
		// 결과 출력
		System.out.println(p1.name + "의 남은체력 : " + p1.hp);
		System.out.println(p2.name + "의 남은체력 : " + p2.hp);
		System.out.println(this.winner + "의 승리!");
		
	}
	
	public void mobAttack(Pokemn attacker, Pokemn defender) {
		int randomAtk = (int)(Math.random() * 100); // 새로운 랜덤 atk 생성
		System.out.println(attacker.name + "(이)가 " + defender.name + "(을)를 공격했습니다. 데미지 [" + randomAtk + "] !!!");
		defender.hp -= randomAtk;
		
		if (defender.hp <= 0) {
			winner = attacker.name;
		}
	}
	
	
}// class
