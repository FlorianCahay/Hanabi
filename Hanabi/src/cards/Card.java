package cards;

import java.util.Objects;

import colors.Color;

public class Card {
	private static final int lowestValue = 1;
	private static final int highestValue = 5;
	private final int value;
	private final Color color;

	public Card(int value, Color color) {
		if (value < lowestValue || value > highestValue) {
			throw new IllegalArgumentException(
					"card value must be include in [" + lowestValue + "," + highestValue + "]");
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
		return "*" + value + color + "*";
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
