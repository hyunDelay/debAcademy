package main;

import mob.Ggobugi;
import mob.Pairi;
import mob.Pikachu;
import mob.Pokemon;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("===== 상속 =====");
		
		Pikachu pikachu = new Pikachu();
		System.out.println(pikachu.toString());
		
		Pairi pairi = new Pairi();
		System.out.println(pairi.toString());
		
		Ggobugi ggobugi = new Ggobugi();
		System.out.println(ggobugi.toString());
		
	}

}
