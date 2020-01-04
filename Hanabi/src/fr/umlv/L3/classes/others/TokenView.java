package fr.umlv.L3.classes.others;

import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

import fr.umlv.zen5.ApplicationContext;

public class TokenView {
	private final float xOrigin;
	private final float yOrigin;
	private final float width;
	private final float height;
	private final Token token;
	private static final float PADDING = 10;
	
	private TokenView(float xOrigin, float yOrigin, float width, float height, Token token) {
		this.xOrigin = xOrigin;
		this.yOrigin = yOrigin;
		this.width = width;
		this.height = height;
		this.token = token;
	};
	
	public static TokenView initGraphics(float x, float y, float width, float height, Token token) {
		return new TokenView(x, y, width, height, token);
	}
	
	public void draw(Graphics2D graphics) {
		graphics.setColor(token.getColor().getAWTColor());
		graphics.fill(new Ellipse2D.Float(xOrigin+PADDING, yOrigin+PADDING, width-PADDING*2, height-PADDING*2));
	}
	
	public static void draw(ApplicationContext context, TokenView view) {
		context.renderFrame(graphic -> view.draw(graphic));
	}
}
