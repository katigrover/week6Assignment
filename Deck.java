package week6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Deck {

	private String[] cardSuit = new String[] {"Clubs", "Hearts", "Diamonds", "Spades"};
	private Map<String, Integer> cardMap = new LinkedHashMap<String, Integer>();
			
	private void initCardMap() {
		for(int i = 2; i < 11; i++) {
			cardMap.put(String.valueOf(i), i);
		}
		cardMap.put("Jack", 11);
		cardMap.put("Queen", 12);
		cardMap.put("King", 13);
		cardMap.put("Ace", 14);
	}	
		
	private List<Card> cards = new ArrayList<Card>();
		
	public List<Card> getCards() {
		return cards;
	}
	
	public Deck () {
		initCardMap();
		for (String suit:cardSuit) {
			cardMap.entrySet().forEach(me->{
				String face	= me.getKey();
				Integer value = me.getValue();
				Card c = new Card();
				c.setName(face + " of " + suit);
				c.setValue(value);
				cards.add(c);
				Collections.shuffle(cards);
			});
			
		}
	}
		
	public void printDeck() {
		for(Card c : cards) {
			System.out.println(c.getName() + " : " + c.getValue());
		}
	}
	
	public Card drawCard() {
		Card topOfDeck = cards.get(0);
		cards.remove(0);
		return topOfDeck;
	}
	
}
