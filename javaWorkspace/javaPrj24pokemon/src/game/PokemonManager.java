package game;

import java.util.Scanner;

import main.Main;
import mob.Pokemon;

public class PokemonManager {
	
	
	// 포켓몬 목록 보여주기
	public void selectPokemon() {
		// 포켓몬 목록 보여주기
		this.showPokemonList();
		
		// 유저 입력받기
		int num = scanUserInput();
		
		// 입력번호에 맞게 포켓몬 기억하기
		setUserPokemon(num);
	}
	
	public void setUserPokemon(int x) {
		switch(x) {
			case 1: Main.userPokemon = Main.p1; break;
			case 2: Main.userPokemon = Main.p2; break;
			case 3: Main.userPokemon = Main.p3; break;
			default: System.out.println("잘못 입력하셨습니다.");
		}
	}
	
	public int scanUserInput() {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		return num;
	}
	
	public void showPokemonList() {
		// 포켓몬 목록 생성
		generatePokemonList();
		
		// 포켓몬 목록 출력
		printPokemonList();
	}
	
	// 입력에 맞게 포켓몬 기억하기
	
	
	public void generatePokemonList() {
		// 포켓몬 3마리 임의로 생선
		Main.p1 = new Pokemon();
		Main.p1.name = "피카츄";
		Main.p1.hp = 100;
		Main.p1.atk = 30;
		Main.p1.def = 5;
		
		Main.p2 = new Pokemon();
		Main.p2.name = "파이리";
		Main.p2.hp = 90;
		Main.p2.atk = 35;
		Main.p2.def = 5;
		
		Main.p3 = new Pokemon();
		Main.p3.name = "꼬부기";
		Main.p3.hp = 150;
		Main.p3.atk = 20;
		Main.p3.def = 5;
	}
	
	public void printPokemonList(){
		System.out.println("====== 포켓몬 목록 ======");
		System.out.println("1. " + Main.p1.name);
		System.out.println("2. " + Main.p2.name);
		System.out.println("3. " + Main.p3.name);
		System.out.println("======================");
	}

}
