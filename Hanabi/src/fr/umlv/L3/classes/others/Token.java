package fr.umlv.L3.classes.others;

import java.util.Objects;

import fr.umlv.L3.classes.cards.Color;

/**
 * 
 * Represent a token as a color.
 *
 */
public class Token {
	private final Color color;

	/**
	 * Constructs a token with one color.
	 * 
	 * @param color color
	 * @throws IllegalArgumentException if color is not blue or red
	 */
	public Token(Color color) {
		if (color != Color.BLUE && color != Color.RED) {
			throw new IllegalArgumentException("a token can only be blue or red");
		}
		this.color = color;
	}
	
	public Color getColor() {
		return color;
	}

	/**
	 * Returns a string representation of the token.
	 */
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
