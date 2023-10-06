package card;

public class March01 extends Card {
	
	public March01() {
		this.cardNum = 3;
		this.light = true;
		this.cardKey = 5;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│5　✿ꕤꕤ │");
		System.out.println("│✿ꕤ✿ꕤ✿ꕤ│");
		System.out.println("│ꕤ✿✿✿ꕤ │");
		System.out.println("│■■■■■■■│");
		System.out.println("│光 ■■■■■│");
		System.out.println(cardBottom);
	}
	
}
