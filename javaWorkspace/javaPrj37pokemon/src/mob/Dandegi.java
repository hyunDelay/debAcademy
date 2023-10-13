package mob;

public class Dandegi extends Pokemon {
	
	public Dandegi() {
		super();
	}

	public Dandegi(int hp, int atk, int def) {
		super("단데기", hp, atk, def);
	}

	@Override
	public void skill() {
		System.out.println(name + "의 단단해지기!");
	}

}
