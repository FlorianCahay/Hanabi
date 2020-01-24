package tokens;

import java.util.Objects;

import colors.Color;

/**
 * Represents a token as a color
 * 
 * @author Cahay-Durand
 *
 */
public class Token {
	static final Color[] allowedColors = { Color.BLUE, Color.RED };
	private final Color color;

	/**
	 * Constructs token with a color
	 * 
	 * @param color Token color
	 * @throws IllegalArgumentException If token is not in allowedColors
	 */
	public Token(Color color) {
		if (!isColorAllowed(color)) {
			throw new IllegalArgumentException("a token can only be blue or red");
		}
		this.color = color;
	}

	/**
	 * Tests if a color is allowed
	 * 
	 * @param color Color to test
	 * @return True if color is allowed, false otherwise
	 */
	private boolean isColorAllowed(Color color) {
		for (Color aColor : allowedColors) {
			if (color == aColor) {
				return true;
			}
		}
		return false;
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
