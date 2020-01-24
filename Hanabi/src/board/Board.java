package board;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

import cards.Card;
import cards.Deck;
import colors.Color;
import tokens.Box;
import tokens.Token;

/**
 * Represents game board which contains discarded Cards, tokens and fireworks.
 * 
 * @author Cahay-Durand
 *
 */
public class Board extends Box {

	private final Deque<Card> discardedCards = new ArrayDeque<>();
	private final HashMap<Color, Integer> fireworks = new HashMap<>();

	/**
	 * Constructs a Board with Token box fill with red tokens
	 */
	public Board() {
		super(Color.RED);
	}

	/**
	 * Adds card on top of the discardedCards
	 * 
	 * @param card Card to discard
	 */
	public void addDiscardedCard(Card card) {
		discardedCards.push(card);
	}

	/**
	 * Adds card to the fireworks
	 * 
	 * @param card Card to add
	 */
	public void addCard(Card card) {
		fireworks.computeIfPresent(card.getColor(), (k, v) -> v + 1);
		fireworks.computeIfAbsent(card.getColor(), (k) -> 1);
	}

	/**
	 * Checks if the card can be added to the fireworks
	 * 
	 * @param card Card to add
	 * @return true if the card can be added, false otherwise
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
	 * Checks if the game is over
	 * 
	 * @param deck Game deck
	 * @return true if the game is over, false otherwise
	 */
	public boolean gameOver(Deck deck) {
		if (deck.isEmpty() || getNumberToken(new Token(Color.RED)) == 0 || getScore() == 25) {
			return true;
		}
		return false;
	}

	/**
	 * Gets a score based on the fireworks
	 * 
	 * @return score
	 */
	public int getScore() {
		return fireworks.entrySet().stream().mapToInt(k -> k.getValue()).sum();
	}

	/**
	 * Gets the fireworks
	 * 
	 * @return fireworks
	 */
	public HashMap<Color, Integer> getFireworks() {
		return fireworks;
	}

	/**
	 * Gets last discarded card
	 * 
	 * @return the last discard card
	 */
	public Card getLastDiscardedCard() {
		return discardedCards.peek();
	}

	/**
	 * Gets size of the discardedCards Deque
	 * 
	 * @return discardedCards size
	 */
	public int getDiscardedCardSize() {
		return discardedCards.size();
	}

	@Override
	public String typeOfBox() {
		return "Board";
	}

	@Override
	public String toString() {
		var str = new StringBuilder();
		str.append(super.toString()).append("\n").append("last discarded card : ");
		if (!discardedCards.isEmpty()) {
			str.append(discardedCards.peek());
		} else {
			str.append("None");
		}
		for (Color color : fireworks.keySet()) {
			str.append("\n").append(color).append(" firework : ").append(fireworks.get(color));
		}
		return str.toString();
	}

}
