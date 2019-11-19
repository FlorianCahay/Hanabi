package fr.umlv.igm.hanabi;

import java.util.ArrayList;

public class Deck {
	private final ArrayList<Card> deck = new ArrayList<>();

	public Deck() {
		for (Color color : Color.values()) {
			for (int i = 0; i < 10; i++) {
				if (i < 3) {
					deck.add(new Card(1, color));
				} else if (i < 5) {
					deck.add(new Card(2, color));
				} else if (i < 7) {
					deck.add(new Card(3, color));
				} else if (i < 9) {
					deck.add(new Card(4, color));
				} else {
					deck.add(new Card(5, color));
				}
			}
		}
	}

	@Override
	public String toString() {
		return deck.toString();
	}
}
