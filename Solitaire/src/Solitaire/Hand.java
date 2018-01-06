package Solitaire;

import java.util.ArrayList;

/*
 * A hand class to contain the maximum three cards in a player's hand in a game of solitaire
 * @author Kevin Wallace
 */
public class Hand {
	private ArrayList<Card> hand = new ArrayList<>();
	
	/*
	 * Draws the top card from the deck and adds it to the hand
	 * Will only draw if hand is empty (use clear() to empty the hand before drawing)
	 * @param deck, the deck to draw from
	 * @param num, the number of cards to draw
	 */
	public void draw(Deck deck, int num) {
		if(hand.size() > 0) throw new UnsupportedOperationException("Cannot draw into a non-empty hand");
		for(int i=0; i < num; i++) {
			Card card = deck.draw();
			card.setFaceUp(true);
			hand.add(card);
		}
	}
	
	/*
	 * Moves all cards in hand into a deck and clears the hand
	 * @param discard, the deck the cards will be moved to
	 */
	public void clear(Deck discard) {
		for(int i=0; i < hand.size(); i++) {
			discard.add(hand.get(i));
		}
		hand = new ArrayList<>();
	}
	
	
}
