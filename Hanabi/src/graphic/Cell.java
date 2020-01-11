package graphic;

public class Cell {
	private final int width;
	private final int height;
	private final int cellsWidth;
	private final int cellsHeight;

	public Cell(int width, int height) {
		this.cellsWidth = 40;
		this.cellsHeight = 20;
		this.width = width / cellsWidth;
		this.height = height / cellsHeight;
	}

	public int getWidth(int index) {
		return width * index;
	}

	public int getHeight(int index) {
		return height * index;
	}

}
