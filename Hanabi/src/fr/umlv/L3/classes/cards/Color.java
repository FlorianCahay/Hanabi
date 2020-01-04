package fr.umlv.L3.classes.cards;

/**
 * 
 * Represent an enumeration of five colors.
 *
 */
public enum Color {
	BLUE(0, 0, 255), 
	RED(255, 0, 0), 
	WHITE(255, 255, 255), 
	GREEN(0, 255, 0), 
	YELLOW(255, 255, 0);
	
	private final int red;
	private final int green;
	private final int blue;
	
	Color(int red, int green, int blue ) {
		this.red = red;
		this.green = green;
		this.blue = blue;
	}
	
	public java.awt.Color getAWTColor() {
		return new java.awt.Color(this.red, this.green, this.blue);
	}
}
