package fr.umlv.igm.hanabi;

import java.util.ArrayList;

public abstract class AbstractCardList implements CardList {
	private final ArrayList<Card> deck = new ArrayList<>();

	public void add(Card c) {
		deck.add(c);
	}

	public Card remove(int i) {
		return deck.remove(i);
	}

	public void remove(Card c) {
		deck.remove(c);
	}

	public int size() {
		return deck.size();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Card card : deck) {
			str.append(card);
			str.append(" ");
		}
		return str.toString();
	}
}
