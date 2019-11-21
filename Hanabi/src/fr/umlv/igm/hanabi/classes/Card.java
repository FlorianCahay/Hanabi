package fr.umlv.igm.hanabi.classes;

import java.util.Objects;

public class Card {
	private final int value;
	private final Color color;

	public Card(int value, Color color) {
		if (value < 1 || value > 5) {
			throw new IllegalArgumentException("value interval is [1,5]");
		}
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
		StringBuilder str = new StringBuilder();
		str.append("*");
		str.append(color.toString());
		str.append(value);
		str.append("*");
		return str.toString();
	}

	@Override
	public int hashCode() {
		return Objects.hash(color, value);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Card other = (Card) obj;
		return color == other.color && value == other.value;
	}

}
