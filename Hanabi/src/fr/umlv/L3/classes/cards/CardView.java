package fr.umlv.L3.classes.cards;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import fr.umlv.L3.mvc.View;
import fr.umlv.zen5.ApplicationContext;

public class CardView {
	private final float xOrigin;
	private final float yOrigin;
	private final float width;
	private final float height;
	private static final float PADDING = 5;
	private final Card card;
	
	private CardView(float x, float y, float width, float height, Card card) {
		this.xOrigin = x;
		this.yOrigin = y;
		this.width = width;
		this.height = height;
		this.card = card;
	}
	
	public static CardView initGraphics(float x, float y, float width, float height, Card card) {
		return new CardView(x, y, width, height, card);
	}
	
	public void draw(Graphics2D graphics) {
		Font myFont = new Font ("Dialog", Font.BOLD, 20);
		graphics.setColor(Color.LIGHT_GRAY);
		graphics.fill(new Rectangle2D.Float(xOrigin+PADDING, yOrigin+PADDING, width-(PADDING*2), height-(PADDING*2)));

		graphics.setColor(card.getColor().getAWTColor());
		graphics.setFont(myFont);
		
		var value = Integer.toString(card.getValue());
		var coords = View.centerTextWithFont(graphics, myFont, value, xOrigin, yOrigin, width, height);
		graphics.drawString(value, coords[0], coords[1]);
	}
	
	public static void draw(ApplicationContext context, CardView view) {
		context.renderFrame(graphic -> view.draw(graphic));
	}
}
