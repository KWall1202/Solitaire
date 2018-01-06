package Solitaire;

import java.util.ArrayList;
import java.util.Collections;

/*
 * A deck class to be used in a solitaire game
 * Aces have value 1
 * @Author Kevin Wallace
 */
public class Deck {
	private ArrayList<Card> deck = new ArrayList<>();
	
	public Deck() {
		reset();
	}
	
	/*
	 * Sets the deck to a regular deck of cards, 2-Ace of every suit
	 * Does not leave the deck in a shuffled state
	 */
	public void reset() {
		String[] suits = {"clubs", "spades", "hearts", "diamonds"};
		for(String suit : suits) {
			for(int i=1; i < 14; i++) {
				deck.add(new Card(i, suit));
			}
		}
	}
	
	/*
	 * Shuffles the deck
	 */
	public void shuffle() {
		Collections.shuffle(deck);
	}
	
	/*
	 * Removes the first card in the deck and returns it
	 * @return drawn, the first card in the deck
	 */
	public Card draw() {
		Card drawn = deck.get(0);
		deck.remove(0);
		return drawn;
	}
	
	/*
	 * Adds a given card to the end of the deck
	 */
	public void add(Card card) {
		deck.add(card);
	}
	
	//If a display method or something of the like is added, just display the top card of the deck
}
