package fr.umlv.L3.classes.others;

import java.util.LinkedList;
import java.util.Objects;

import fr.umlv.L3.classes.elements.Card;
import fr.umlv.L3.classes.hint.Hint;

/**
 * 
 * Represent a player with a name and a hand of cards
 *
 */
public class Player {
	private final String name;
	private final LinkedList<Card> hand = new LinkedList<Card>();
	private String hint;

	/**
	 * Constructor initializing a Player with his name and picking five cards to
	 * create his hand
	 * 
	 * @param name Player name
	 * @param deck Game deck
	 */
	public Player(String name, Deck deck, int nbPlayers) {
		this.name = Objects.requireNonNull(name);
		var nbCards = 5;
		if (nbPlayers > 3) {
			nbCards = 4;
		}
		for (int i = 0; i < nbCards; i++) {
			pickCardInDeck(deck);
		}
		hint = "none";
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

	public void setHint(Hint hint) {
		this.hint = hint.giveInfo(hand);
	}

	public String readhint() {
		String hintString = hint;
		hint = "none";
		return "Last hint someone gave you : " + hintString;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Player)) {
			return false;
		}
		Player other = (Player) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return name + " : " + hand.toString();
	}

}
