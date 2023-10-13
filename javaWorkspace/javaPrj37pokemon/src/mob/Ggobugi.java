package mob;

public class Ggobugi extends Pokemon {
	
	public Ggobugi() {
		super();
	}

	public Ggobugi(int hp, int atk, int def) {
		super("꼬부기", hp, atk, def);
	}

	@Override
	public void skill() {
		System.out.println(name + "의 물대포!");
	}

}
