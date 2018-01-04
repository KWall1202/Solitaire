package Solitaire;

/*
 * A card class to be used in a solitaire game
 * Aces have value 1
 * @Author Kevin Wallace
 * @Date January 3rd, 2018
 */
public class Card {
	private int number;
	private String name;
	private String suit;
	private String color = "black";
	private boolean faceUp = false;
	
	/*
	 * Creates a card
	 * Throws an IllegalArgumentException if an attempt is made to create a card with a value less than 1 or greater than 13
	 * Throws an IllegalArgumentException if an attempt is made to create a card with a suit other than hearts, clubs, spades, or diamonds
	 * @param number, the number on the card
	 * @param suit, the suit of the card
	 */
	public Card(int number, String suit) {
		if(number < 1 || number > 13) throw new IllegalArgumentException("Card cannot have value less than 1 or greater than 13");
		if(!suit.equals("clubs") && !suit.equals("diamonds") && !suit.equals("hearts") && !suit.equals("spades")) throw new IllegalArgumentException("Card must have a legal suit");
		this.number = number;
		this.suit = suit;
		if(suit.equals("diamonds") || suit.equals("hearts")) this.color = "red";
		this.name = makeName();
	}
	
	/*
	 * Creates an easy to read name for the card based on the fields after the constructor(Ex: Ace of clubs, 3 of hearts, etc.)
	 * Only to be called by the constructor, else field values may not be set yet
	 * @return a string representation of the card
	 */
	private String makeName() {
		String title = "" + number;
		if(number == 11) title = "Jack";
		if(number == 12) title = "Queen";
		if(number == 13) title = "King";
		if(number == 1) title = "Ace";
		return title + " of " + suit;
	}
	
	/*
	 * Returns the number value of the card (2-14)
	 * @return number, an integer corresponding to the card's value
	 */
	public int getNumber() {
		return number;
	}
	
	/*
	 * Returns the suit of the card
	 * @return suit, a string representing the suit of the card
	 */
	public String getSuit() {
		return suit;
	}
	
	/*
	 * Returns the color of the card
	 * @return color, a string representing the color of the card
	 */
	public String getColor() {
		return color;
	}
	
	/*
	 * Returns the name of the card (Ex: King of diamonds, 3 of spades, etc.)
	 * @return name, a string representation of the card
	 */
	public String getName() {
		return name;
	}
	
	/*
	 * Returns whether or not the card is face-up
	 * @return faceUp, the boolean corresponding to the face-upness of the card
	 */
	public boolean isFaceUp() {
		return faceUp;
	}
	
	/*
	 * Sets the face-upness of the card to a specific value
	 * @param up, the boolean value representing the new face-upness of the card
	 */
	public void setFaceUp(boolean up) {
		faceUp = up;
	}
	
	/*
	 * Flips the card by changing the boolean faceUp to its opposite
	 */
	public void flip() {
		faceUp = !faceUp;
	}
	
	/*
	 * Checks if a card can legally be placed under a given card under the rules of solitaire
	 * @param arg0, the card the will possibly go above this card
	 * @return whether or not this card can go below the given card
	 */
	public boolean canGoUnder(Card arg0) {
		if(arg0.getNumber() - number != 1) return false;
		if(arg0.getColor() == color) return false;
		return true;
	}
}
