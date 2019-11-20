package fr.umlv.igm.hanabi;

public enum Color {
	WHITE, RED, BLUE, YELLOW, GREEN;
	
	public String toString() {
		switch (this) {
		case WHITE:
			return "W";
		case RED:
			return "R";
		case BLUE:
			return "B";
		case YELLOW:
			return "Y";
		case GREEN:
			return "G";
		default:
			throw new IllegalArgumentException("Unexpected value: " + this);
		}
	}
}
