package fr.umlv.L3.classes.elements;

import java.util.Objects;

/**
 * 
 * Represent a card with a value and a color
 *
 */
public class Card {
	private final int value;
	private final Color color;

	/**
	 * Constructor initializing a Card
	 * 
	 * @param value Value between 1 and 5
	 * @param color color from Color enumerate
	 * @throws IllegalArgumentException if value is not include in [1,5]
	 * @throws NullPointerException     if color is null
	 */
	public Card(int value, Color color) {
		if (value < 1 || value > 5) {
			throw new IllegalArgumentException("card value must include in [1,5]");
		}
		this.value = value;
		this.color = Objects.requireNonNull(color);
	}

	/**
	 * Get card color
	 * 
	 * @return card color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * get card value
	 * 
	 * @return card value
	 */
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
