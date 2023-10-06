package card;

public class May02 extends Card {

	public May02() {
		this.cardNum = 5;
		this.light = false;
		this.cardKey = 10;
	}
	
	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│10   ⍋ │");
		System.out.println("│──  ⍋  │");
		System.out.println("│ ＼ ＼⍋⍋│");
		System.out.println("│■⍋ ＼ ＼│");
		System.out.println("│■■■⍋ ──│");
		System.out.println(cardBottom);
	}
	
}
