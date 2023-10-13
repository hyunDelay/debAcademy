package main;

import mob.Dandegi;
import mob.Ggobugi;
import mob.Magikarp;
import mob.Pairi;
import mob.Pikachu;
import mob.Pokemon;
import mob.Purine;

public class Main {

	public static void main(String[] args) {

		System.out.println("===== 포켓몬 =====");
		
		Pokemon[] pokemonArr = new Pokemon[6];

		pokemonArr[0] = new Pikachu(100, 30, 10);
		pokemonArr[1] = new Pairi(95, 38, 5);
		pokemonArr[2] = new Ggobugi(110, 20, 20);
		pokemonArr[3] = new Purine(100, 20, 25);
		pokemonArr[4] = new Dandegi(120, 10, 30);
		pokemonArr[5] = new Magikarp(150, 0, 0);
		
		for(int i = 0; i < pokemonArr.length; i++) {
			System.out.println(pokemonArr[i]);
			pokemonArr[i].bodyAttack();
			pokemonArr[i].skill();
		}

		
	}

}
