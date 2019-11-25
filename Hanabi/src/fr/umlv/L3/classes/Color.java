package fr.umlv.L3.classes;

public enum Color {
	BLUE, RED, WHITE, GREEN, YELLOW;

	@Override
	public String toString() {
		switch (this) {
		case BLUE:
			return "B";
		case RED:
			return "R";
		case WHITE:
			return "W";
		case GREEN:
			return "G";
		case YELLOW:
			return "Y";
		default:
			throw new IllegalArgumentException("Unexpected value: " + this);
		}
	}
}
