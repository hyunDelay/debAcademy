package mob;

public class Purine extends Pokemon {
	
	public Purine() {
		super();
	}

	public Purine(int hp, int atk, int def) {
		super("푸린", hp, atk, def);
	}

	@Override
	public void skill() {
		System.out.println(name + "의 노래하기!");
	}

}
