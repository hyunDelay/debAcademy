package main;

import mob.Pairi;
import mob.Pikachu;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("상속연습");
		
		Pairi p = new Pairi();
		p.skill();
		p.bodyAttack();
		
		Pikachu pikachu = new Pikachu();
		pikachu.skill();
		pikachu.bodyAttack();

	}

}
