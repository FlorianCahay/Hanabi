package board;

import cards.Deck;

/**
 * Represents an interface to manage the board view and the board model
 * 
 * @author Cahay-Durand
 *
 */
public class BoardController {
	private final Board model;
	private final BoardView view;

	/**
	 * Constructs a BoardController with his model and his view
	 * 
	 * @param model Board data
	 * @param view  Board view
	 */
	public BoardController(Board model, BoardView view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Gets the board model
	 * 
	 * @return model
	 */
	public Board getModel() {
		return model;
	}

	/**
	 * Checks if the game is over and draw the score if game over
	 * 
	 * @param deck Game deck
	 * @return true if the game is over, false otherwise
	 */
	public boolean gameOver(Deck deck) {
		if (model.gameOver(deck)) {
			view.gameOver(model.getScore());
			return true;
		}
		return false;
	}

	/**
	 * Draws the board model
	 */
	public void showBoard() {
		view.showBoard(model);
	}

}
