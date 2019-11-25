package fr.umlv.L3.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Board extends Box {

	private final ArrayList<Card> discardedCards = new ArrayList<>();
	private final HashMap<Color, Integer> fireworks = new HashMap<>();

	public Board() {
		super(0, 3);
	}

	public void addDiscardedCard(Card card) {
		discardedCards.add(card);
	}

	public void addCard(Card card) {
		if (isAddable(card)) {
			fireworks.computeIfPresent(card.getColor(), (k, v) -> v + 1);
			fireworks.computeIfAbsent(card.getColor(), (k) -> 1);
			return;
		}
		throw new IllegalStateException("can't add card to the board as it doesn't respect rules");
	}

	public boolean isAddable(Card card) {
		if (card.getValue() == 1) { // add a 1
			if (fireworks.containsKey(card.getColor())) {
				return false;
			}
			return true;
		}
		if (!fireworks.containsKey(card.getColor()) || fireworks.get(card.getColor()) != card.getValue() - 1) { // add
																												// others
			return false;
		}
		return true;
	}

	public boolean gameOver(Deck deck) {
		if (deck.isEmpty() || getNumberRedToken() == 0 || getScore() == 25) {
			return true;
		}
		return false;
	}

	@Override
	public String typeOfBox() {
		return "Board";
	}

	public int getScore() {
		return fireworks.entrySet().stream().mapToInt(k -> k.getValue()).sum();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Color color : fireworks.keySet()) {
			str.append(color);
			str.append(" firework :");
			str.append(fireworks.get(color));
			str.append("\n");
		}
		str.append(super.toString());
		return str.toString();
	}

}
