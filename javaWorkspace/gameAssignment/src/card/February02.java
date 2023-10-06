package card;

public class February02 extends Card {
	
	public February02() {
		this.cardNum = 2;
		this.light = false;
		this.cardKey = 4;
	}
	
	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│4　✿　 ■│");
		System.out.println("│홍＼✿■✿　│");
		System.out.println("│　단＼■✿ │");
		System.out.println("│＼───■■■│");
		System.out.println("│✿■■■■ 　│");
		System.out.println(cardBottom);
	}
	
}
