package card;

import java.util.ArrayList;
import java.util.List;

public class CardDeck {
	
	public List<Card> cardList = new ArrayList<>();
	
	public Object cardArr() {
		
		cardList.add(new January01());
		cardList.add(new January02());
		cardList.add(new February01());
		cardList.add(new February02());
		cardList.add(new March01());
		cardList.add(new March02());
		cardList.add(new April01());
		cardList.add(new April02());
		cardList.add(new May01());
		cardList.add(new May02());
		cardList.add(new June01());
		cardList.add(new June02());
		cardList.add(new July01());
		cardList.add(new July02());
		cardList.add(new August01());
		cardList.add(new August02());
		cardList.add(new September01());
		cardList.add(new September02());
		cardList.add(new October01());
		cardList.add(new October02());

		return cardList;
	}

	// 랜덤카드 준비
	public Card randomCard(int num) {
		cardArr();

		// 랜덤한 인덱스 생성 (1부터 listSize까지)
		int randomIndex1 = (int)(Math.random() * cardList.size());
		int randomIndex2;
		int randomIndex3;
		
        do {
            randomIndex2 = (int) (Math.random() * cardList.size());
        } while (randomIndex2 == randomIndex1); // index1과 중복되지 않도록 반복
        
        do {
            randomIndex3 = (int) (Math.random() * cardList.size());
        } while (randomIndex3 == randomIndex1 || randomIndex3 == randomIndex2); // randomIndex3와 중복되지 않도록 반복
        
        Card randomCard1 = cardList.get(randomIndex1);
        Card randomCard2 = cardList.get(randomIndex2);
        Card randomCard3 = cardList.get(randomIndex3);
        
        // 카드 요청하면 숫자대로 랜덤배정
        switch(num) {
        case 1: return randomCard1;
        case 2: return randomCard2;
        case 3: return randomCard3;
        default: return null;
        }
        
	}

}
