package mob;

public class Magikarp extends Pokemon {
	
	public Magikarp() {
		super();
	}

	public Magikarp(int hp, int atk, int def) {
		super("잉어킹", hp, atk, def);
	}

	@Override
	public void skill() {
		System.out.println(name + "의 튀어오르기! 효과는 없었다.");
	}

}
