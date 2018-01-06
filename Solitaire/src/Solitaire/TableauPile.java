package Solitaire;

/*
 * A pile to be included in the tableau in a solitaire game
 * @author Kevin Wallace
 */
public class TableauPile {
	private boolean dealing = true;
	private TableauPileNode start = null;
	
	/*
	 * Adds a new node to the end of the list, using the card as the card for the node to add
	 * throws IllegalPlacementException if the pile is empty, the game has started and an attempt is made to add a card that isn't a king
	 * @param card, a Card to be placed in a node at the end of the pile
	 */
	public void add(Card card) throws IllegalPlacementException {
		add(new TableauPileNode(card));
	}
	
	/*
	 * Adds a new node to the end of the list
	 * throws IllegalPlacementException if the pile is empty, the game has started and an attempt is made to add a card that isn't a king
	 * @param node, a node to be placed at the end of the pile
	 */
	public void add(TableauPileNode node) throws IllegalPlacementException {
		if(start == null) {
			if(!dealing && node.getCard().getNumber() != 13) throw new IllegalPlacementException("Can only place a King on an empty node");
			start = node;
		} else {
			TableauPileNode temp = start;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.setNext(node);
			node.setBefore(temp);
		}
	}
	
	/*
	 * Flips the last card in the pile
	 */
	public void flipLast() {
		if(start != null) {
			TableauPileNode temp = start;
			while(temp.getNext() != null) {
				temp = temp.getNext();
			}
			temp.getCard().flip();
		}
	}
	
	/*
	 * Sets the pile to be in the dealing phase (true) or the play phase (false)
	 * @param isDealing, false if not dealing, true if dealing
	 */
	public void setDealing(boolean isDealing) {
		dealing = isDealing;
	}
}
