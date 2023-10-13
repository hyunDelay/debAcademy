package mob;

public class Pokemn {

	// 멤버 == 구성요소 (멤버변수, 멤버메소드)
	public String name; // 접근제한자를 적어야 다른 class에서 작동함
	public int hp;
	public int atk;
	
	public void attack() {
		System.out.println("공격!!");
	}
	
}
