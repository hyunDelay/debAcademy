package card;

public class October01 extends Card {
	
	public October01() {
		this.cardNum = 10;
		this.light = false;
		this.cardKey = 19;
	}

	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│19 ☆  ★│");
		System.out.println("│★☆ ★☆★ │");
		System.out.println("│ ㅇ≫  ☆│");
		System.out.println("│ ＼＼  □□│");
		System.out.println("│/   ──□│");
		System.out.println(cardBottom);
	}
}
