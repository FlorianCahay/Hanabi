package graphic;

/**
 * Represents screen cell divider, to make graphics positions easier
 * 
 * @author Cahay-Durand
 *
 */
public class Cell {

	private static final int cellsWidth = 40;
	private static final int cellsHeight = 20;
	private final int width;
	private final int height;

	/**
	 * Constructs a cell
	 * 
	 * @param width  Screen width
	 * @param height Screen height
	 */
	public Cell(int width, int height) {
		this.width = width / cellsWidth;
		this.height = height / cellsHeight;
	}

	/**
	 * Gets the cell x point for the cell at index
	 * 
	 * @param index Which cell
	 * @return X point of the cell
	 * @throws IllegalArgumentException If index is not include in [0-cellsWidth]
	 */
	public int getWidth(int index) {
		if (index > cellsWidth || index < 0) {
			throw new IllegalArgumentException("index for getWidth must be less than " + cellsWidth);
		}
		return width * index;
	}

	/**
	 * Gets the cell y point for the cell at index
	 * 
	 * @param index Which cell
	 * @return Y point of the cell
	 * @throws IllegalArgumentException If index is not include in [0-cellsHeight]
	 */
	public int getHeight(int index) {
		if (index > cellsHeight || index < 0) {
			throw new IllegalArgumentException("index for getWidth must be less than " + cellsHeight);
		}
		return height * index;
	}

}
