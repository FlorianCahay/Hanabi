package fr.umlv.L3.classes.containers;

import java.util.ArrayList;
import java.util.HashMap;

import fr.umlv.L3.classes.elements.Card;
import fr.umlv.L3.classes.elements.Color;
import fr.umlv.L3.classes.others.Deck;

/**
 * Represent board game with a token Box, a HashMap for fireworks and an
 * ArrayList for the discarded cards
 */
public class Board extends Box {
	private final ArrayList<Card> discardedCards = new ArrayList<>();
	private final HashMap<Color, Integer> fireworks = new HashMap<>();

	/**
	 * Constructor initializing board with 0 blue token and 3 red tokens
	 */
	public Board() {
		super(0, 3);
	}

	/**
	 * Add card to discarded cards
	 * 
	 * @param card Card to add
	 */
	public void addDiscardedCard(Card card) {
		discardedCards.add(card);
	}

	/**
	 * Add card to fireworks if it is addable
	 * 
	 * @param card Card to add
	 * @throws IllegalArgumentException if card is not addable
	 */
	public void addCard(Card card) {
		if (!isAddable(card)) {
			throw new IllegalStateException("can't add card to the board as it doesn't respect rules");
		}
		fireworks.computeIfPresent(card.getColor(), (k, v) -> v + 1);
		fireworks.computeIfAbsent(card.getColor(), (k) -> 1);
	}

	/**
	 * Test if a card is addable to fireworks
	 * 
	 * @param card Card to test
	 * @return True if the card is addable, False otherwise
	 */
	public boolean isAddable(Card card) {
		if (card.getValue() == 1) { // add a 1
			if (fireworks.containsKey(card.getColor())) {
				return false;
			}
			return true;
		}
		if (!fireworks.containsKey(card.getColor()) || fireworks.get(card.getColor()) != card.getValue() - 1) { // add
																												// //
																												// others
			return false;
		}
		return true;
	}

	/**
	 * Test if the game is over.
	 * 
	 * @param deck Game deck.
	 * @return True if the game should be over, False otherwise
	 */
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

	/**
	 * Sum over fireworks values to get a score
	 * 
	 * @return score calculated on fireworks elements
	 */
	public int getScore() {
		return fireworks.entrySet().stream().mapToInt(k -> k.getValue()).sum();
	}

	@Override
	public String toString() {
		var str = new StringBuilder();

		str.append(super.toString());
		str.append("\n");

		str.append("discarded cards : ");
		str.append(discardedCards);
		str.append("\n");

		for (Color color : fireworks.keySet()) {
			str.append(color);
			str.append(" firework : ");
			str.append(fireworks.get(color));
			str.append("\n");
		}

		return str.toString();
	}

}
