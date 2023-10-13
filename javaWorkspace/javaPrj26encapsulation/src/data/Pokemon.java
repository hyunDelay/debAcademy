package data;

public class Pokemon {
	
	// 기본 생성자 (매개변수 X) // JVM이 자동으로 생성 :: 생성자가 없을때만
	public Pokemon() {
		
	}
	
	// 모든 필드에 대한 매개변수 있는 생성자
	public Pokemon(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
	}
	
	// 필드
	private String name;
	private int hp;
	private int atk;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getAtk() {
		return atk;
	}
	public void setAtk(int atk) {
		this.atk = atk;
	}
	
	public void printInfo() {
		System.out.println("현재 클래스: [Pokemon]");
		System.out.print(this.name);
		System.out.print("  [HP] " + this.hp);
		System.out.print("  [ATK] " + this.atk);
	}
	
	public String toString() {
		return "Pokemon [name=" + name + ", hp=" + hp + ", atk=" + atk + "]";
	}
//	public String toString() {
//		return "현재 클래스: [Pokemon]\n[ " + this.name + " ]  " + "[HP] " + this.hp + "  [ATK] " + this.atk;
//	}
	
	
	
}
