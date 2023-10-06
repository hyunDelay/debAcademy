package card;

public class September01 extends Card {
	
	public September01() {
		this.cardNum = 9;
		this.light = false;
		this.cardKey = 17;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│17 ꕤ ꕤ│");
		System.out.println("│ ꕤ     │");
		System.out.println("│ꕤꕤꕤ   │");
		System.out.println("│ ꕤꕤ ○ │");
		System.out.println("│───────│");
		System.out.println(cardBottom);
	}
}
