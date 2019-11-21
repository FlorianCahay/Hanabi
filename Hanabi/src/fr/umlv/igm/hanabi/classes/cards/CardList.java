package fr.umlv.igm.hanabi.classes.cards;

import fr.umlv.igm.hanabi.classes.Card;

public interface CardList {
	public void add(Card c);

	public Card remove(int i);

	public int size();
}
