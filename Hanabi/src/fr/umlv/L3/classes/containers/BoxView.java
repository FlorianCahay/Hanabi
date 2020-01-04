package fr.umlv.L3.classes.containers;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import fr.umlv.L3.classes.others.Token;
import fr.umlv.L3.classes.others.TokenView;
import fr.umlv.L3.mvc.View;
import fr.umlv.zen5.ApplicationContext;

public class BoxView {
	private final float xOrigin;
	private final float yOrigin;
	private final float width;
	private final float height;
	private final Box box;
	
	private BoxView(float xOrigin, float yOrigin, float width, float height, Box box) {
		this.xOrigin = xOrigin;
		this.yOrigin = yOrigin;
		this.width = width;
		this.height = height;
		this.box = box;
	}
	
	public static BoxView initGraphics(float x, float y, float width, float height, Box box) {
		return new BoxView(x, y, width, height, box);
	}
	
	private void draw(Graphics2D graphics) {
		Font myFont = new Font ("Dialog", Font.BOLD, 20);
		graphics.setColor(Color.DARK_GRAY);
		graphics.fill(new Rectangle2D.Float(xOrigin, yOrigin, width, height));
		// Tokens
		TokenView.initGraphics(xOrigin, yOrigin, width/2, height, new Token(fr.umlv.L3.classes.cards.Color.BLUE)).draw(graphics);
		TokenView.initGraphics(xOrigin+width/2, yOrigin, width/2, height, new Token(fr.umlv.L3.classes.cards.Color.RED)).draw(graphics);
		// Number of tokens
		graphics.setColor(Color.WHITE);
		graphics.setFont(myFont);
		var nbBlueToken = Integer.toString(box.getNumberBlueToken());
		var coords = View.centerTextWithFont(graphics, myFont, nbBlueToken, xOrigin, yOrigin, width/2, height);
		graphics.drawString(nbBlueToken, coords[0], coords[1]);
		var nbRedToken = Integer.toString(box.getNumberRedToken());
		coords = View.centerTextWithFont(graphics, myFont, nbRedToken, xOrigin+width/2, yOrigin, width/2, height);
		graphics.drawString(nbRedToken, coords[0], coords[1]);
		
	}
	
	public static void draw(ApplicationContext context, BoxView view) {
		context.renderFrame(graphic -> view.draw(graphic));
	}
	
}
