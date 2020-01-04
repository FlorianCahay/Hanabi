package fr.umlv.L3.classes.others;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import fr.umlv.L3.classes.cards.CardView;
import fr.umlv.zen5.ApplicationContext;

public class PlayerView {
	private final float xOrigin;
	private final float yOrigin;
	private final float width;
	private final float height;
	private final boolean vertical;
	private final Player player;
	
	private PlayerView(float x, float y, float width, float height, boolean vertical, Player player) {
		this.xOrigin = x;
		this.yOrigin = y;
		this.width = width;
		this.height = height;
		this.vertical = vertical;
		this.player = player;
	}
	
	public static PlayerView initGraphics(float x, float y, float width, float height, boolean vertical, Player player) {
		return new PlayerView(x, y, width, height, vertical, player);
	}
	
	private void draw(Graphics2D graphics) {
		graphics.setColor(Color.BLACK);
		graphics.draw(new Rectangle2D.Float(xOrigin, yOrigin, width, height));
		
		var totalCards = player.getHandSize();
		for (var i = 0; i < totalCards; i++) {
			var card = player.getCard(i);
			CardView view;
			if (vertical) {
				var cardHeight = height/totalCards;
				view = CardView.initGraphics(xOrigin, yOrigin+cardHeight*i, width, cardHeight, card);
			} else {
				var cardWidth = width/totalCards;
				view = CardView.initGraphics(xOrigin+cardWidth*i, yOrigin, cardWidth, height, card);
			}
			view.draw(graphics);
		}
	}
	
	public static void draw(ApplicationContext context, PlayerView view) {
		context.renderFrame(graphic -> view.draw(graphic));
	}
	
}
