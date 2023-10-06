package card;

public class June02 extends Card {
	
	public June02() {
		this.cardNum = 6;
		this.light = false;
		this.cardKey = 12;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│12     │");
		System.out.println("│  ── ꔛ│");
		System.out.println("│ꔛ ＼ ＼ │");
		System.out.println("│ ஐ☼ﻬஐ──│");
		System.out.println("│ꔛஐஐꔛ │");
		System.out.println(cardBottom);
	}
	
}
