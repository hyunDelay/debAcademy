package mob;

public class Pokemon {
	
	// 기본생성자
	public Pokemon() {
		
	}

	// 멤버 변수
	private String name;
	private int hp;
	private int atk;

	// 멤버 메소드
	public void bodyAttack() {
		System.out.println(this.name + "의 몸통박치기 ! ! !");
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
		if(hp < 0) {
			System.out.println("체력이 0보다 작을수 없습니다.");
		} else {
			this.hp = hp;			
		}
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}
	
	public String getFieldInfo() {
		return "이름 : " + this.name + "\n체력 : " + this.hp + "\n공격력 : " + this.atk;
	}
	
}
