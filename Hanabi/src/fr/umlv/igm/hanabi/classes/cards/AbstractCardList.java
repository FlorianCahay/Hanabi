package fr.umlv.igm.hanabi.classes.cards;

import java.util.ArrayList;

import fr.umlv.igm.hanabi.classes.Card;

public class AbstractCardList implements CardList {
	private final ArrayList<Card> deck = new ArrayList<>();

	public void add(Card c) {
		deck.add(c);
	}

	public Card remove(int i) {
		return deck.remove(i);
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
