package card;

public class June01 extends Card {
	
	public June01() {
		this.cardNum = 6;
		this.light = false;
		this.cardKey = 11;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│11     │");
		System.out.println("│εїз εїз│");
		System.out.println("│ꔛஐஐ   │");
		System.out.println("│ ஐ☼ﻬஐ       │");
		System.out.println("│ꔛஐஐꔛ │");
		System.out.println(cardBottom);
	}
	
}
