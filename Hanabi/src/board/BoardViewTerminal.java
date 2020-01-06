package board;

import mvc.ViewTerminal;

public class BoardViewTerminal extends ViewTerminal implements BoardView {
	public void showBoard(Board board) {
		append(board.toString());
	}

	public void gameOver(int score) {
		separator();
		append("Game over : ");
		append(score);
	}
}
