package fr.umlv.L3.classes;

import java.util.LinkedList;
import java.util.Objects;

public class Player {
	private final String name;
	private final LinkedList<Card> hand = new LinkedList<Card>();

	public Player(String name, Deck deck) {
		this.name = Objects.requireNonNull(name);
		for (int i = 0; i < 5; i++) {
			pickCardInDeck(deck);
		}
	}

	public void pickCardInDeck(Deck deck) {
		hand.add(deck.pickCard());
	}

	public String getName() {
		return name;
	}

	public void discardCard(Card c) {
		if (!hand.remove(c)) {
			throw new IllegalStateException("hand doesn't contain your card");
		}
	}

	public boolean handContains(Card card) {
		return hand.contains(card);
	}

	@Override
	public String toString() {
		return name + " : " + hand.toString();
	}

}
