package colors;

public enum Color {

	BLUE(java.awt.Color.BLUE), RED(java.awt.Color.RED), WHITE(java.awt.Color.WHITE), YELLOW(java.awt.Color.YELLOW),
	GREEN(java.awt.Color.GREEN);

	private final java.awt.Color color;

	private Color(java.awt.Color color) {
		this.color = color;
	}

	public java.awt.Color getColor() {
		return color;
	}

}
