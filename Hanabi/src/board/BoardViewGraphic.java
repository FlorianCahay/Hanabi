package board;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import cards.Card;
import cards.CardViewGraphic;
import fr.umlv.zen5.ApplicationContext;
import mvc.ViewGraphic;
import tokens.Token;
import tokens.TokenViewGraphic;

/**
 * Represents graphic board view
 * 
 * @author Cahay-Durand
 *
 */
public class BoardViewGraphic extends ViewGraphic implements BoardView {

	private final TokenViewGraphic tokenView;
	private final CardViewGraphic cardView;

	/**
	 * Constructs a graphic board view
	 * 
	 * @param context   Application context
	 * @param tokenView Token view
	 * @param cardView  Card view
	 */
	public BoardViewGraphic(ApplicationContext context, TokenViewGraphic tokenView, CardViewGraphic cardView) {
		super(context);
		this.tokenView = tokenView;
		this.cardView = cardView;
	}

	@Override
	public void showBoard(Board board) {
		renderFrame(graphics -> showBoard(graphics, board));
	}

	/**
	 * Draws a board
	 * 
	 * @param graphics Application graphics
	 * @param board    Board data to draw
	 */
	private void showBoard(Graphics2D graphics, Board board) {
		setFont(graphics, 10);
		String str = board.typeOfBox();
		graphics.drawString(str, centerTextOnX((int) getWidth() - getWidth(25), getStringWidth(str)) + getWidth(25),
				getHeight(5));
		tokenView.token(graphics, getWidth(25), getHeight(11), board.getNumberToken(new Token(colors.Color.RED)),
				Color.red);
		tokenView.token(graphics, getWidth(28), getHeight(11), board.getNumberToken(new Token(colors.Color.BLUE)),
				Color.blue);
		fireworks(graphics, board.getFireworks());
		if (board.getDiscardedCardSize() > 0) {
			cardView.card(graphics, getWidth(37), getHeight(10), board.getLastDiscardedCard());
		}
	}

	/**
	 * Draws fireworks
	 * 
	 * @param graphics  Application graphics
	 * @param fireworks Fireworks to draw
	 */
	private void fireworks(Graphics2D graphics, HashMap<colors.Color, Integer> fireworks) {
		int i = 0;
		for (colors.Color color : fireworks.keySet()) {
			cardView.card(graphics, (int) (getWidth(25) + i * (cardView.getCardWidth() + cardView.getCardWidth() / 4)),
					getHeight(6), new Card(fireworks.get(color), color));
			i++;
		}
	}

	@Override
	public void gameOver(int score) {
		renderFrame(graphics -> gameOver(graphics, score));
		try {
			TimeUnit.SECONDS.sleep(3);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Draws the score
	 * 
	 * @param graphics Application graphics
	 * @param score    Score to draw
	 */
	private void gameOver(Graphics2D graphics, int score) {
		setFont(graphics, 20);
		graphics.setColor(Color.RED);
		centeredText(graphics, "Game is Over you scored " + score + " points", getHeight(10));
	}

}
