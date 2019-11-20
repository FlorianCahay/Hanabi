package fr.umlv.igm.hanabi;

public class Hand extends AbstractCardList {
	public Hand(Deck deck, int nbPlayers) {
		if (nbPlayers > 1 && nbPlayers < 4) {
			initialiseDeck(deck, 5);
		} else if (nbPlayers > 3 && nbPlayers < 6) {
			initialiseDeck(deck, 4);
		} else {
			throw new IllegalArgumentException("nbPlayers interval is [2,5])");
		}
	}

	private void initialiseDeck(Deck deck, int nbCards) {
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
