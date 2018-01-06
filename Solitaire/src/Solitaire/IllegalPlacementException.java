package Solitaire;

/*
 * An exception to occur when an attempt is made to place a card somewhere illegal during a game of Solitaire
 * @author Kevin Wallace
 */
public class IllegalPlacementException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6735892877193183948L;

	public IllegalPlacementException(String message) {
		super(message);
	}
}
