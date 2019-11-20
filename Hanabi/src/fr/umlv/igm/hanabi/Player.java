package fr.umlv.igm.hanabi;

import java.util.Objects;

public class Player {
	private final Hand hand;

	public Player(Hand hand) {
		this.hand = Objects.requireNonNull(hand);
	}
}
