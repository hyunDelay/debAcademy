package card;

public abstract class Card {
	
	// 카드 속성
	protected boolean light;
	protected int cardNum;
	protected int cardKey;
	

	public void setCardKey(int cardKey) {
		this.cardKey = cardKey;
	}

	protected String cardTop = "┌───────┐";
	protected String cardBottom = "└───────┘";
	
	// 카드 덱
	public abstract void cardDeck();

	// getter, setter
	public boolean isLight() {
		return light;
	}

	public void setLight(boolean light) {
		this.light = light;
	}

	public int getCardNum() {
		return cardNum;
	}

	public int getCardKey() {
		return cardKey;
	}
	
}
