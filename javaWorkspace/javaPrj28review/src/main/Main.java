package main;

import mob.Pokemon;

public class Main {

	public static void main(String[] args) {
		
		System.out.println("복습2");
		
		Pokemon p = new Pokemon();
		p.setName("피카츄");
		p.setHp(100);
		p.setAtk(30);
		
		String txt = p.getFieldInfo();
		System.out.println(txt);
		
	}

}
