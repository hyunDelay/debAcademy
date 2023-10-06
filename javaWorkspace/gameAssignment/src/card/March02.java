package card;

public class March02 extends Card {
	
	public March02() {
		this.cardNum = 3;
		this.light = false;
		this.cardKey = 6;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│6　ꕤ── │");
		System.out.println("│ ꕤ│홍│ꕤ│");
		System.out.println("│ │단│ꕤ │");
		System.out.println("│ꕤ───ꕤ │");
		System.out.println("│ ꕤꕤ   │");
		System.out.println(cardBottom);
	}
	
}
