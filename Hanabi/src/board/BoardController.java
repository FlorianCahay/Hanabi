package board;

import cards.Deck;

public class BoardController {
	private final Board model;
	private final BoardView view;

	public BoardController(Board model, BoardView view) {
		this.model = model;
		this.view = view;
	}

	public Board getModel() {
		return model;
	}

	public boolean gameOver(Deck deck) {
		if (model.gameOver(deck)) {
			view.gameOver(model.getScore());
			return true;
		}
		return false;
	}

	public void showBoard() {
		view.showBoard(model);
	}

}
