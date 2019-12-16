package fr.umlv.L3.classes.containers;

import java.util.HashMap;
import java.util.Stack;

import fr.umlv.L3.classes.elements.Card;
import fr.umlv.L3.classes.elements.Color;
import fr.umlv.L3.classes.others.Deck;

/**
 * Represent board game with a token Box, fireworks and the discarded cards.
 */
public class Board extends Box {
	private final Stack<Card> discardedCards = new Stack<>();
	private final HashMap<Color, Integer> fireworks = new HashMap<>();

	/**
	 * Constructs a board with 0 blue token and 3 red tokens.
	 */
	public Board() {
		super(0, 3);
	}

	/**
	 * Add card to discarded cards.
	 * 
	 * @param card Card to add
	 */
	public void addDiscardedCard(Card card) {
		discardedCards.push(card);
	}

	/**
	 * Add the specified card to fireworks if it is possible.
	 * 
	 * @param card card to add
	 * @throws IllegalArgumentException if it's impossible to add the card
	 */
	public void addCard(Card card) {
		if (!isAddable(card)) {
			throw new IllegalStateException("can't add card to the board as it doesn't respect rules");
		}
		fireworks.computeIfPresent(card.getColor(), (k, v) -> v + 1);
		fireworks.computeIfAbsent(card.getColor(), (k) -> 1);
	}

	/**
	 * Test if it's possible to add the  specified card to fireworks.
	 * 
	 * @param card card to test
	 * @return true it's possible to add the card, false otherwise
	 */
	public boolean isAddable(Card card) {
		if (card.getValue() == 1) { // add a 1
			if (fireworks.containsKey(card.getColor())) {
				return false;
			}
			return true;
		}
		if (!fireworks.containsKey(card.getColor())
				|| fireworks.get(card.getColor()) != card.getValue() - 1) { /* add other */
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

	/**
	 * Returns a string representation of the contents of the board.
	 */
	@Override
	public String toString() {
		var str = new StringBuilder();

		str.append(super.toString());
		str.append("\n");

		str.append("last discarded card : ");
		if (!discardedCards.isEmpty()) {
			str.append(discardedCards.peek());

		}
		for (Color color : fireworks.keySet()) {
			str.append("\n");
			str.append(color);
			str.append(" firework : ");
			str.append(fireworks.get(color));
		}

		return str.toString();
	}

}
