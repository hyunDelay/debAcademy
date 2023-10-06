package card;

public class May01 extends Card {
	
	public May01() {
		this.cardNum = 5;
		this.light = false;
		this.cardKey = 9;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│9　⍋　  │");
		System.out.println("│⍋ ⍋　⍋　│");
		System.out.println("│ ⍋⍋⍋  │");
		System.out.println("│＼＼//  │");
		System.out.println("│//＼＼□□│");
		System.out.println(cardBottom);
	}
	
}
