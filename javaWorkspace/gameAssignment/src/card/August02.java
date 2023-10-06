package card;

public class August02 extends Card {
	
	public August02() {
		this.cardNum = 8;
		this.light = false;
		this.cardKey = 16;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│16  ¤  │");
		System.out.println("│ ¤   ¤ │");
		System.out.println("│   ¤   │");
		System.out.println("│■■■■■■■│");
		System.out.println("│■■■■■■■│");
		System.out.println(cardBottom);
	}
	
}
