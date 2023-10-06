package card;

public class January02 extends Card {
	
	public January02() {
		this.cardNum = 1;
		this.light = false;
		this.cardKey = 2;
	}
	
	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│2　　　 ■│");
		System.out.println("│홍＼　■■　│");
		System.out.println("│　단＼■　 │");
		System.out.println("│＼───　■■│");
		System.out.println("│　■■■　　│");
		System.out.println(cardBottom);
	}
	
}
