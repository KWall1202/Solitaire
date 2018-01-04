package Solitaire;

/*
 * A pile to be included in the tableau in a solitaire game
 * @author Kevin Wallace
 * @date January 3rd, 2018
 */
public class TableauPile {
	private TableauPileNode start = null;
	
	public void add(Card card) {
		add(new TableauPileNode(card));
	}
	
	/*
	 * Adds a new node to the end of the list
	 */
	public void add(TableauPileNode node) {
		if(start == null) {
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
}
