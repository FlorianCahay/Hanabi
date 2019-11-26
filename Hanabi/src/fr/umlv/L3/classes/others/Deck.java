package fr.umlv.L3.classes.others;

import java.util.Collections;
import java.util.Stack;

import fr.umlv.L3.classes.elements.Card;
import fr.umlv.L3.classes.elements.Color;

/**
 * 
 * Represent a stack of card
 *
 */
public class Deck {
	private final Stack<Card> deck = new Stack<>();

	/**
	 * Constructor initializing deck with 50 cards ((3x1,2x2,2x3,2x4,1x5) for each
	 * color) and shuffle it
	 */
	public Deck() {
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
	 * Test if the deck is empty
	 * 
	 * @return True if the deck is empty, False otherwise
	 */
	public boolean isEmpty() {
		return deck.isEmpty();
	}

	/**
	 * Get deck size
	 * 
	 * @return deck size
	 */
	public int getSize() {
		return deck.size();
	}

	/**
	 * pick a card in the deck and return it
	 * 
	 * @return card pop from the deck
	 */
	public Card pickCard() {
		return deck.pop();
	}

}
