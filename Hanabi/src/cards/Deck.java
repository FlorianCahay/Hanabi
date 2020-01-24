package cards;

import java.util.Collections;
import java.util.Stack;

import colors.Color;

/**
 * Represents a deck
 * 
 * @author Cahay-Durand
 *
 */
public class Deck {

	private final Stack<Card> deck = new Stack<>();

	/**
	 * Constructs a deck with specifics cards
	 */
	public Deck() {
		initializeDeck();
	}

	/**
	 * Initializes deck and shuffle it
	 */
	private void initializeDeck() {
		for (Color color : Color.values()) {
			for (int i = 0; i < 10; i++) {
				if (i < 3) {
					deck.push(new Card(1, color));
				} else if (i < 5) {
					deck.push(new Card(2, color));
				} else if (i < 7) {
					deck.push(new Card(3, color));
				} else if (i < 9) {
					deck.push(new Card(4, color));
				} else {
					deck.push(new Card(5, color));
				}
			}
		}
		Collections.shuffle(deck);
	}

	/**
	 * Know if the deck is empty or not
	 * 
	 * @return true if deck is empty, false otherwise
	 */
	public boolean isEmpty() {
		return deck.isEmpty();
	}

	/**
	 * Gets the deck size
	 * 
	 * @return deck size
	 */
	public int getSize() {
		return deck.size();
	}

	/**
	 * Picks the top card out of the deck
	 * 
	 * @return Pop card
	 */
	public Card pickCard() {
		return deck.pop();
	}

}
