package card;

public class July01 extends Card {
	
	public July01() {
		this.cardNum = 7;
		this.light = false;
		this.cardKey = 13;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│13 ✤✤  │");
		System.out.println("│ ✤─── ─ │");
		System.out.println("│  ✤✤✤└─│");
		System.out.println("│   ──  │");
		System.out.println("│＼/   ＼│");
		System.out.println(cardBottom);
	}
	
}
