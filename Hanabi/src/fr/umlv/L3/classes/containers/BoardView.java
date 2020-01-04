package fr.umlv.L3.classes.containers;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import fr.umlv.L3.classes.cards.Card;
import fr.umlv.L3.classes.cards.CardView;
import fr.umlv.zen5.ApplicationContext;

public class BoardView {
	private final float xOrigin;
	private final float yOrigin;
	private final float width;
	private final float height;
	private final Board board;
	
	private BoardView(float xOrigin, float yOrigin, float width, float height, Board board) {
		this.xOrigin = xOrigin;
		this.yOrigin = yOrigin;
		this.width = width;
		this.height = height;
		this.board = board;
	}
	
	public static BoardView initGraphics(float x, float y, float width, float height, Board board) {
		return new BoardView(x, y, width, height, board);
	}
	
	public void draw(Graphics2D graphics) {
		graphics.setColor(Color.DARK_GRAY);
		graphics.fill(new Rectangle2D.Float(xOrigin, yOrigin, width, height));
		
//		var column = 0;
//		var fireworks = board.getFireworks().entrySet();
//		for (var color : fireworks) {
////			var card = new Card(firework.valueOf(arg0), firework);
////			var cardView = CardView.initGraphics(0, 0, 0, 0, card);
////			cardView.draw(graphics);
//		}
	}
	
	public static void draw(ApplicationContext context, BoardView view) {
		context.renderFrame(graphic -> view.draw(graphic));
	}
}
