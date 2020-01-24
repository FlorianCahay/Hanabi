package cards;

import java.util.ArrayList;
import java.util.LinkedList;

import colors.Color;

/**
 * Represents a player hand
 * 
 * @author Cahay-Durand
 *
 */
public class Hand {
	private final LinkedList<Card> hand = new LinkedList<Card>();

	/**
	 * Constructs hand with a certain number of deck cards
	 * 
	 * @param deck        Game deck
	 * @param numberCards Hand size
	 */
	public Hand(Deck deck, int numberCards) {
		for (int i = 0; i < numberCards; i++) {
			pickCardInDeck(deck);
		}
	}

	/**
	 * Adds a card to the hand by picking in the deck
	 * 
	 * @param deck Game deck
	 */
	public void pickCardInDeck(Deck deck) {
		hand.add(deck.pickCard());
	}

	/**
	 * Gets hand size
	 * 
	 * @return Hand size
	 */
	public int getSize() {
		return hand.size();
	}

	/**
	 * Removes a card from the hand
	 * 
	 * @param card Card to remove
	 */
	public void discardCard(Card card) {
		hand.remove(card);
	}

	/**
	 * Know if the hand contains a card
	 * 
	 * @param card Card to test
	 * @return true if the card is contained, false otherwise
	 */
	public boolean handContains(Card card) {
		return hand.contains(card);
	}

	/**
	 * Gets a card by its index
	 * 
	 * @param index Card index
	 * @return Card in index position
	 */
	public Card getCard(int index) {
		return hand.get(index);
	}

	/**
	 * Gets a String representing the positions of the card having the specific
	 * color
	 * 
	 * @param color Cards color
	 * @return String list of the positions
	 */
	public String cardsPositionsByColor(Color color) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getColor().equals(color)) {
				list.add(i + 1);
			}
		}
		return list.toString();
	}

	/**
	 * Gets a String representing the positions of the card having the specific
	 * value
	 * 
	 * @param value Cards value
	 * @return String list of the positions
	 */
	public String cardsPositionsByValue(int value) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getValue() == value) {
				list.add(i + 1);
			}
		}
		return list.toString();
	}

	@Override
	public String toString() {
		return hand.toString();
	}
}
