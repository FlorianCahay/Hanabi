package fr.umlv.igm.hanabi;

import java.util.Objects;

public class Player {

	private String name;
	private final Hand hand;

	public Player(Hand hand) {
		this.hand = Objects.requireNonNull(hand);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = Objects.requireNonNull(name);
	}

	@Override
	public String toString() {
		return name + " : " + hand.toString();
	}
}
