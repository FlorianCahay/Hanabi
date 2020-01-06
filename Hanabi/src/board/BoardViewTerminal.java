package board;

import mvc.ViewTerminal;

public class BoardViewTerminal extends ViewTerminal implements BoardView {
	public void showBoard(Board board) {
		System.out.println(board);
	}

	public void gameOver(int score) {
		separator();
		System.out.println("Game over : " + score);
	}

}
