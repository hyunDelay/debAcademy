package mob;

public class Ggobugi extends Pokemon {
	
	public Ggobugi() {

	}
	
	public void skill() {
		System.out.println(name + "의 물대포!");
	}
	
	public String toString() {
		return "Ggobugi [name=" + name + ", hp=" + hp + ", atk=" + atk + ", def=" + def + "]";
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

	
	
}
