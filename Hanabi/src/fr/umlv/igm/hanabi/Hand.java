package fr.umlv.igm.hanabi;

public class Hand extends AbstractCardList {
	public Hand(Deck deck, int nbCards) {
		for (int i = 0; i < nbCards; i++) {
			pickCardInDeck(deck);
		}
	}

	public void pickCardInDeck(Deck deck) {
		add(deck.pickCard());
	}

	public Card playCard(Card c) {
		remove(c);
		return c;
	}
}
