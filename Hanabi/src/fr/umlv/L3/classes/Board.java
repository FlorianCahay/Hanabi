package fr.umlv.L3.classes;

import java.util.ArrayList;
import java.util.HashMap;

public class Board extends Box {

	private final ArrayList<Card> discardedCards = new ArrayList<>();
	private final HashMap<Color, Integer> fireworks = new HashMap<>();

	public Board(int blueToken, int redToken) {
		super(blueToken, redToken);
	}

	public void addDiscardedCard(Card card) {
		discardedCards.add(card);
	}

	public void addCard(Card card) {
		if (isAddable(card)) {
			fireworks.computeIfAbsent(card.getColor(), (k) -> 1);
			fireworks.computeIfPresent(card.getColor(), (k, v) -> v + 1);
		}
		throw new IllegalStateException("can't add card to the board as it doesn't respect rules");
	}

	public boolean isAddable(Card card) {
		if (card.getValue() == 1) { // add a 1
			if (fireworks.containsKey(card.getColor())) {
				return false;
			}
		}
		if (fireworks.get(card.getColor()) != card.getValue() - 1) { // add others
			return false;
		}
		return true;
	}

	public int getScore() {
		return fireworks.entrySet().stream().mapToInt(k -> k.getValue()).sum();
	}

	@Override
	public String toString() {
		return super.toString() + "\nBoard cards : " + fireworks;
	}

}
