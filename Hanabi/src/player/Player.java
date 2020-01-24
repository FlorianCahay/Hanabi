package player;

import java.util.Objects;

import cards.Card;
import cards.Deck;
import cards.Hand;
import colors.Color;
import hint.Hint;

/**
 * Represents a player
 * 
 * @author flori
 *
 */
public class Player {
	private final String name;
	private final Hand hand;
	private final Hint hint;

	/**
	 * Constructs player with his name and hand
	 * 
	 * @param name Player name
	 * @param hand Player hand
	 */
	public Player(String name, Hand hand) {
		this.name = Objects.requireNonNull(name);
		this.hand = hand;
		this.hint = new Hint();
	}

	/**
	 * Adds card in player hand from the deck
	 * 
	 * @param deck Game deck
	 */
	public void pickCardInDeck(Deck deck) {
		hand.pickCardInDeck(deck);
	}

	/**
	 * Discard a specific card
	 * 
	 * @param card Discarded card
	 */
	public void discardCard(Card card) {
		hand.discardCard(card);
	}

	/**
	 * Sets the player hint as a color hint
	 * 
	 * @param color Cards color
	 */
	public void setHint(Color color) {
		hint.setHint(color + " cards are in positions " + hand.cardsPositionsByColor(color));
	}

	/**
	 * Sets the player hint as a value hint
	 * 
	 * @param value Cards value
	 */
	public void setHint(int value) {
		hint.setHint(value + " cards are in positions " + hand.cardsPositionsByValue(value));
	}

	/**
	 * Gets the card at index
	 * 
	 * @param index Card index
	 * @return Card at index
	 */
	public Card getCard(int index) {
		return hand.getCard(index);
	}

	/**
	 * Reads the player hint
	 * 
	 * @return Hint string
	 */
	public String readHint() {
		return hint.readHint();
	}

	/**
	 * Gets the hand size
	 * 
	 * @return Hand size
	 */
	public int getHandSize() {
		return hand.getSize();
	}

	/**
	 * Gets the player name
	 * 
	 * @return name
	 */
	public String getName() {
		return name;
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
		return name + " : " + hand;
	}
}
