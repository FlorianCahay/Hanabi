package graphic;

public class Cell {

	private static final int cellsWidth = 40;
	private static final int cellsHeight = 20;
	private final int width;
	private final int height;

	public Cell(int width, int height) {
		this.width = width / cellsWidth;
		this.height = height / cellsHeight;
	}

	public int getWidth(int index) {
		if (index > cellsWidth) {
			throw new IllegalArgumentException("index for getWidth must be less than " + cellsWidth);
		}
		return width * index;
	}

	public int getHeight(int index) {
		if (index > cellsWidth) {
			throw new IllegalArgumentException("index for getWidth must be less than " + cellsHeight);
		}
		return height * index;
	}

}
