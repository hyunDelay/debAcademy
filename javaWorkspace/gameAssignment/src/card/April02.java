package card;

public class April02 extends Card {
	
	public April02() {
		this.cardNum = 4;
		this.light = false;
		this.cardKey = 8;
	}
	
	public void cardDeck() {
		System.out.println(cardTop);
		System.out.println("│8　　ʚ│ɞ│");
		System.out.println("│─ ＼ʚ│ɞ│");
		System.out.println("│＼  ＼│ɞ│");
		System.out.println("│ʚ ＼  │ɞ│");
		System.out.println("│ ʚ│ ─│ɞ│");
		System.out.println(cardBottom);
	}
	
}
