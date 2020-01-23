package cards;

import java.util.Collections;
import java.util.Stack;

import colors.Color;

public class Deck {
	
	private final Stack<Card> deck = new Stack<>();

	public Deck() {
		initializeDeck();
	}

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

	public boolean isEmpty() {
		return deck.isEmpty();
	}

	public int getSize() {
		return deck.size();
	}

	public Card pickCard() {
		return deck.pop();
	}

}
