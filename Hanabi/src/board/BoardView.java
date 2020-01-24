package board;

/**
 * Represents a boardView
 * 
 * @author Cahay-Durand
 *
 */
public interface BoardView {
	/**
	 * Draws a board
	 * 
	 * @param board Board data
	 */
	void showBoard(Board board);

	/**
	 * Draws the final score
	 * 
	 * @param score Score to draw
	 */
	void gameOver(int score);
}
