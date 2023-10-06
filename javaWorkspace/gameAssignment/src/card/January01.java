package card;

public class January01 extends Card {

	public January01() {
		this.cardNum = 1;
		this.light = true;
		this.cardKey = 1;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│1　　　 ■│");
		System.out.println("│○ъ 　　　│");
		System.out.println("│ĳ　　　■■│");
		System.out.println("││─┐■■■■│");
		System.out.println("││　│■■光│");
		System.out.println(cardBottom);
	}
	
}
