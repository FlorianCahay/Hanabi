package fr.umlv.igm.hanabi;

import java.util.Objects;

public class Token {
	private final Color color;

	public Token(Color color) {
		if (color != Color.BLUE || color != Color.RED) {
			throw new IllegalArgumentException("a token can only be blue or red");
		}
		this.color = Objects.requireNonNull(color);
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
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Token other = (Token) obj;
		return color == other.color;
	}
	
}
