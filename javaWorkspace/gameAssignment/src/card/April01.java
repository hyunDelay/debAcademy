package card;

public class April01 extends Card {
	
	public April01() {
		this.cardNum = 4;
		this.light = false;
		this.cardKey = 7;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│7　//   │");
		System.out.println("│∠○ 　/ʚ/│");
		System.out.println("│ //ʚ/ɞ │");
		System.out.println("│ʚ/ʚ/ɞ  │");
		System.out.println("│/ɞ  ʚ│ɞ│");
		System.out.println(cardBottom);
	}
	
}
