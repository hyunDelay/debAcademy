package card;

public class August01 extends Card {
	
	public August01() {
		this.cardNum = 8;
		this.light = true;
		this.cardKey = 15;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│15 ──  │");
		System.out.println("│ /    ＼│");
		System.out.println("│ ＼    /│");
		System.out.println("│■■■───■│");
		System.out.println("│光 ■■■■■│");
		System.out.println(cardBottom);
	}
	
}
