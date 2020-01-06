package player;

import java.util.Objects;

import cards.Card;
import cards.Deck;
import cards.Hand;
import colors.Color;
import hint.Hint;

public class Player {
	private final String name;
	private final Hand hand;
	private final Hint hint;

	public Player(String name, Hand hand) {
		this.name = Objects.requireNonNull(name);
		this.hand = hand;
		this.hint = new Hint();
	}

	public void pickCardInDeck(Deck deck) {
		hand.pickCardInDeck(deck);
	}

	public void discardCard(Card card) {
		hand.discardCard(card);
	}

	public void setHint(Color color) {
		hint.setHint(color + " cards are in positions " + hand.cardsPositionsByColor(color));
	}

	public void setHint(int value) {
		hint.setHint(value + " cards are in positions " + hand.cardsPositionsByValue(value));
	}

	public Card getCard(int index) {
		return hand.getCard(index);
	}

	public String readHint() {
		return hint.readHint();
	}

	public int getHandSize() {
		return hand.getSize();
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Player)) {
			return false;
		}
		Player other = (Player) obj;
		return Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return name + " : " + hand;
	}
}
