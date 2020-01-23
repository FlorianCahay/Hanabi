package board;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

import cards.Card;
import cards.Deck;
import colors.Color;
import tokens.Box;
import tokens.Token;

public class Board extends Box {
	private final Deque<Card> discardedCards = new ArrayDeque<>();
	private final HashMap<Color, Integer> fireworks = new HashMap<>();

	public Board() {
		super(Color.RED);
	}

	public void addDiscardedCard(Card card) {
		discardedCards.push(card);
	}

	public void addCard(Card card) {
		if (!isAddable(card)) {
			throw new IllegalStateException("can't add card to the board as it doesn't respect rules");
		}
		fireworks.computeIfPresent(card.getColor(), (k, v) -> v + 1);
		fireworks.computeIfAbsent(card.getColor(), (k) -> 1);
	}

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

	public boolean gameOver(Deck deck) {
		if (deck.isEmpty() || getNumberToken(new Token(Color.RED)) == 0 || getScore() == 25) {
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

	public HashMap<Color, Integer> getFireworks() {
		return fireworks;
	}

	public Card getLastDiscardedCard() {
		return discardedCards.peek();
	}

	public int getDiscardedCardSize() {
		return discardedCards.size();
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
