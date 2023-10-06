package card;

public class September02 extends Card {
	
	public September02() {
		this.cardNum = 9;
		this.light = false;
		this.cardKey = 18;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│18 ꕤ   │");
		System.out.println("│   ─── │");
		System.out.println("│ ꕤ/ 청/ │");
		System.out.println("│ / 단/ꕤ │");
		System.out.println("│ ─── ꕤꕤ│");
		System.out.println(cardBottom);
	}
}
