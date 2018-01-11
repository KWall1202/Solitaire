package Solitaire;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.JFrame;

public class SolitaireDriver extends Observable {
	private JFrame frame;
	private Deck deck;
	private Hand hand;
	private ArrayList<Foundation> foundations = new ArrayList<>();
	private ArrayList<TableauPile> tableau = new ArrayList<>();
	
	public Deck getDeck() {
		return deck;
	}
	
	public void setDeck(Deck deck) {
		this.deck = deck;
	}
	
	public Hand getHand() {
		return hand;
	}
	
	public void setHand(Hand hand) {
		this.hand = hand;
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	private void createAndShowGUI() {
		frame = new JFrame("Solitaire");
		Container content = frame.getContentPane(); 
		content.setLayout(new BorderLayout(1,1));
		content.setBackground(Color.DARK_GRAY);
		frame.setSize(1200,600);
		frame.setLocationRelativeTo(null);
		setChanged();
		notifyObservers();
		frame.setVisible(true);
	}
	
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SolitaireDriver driver = new SolitaireDriver();
				Deck deck = new Deck();
				Hand hand = new Hand();
				driver.setHand(hand);
				driver.setDeck(deck);
				driver.createAndShowGUI();
			}
		});
	}
}
