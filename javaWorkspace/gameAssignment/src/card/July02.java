package card;

public class July02 extends Card {
	
	public July02() {
		this.cardNum = 7;
		this.light = false;
		this.cardKey = 14;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│13 ✤✤  │");
		System.out.println("│ ✤ ── ─│");
		System.out.println("│✤ / /└─│");
		System.out.println("│ / / ✤ │");
		System.out.println("│─── ✤＼─│");
		System.out.println(cardBottom);
	}
	
}
