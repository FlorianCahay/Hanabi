package fr.umlv.L3.classes;

import java.util.Objects;

public class Card {
	private final int value;
	private final Color color;

	public Card(int value, Color color) {
		this.value = value;
		this.color = Objects.requireNonNull(color);
	}

	public Color getColor() {
		return color;
	}

	public int getValue() {
		return value;
	}

	@Override
	public String toString() {
		return "**" + value + color + "**";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Card)) {
			return false;
		}
		Card other = (Card) obj;
		return color == other.color && value == other.value;
	}

}
