package fr.umlv.igm.hanabi.classes.cards;

import fr.umlv.igm.hanabi.classes.Board;
import fr.umlv.igm.hanabi.classes.Card;

public class Hand extends AbstractCardList {
	public Hand(Deck deck, int nbCards) {
		for (int i = 0; i < nbCards; i++) {
			pickCardInDeck(deck);
		}
	}

	public void pickCardInDeck(Deck deck) {
		add(deck.pickCard());
	}

	public Card playCard(int i, Board board) {
		Card c = remove(i);
		board.playCard(c);
		return c;
	}

	public void discardCard(int i) {
		remove(i);
	}

}
