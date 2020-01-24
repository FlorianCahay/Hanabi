package colors;

/**
 * Represents color
 * 
 * @author Cahay-Durand
 *
 */
public enum Color {

	BLUE(java.awt.Color.BLUE), RED(java.awt.Color.RED), WHITE(java.awt.Color.WHITE), YELLOW(java.awt.Color.YELLOW),
	GREEN(java.awt.Color.GREEN);

	private final java.awt.Color color;

	/**
	 * Constructs color
	 * 
	 * @param color awt.Color
	 */
	private Color(java.awt.Color color) {
		this.color = color;
	}

	/**
	 * Gets a awt.Color equivalent
	 * 
	 * @return awt.Color
	 */
	public java.awt.Color getColor() {
		return color;
	}

}
