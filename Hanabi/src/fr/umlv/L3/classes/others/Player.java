package fr.umlv.L3.classes.others;

import java.util.LinkedList;
import java.util.Objects;

import fr.umlv.L3.classes.elements.Card;

/**
 * 
 * Represent a player with a name and a hand of cards
 *
 */
public class Player {
	private final String name;
	private final LinkedList<Card> hand = new LinkedList<Card>();

	/**
	 * Constructor initializing a Player with his name and picking five cards to
	 * create his hand
	 * 
	 * @param name Player name
	 * @param deck Game deck
	 */
	public Player(String name, Deck deck) {
		this.name = Objects.requireNonNull(name);
		for (int i = 0; i < 5; i++) {
			pickCardInDeck(deck);
		}
	}

	/**
	 * add a card in player hand from the deck
	 * 
	 * @param deck Game deck
	 */
	public void pickCardInDeck(Deck deck) {
		hand.add(deck.pickCard());
	}

	/**
	 * get player name
	 * 
	 * @return player name
	 */
	public String getName() {
		return name;
	}

	/**
	 * remove card from player hand
	 * 
	 * @param card Card to remove
	 */
	public void discardCard(Card card) {
		if (!hand.remove(card)) {
			throw new IllegalStateException("hand doesn't contain your card");
		}
	}

	/**
	 * Test if the card is contained in the player hand
	 * 
	 * @param card Card to test
	 * @return True if card is contained in player hand, False otherwise
	 */
	public boolean handContains(Card card) {
		return hand.contains(card);
	}

	@Override
	public String toString() {
		return name + " : " + hand.toString();
	}

}
