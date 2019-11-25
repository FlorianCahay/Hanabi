package fr.umlv.L3.classes;

import java.util.LinkedList;
import java.util.Objects;

public class Player {
	private final String name;
	private final LinkedList<Card> hand = new LinkedList<Card>();

	public Player(String name) {
		this.name = Objects.requireNonNull(name);
	}

	public void pickCardInDeck(Deck deck) {
		hand.add(deck.pickCard());
	}

	public void discardCard(Card c) {
		if (!hand.remove(c)) {
			throw new IllegalStateException("hand doesn't contain your card");
		}
	}
	
	@Override
	public String toString() {
		return name + " : " + hand.toString();
	}

}
