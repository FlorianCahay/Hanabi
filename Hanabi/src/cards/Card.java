package cards;

import java.util.Objects;

import colors.Color;

/**
 * Represents a card with a value and a color
 * 
 * @author Cahay-Durand
 *
 */
public class Card {
	private static final int lowestValue = 1;
	private static final int highestValue = 5;
	private final int value;
	private final Color color;

	/**
	 * Constructs a card with a value and a color
	 * 
	 * @param value Card value
	 * @param color Card color
	 * @throws IllegalArgumentException If value is not include in lowestValue and
	 *                                  highestValue
	 */
	public Card(int value, Color color) {
		if (value < lowestValue || value > highestValue) {
			throw new IllegalArgumentException(
					"card value must be include in [" + lowestValue + "," + highestValue + "]");
		}
		this.value = value;
		this.color = Objects.requireNonNull(color);
	}

	/**
	 * Gets the color
	 * 
	 * @return color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * Gets the value
	 * 
	 * @return value
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Gets the highest possible value
	 * 
	 * @return highestValue
	 */
	public static int getHighestvalue() {
		return highestValue;
	}

	/**
	 * Gets the lowest possible value
	 * 
	 * @return lowestValue
	 */
	public static int getLowestvalue() {
		return lowestValue;
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
