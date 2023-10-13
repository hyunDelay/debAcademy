package mob;

public class Pikachu extends Pokemon {
	
	public Pikachu() {
		
	}
	
	public void skill() {
		System.out.println(name + "의 백만볼트!");
	}

	public String toString() {
		return "Pikachu [name=" + name + ", hp=" + hp + ", atk=" + atk + ", def=" + def + "]";
	}
	
}
