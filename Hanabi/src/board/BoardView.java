package board;

public interface BoardView {
	public void showBoard(Board board);
	
	public void gameOver(int score);

	public void draw();
}
