package fr.umlv.igm.hanabi.classes;

import java.util.Objects;

import fr.umlv.igm.hanabi.classes.cards.Hand;

public class Player {

	private String name;
	private final Hand hand;

	public Player(Hand hand) {
		this.hand = Objects.requireNonNull(hand);
	}

	public String getName() {
		return name;
	}

	public int getSizeHand() {
		return hand.size();
	}

	public void setName(String name) {
		this.name = Objects.requireNonNull(name);
	}

	public Card playCard(int i, Board board) {
		return hand.playCard(i, board);
	}

	@Override
	public String toString() {
		return name + " : " + hand.toString();
	}
}
