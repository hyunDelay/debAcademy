package card;

public class October02 extends Card {
	
	public October02() {
		this.cardNum = 10;
		this.light = false;
		this.cardKey = 20;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│20 ★   │");
		System.out.println("│───  ☆☆│");
		System.out.println("│☆＼청＼ ★│");
		System.out.println("│   ＼단＼│");
		System.out.println("│ ★★ ☆──│");
		System.out.println(cardBottom);
	}
}
