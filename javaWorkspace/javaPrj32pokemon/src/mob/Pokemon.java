package mob;

import util.MyUtil;

public class Pokemon {

	public Pokemon() {
		
	}
	
	private String name;
	private int hp;
	private int atk;
	private int def;
	
	public static final String NAME01 = "푸린";
	public static final String NAME02 = "블래키";
	public static final String NAME03 = "잠만보";
	private static final int MIN_ATK = 15;
	private static final int MAX_DEF = 10;
	
	public Pokemon(String name) {
		this.name = name;
		this.hp = MyUtil.getRandomInt(100, 200);
		this.atk = MyUtil.getRandomInt(MIN_ATK, 50);
		this.def = MyUtil.getRandomInt(1, MAX_DEF);
	}
	
	public Pokemon(String name, int hp, int atk, int def) {
		this.name = name;
		this.hp = hp;
		this.atk = atk;
		this.def = def;
	}

	public void bodyAttack() {
		System.out.println(name + "의 몸통박치기! 효과는 굉장했다!");
	}
	
	public void skill() {
		System.out.println(name + "의 스킬! 효과는 굉장했다!");
	}

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

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public String toString() {
		return "Pokemon [name=" + name + ", hp=" + hp + ", atk=" + atk + ", def=" + def + "]";
	}

	
	
	
}
