package fr.umlv.L3.classes.others;

import java.util.LinkedList;
import java.util.Objects;

import fr.umlv.L3.classes.cards.Card;
import fr.umlv.L3.classes.hint.Hint;

/**
 * 
 * Represent a player with a name and a hand of cards.
 *
 */
public class Player {
	private final String name;
	private final LinkedList<Card> hand = new LinkedList<Card>();
	private String hint;

	/**
	 * Constructs a Player with his name, his hand and setting his hint to none.
	 * 
	 * @param name player name
	 * @param deck game deck
	 * @param nbPlayers number of players
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
	 * Add the specified card in player hand from the deck.
	 * 
	 * @param deck game deck
	 */
	public void pickCardInDeck(Deck deck) {
		hand.add(deck.pickCard());
	}

	/**
	 * Get player name.
	 * 
	 * @return player name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Get number of cards in the hand.
	 * @return number of cards
	 */
	public int getHandSize() {
		return hand.size();
	}

	/**
	 * Remove specified card from player hand.
	 * 
	 * @param card card to remove
	 */
	public void discardCard(Card card) {
		if (!hand.remove(card)) {
			throw new IllegalStateException("hand doesn't contain your card");
		}
	}

	/**
	 * Test if the specified card is contained in the player hand.
	 * 
	 * @param card card to test
	 * @return true if the card is contained in player hand, false otherwise
	 */
	public boolean handContains(Card card) {
		return hand.contains(card);
	}

	/**
	 * Set the hint for the player thanks to the specified hint.
	 * 
	 * @param hint hint to set for the player
	 */
	public void setHint(Hint hint) {
		this.hint = hint.giveInfo(hand);
	}

	/**
	 * Get the card at the specified index.
	 * @param index index of one card
	 * @return card at the specified index
	 */
	public Card getCard(int index) {
		return hand.get(index);
	}

	/**
	 * Reset the hint to none and return the corresponding string.
	 * 
	 * @return last hint gave to the player
	 */
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

	/**
	 * Returns a string representation of the player.
	 */
	@Override
	public String toString() {
		return name + " : " + hand.toString();
	}

}
