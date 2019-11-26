package fr.umlv.L3.classes.elements;

import java.util.Objects;

/**
 * 
 * Represent a token as a color
 *
 */
public class Token {
	private final Color color;

	/**
	 * Constructor initializing token color
	 * 
	 * @param color Token color
	 * @throws IllegalArgumentException if color is not blue or red
	 */
	public Token(Color color) {
		if (color != Color.BLUE && color != Color.RED) {
			throw new IllegalArgumentException("a token can only be blue or red");
		}
		this.color = color;
	}

	@Override
	public String toString() {
		return color + " token";
	}

	@Override
	public int hashCode() {
		return Objects.hash(color);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Token)) {
			return false;
		}
		Token other = (Token) obj;
		return color == other.color;
	}

}