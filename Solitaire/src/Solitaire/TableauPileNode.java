package Solitaire;

/*
 * A node in a linked list to create the piles in the tableau
 * @author Kevin Wallace
 */
public class TableauPileNode {
	private TableauPileNode next = null;
	private TableauPileNode before = null;
	private Card card;
	
	public TableauPileNode(Card card) {
		this.card = card;
	}
	
	public TableauPileNode(TableauPileNode before, Card card) {
		super();
		this.before = before;
		this.card = card;
	}
	
	/*
	 * Returns the card this node contains
	 * @return card, the card this node contains
	 */
	public Card getCard() {
		return card;
	}
	
	/*
	 * Sets the next node in the pile
	 * @param nextNode, the node to be set as next for this node
	 */
	public void setNext(TableauPileNode nextNode) {
		next = nextNode;
	}
	
	/*
	 * Returns the next node in the pile
	 * @return next, the next node in the pile, is null if this is the last node in the pile
	 */
	public TableauPileNode getNext() {
		return next;
	}
	
	/*
	 * Sets the node to go before this one
	 * @param beforeNode, the node to be set as before this node
	 */
	public void setBefore(TableauPileNode beforeNode) {
		before = beforeNode;
	}
	
	/*
	 * Returns the node that comes before this one
	 * @return before, the node before this one, is null if this is the first node in the pile
	 */
	public TableauPileNode getBefore() {
		return before;
	}
	
	/*
	 * Detaches node and all following nodes from linked list
	 */
	public void detach() {
		before.setNext(null);
		before = null;
	}
	
	/*
	 * Attaches node and all following nodes to a given node if this node can be placed on the given node under the rules of solitaire
	 * Throws IllegalPlacementException if the node this node is trying to attach to already has a card after it
	 * @param node, the node this card is going to attach to
	 */
	public void attach(TableauPileNode node) throws IllegalPlacementException {
		if(!card.canGoUnder(node.getCard())) throw new IllegalPlacementException("Adjacent ends of two piles must be neighboring numbers in descending order and of opposite color in order to attach");
		if(node.getNext() != null) throw new IllegalPlacementException("Cannot attach a pile to the middle of another pile");
		node.setNext(this);
		before = node;
	}
}
