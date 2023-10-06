package card;

public class February01 extends Card {
	
	public February01() {
		this.cardNum = 2;
		this.light = false;
		this.cardKey = 3;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│3　　　 ■│");
		System.out.println("│∠○ 　■✿ │");
		System.out.println("│　( )✿　│");
		System.out.println("│✿✿ ■■  │");
		System.out.println("│✿ ■■   │");
		System.out.println(cardBottom);
		
		System.out.println("│1      │");
		System.out.println("│       │");
		System.out.println("│       │");
		System.out.println("│       │");
		System.out.println("│       │");
	}
	
}
