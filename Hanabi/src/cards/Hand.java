package cards;

import java.util.ArrayList;
import java.util.LinkedList;

import colors.Color;

public class Hand {
	private final LinkedList<Card> hand = new LinkedList<Card>();

	public Hand(Deck deck, int numberCards) {
		for (int i = 0; i < numberCards; i++) {
			pickCardInDeck(deck);
		}
	}

	public void pickCardInDeck(Deck deck) {
		hand.add(deck.pickCard());
	}

	public int getSize() {
		return hand.size();
	}

	public void discardCard(Card card) {
		hand.remove(card);
	}

	public boolean handContains(Card card) {
		return hand.contains(card);
	}

	public Card getCard(int index) {
		return hand.get(index);
	}

	public String cardsPositionsByColor(Color color) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getColor().equals(color)) {
				list.add(i+1);
			}
		}
		return list.toString();
	}

	public String cardsPositionsByValue(int value) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < hand.size(); i++) {
			if (hand.get(i).getValue() == value) {
				list.add(i+1);
			}
		}
		return list.toString();
	}

	@Override
	public String toString() {
		return hand.toString();
	}
}
