package Solitaire;

import java.util.ArrayList;

/*
 * A foundation class to be used in a solitaire game
 * @Author Kevin Wallace
 */
public class Foundation {
	private ArrayList<Card> foundation = new ArrayList<>();
	
	/*
	 * Adds a card to the foundation
	 */
	public void add(Card card) throws IllegalPlacementException {
		if(foundation.size() == 0 && card.getNumber() != 1) {
			throw new IllegalPlacementException("The first card on the foundation must be an Ace");
		} else if(foundation.size() > 0) {
			if(!card.getSuit().equals(foundation.get(0).getSuit()) || card.getNumber() - 1 != foundation.get(foundation.size() - 1).getNumber() ) {
				throw new IllegalPlacementException("Only the card with with the same suit as and values one more than the top card of the foundation may be added to the foundation.");
			}
		}
		foundation.add(card);
	}
}
