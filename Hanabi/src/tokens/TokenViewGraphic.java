package tokens;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.umlv.zen5.ApplicationContext;
import mvc.ViewGraphic;

/**
 * Represents a graphic token view
 */
public class TokenViewGraphic extends ViewGraphic implements TokenView {

	private final int tokenSize;

	/**
	 * Constructs graphic token view
	 * 
	 * @param context Application context
	 */
	public TokenViewGraphic(ApplicationContext context) {
		super(context);
		this.tokenSize = (int) ((getWidth() + getHeight()) / 40);
	}

	/**
	 * Draws a token with a value
	 * 
	 * @param graphics Application graphics
	 * @param x        Upper left corner x
	 * @param y        Upper left corner Y
	 * @param value    Value to draw in its center
	 * @param color    Token color
	 */
	public void token(Graphics2D graphics, int x, int y, int value, Color color) {
		setFont(graphics, 10);
		graphics.setColor(color);
		graphics.fillOval(x, y, tokenSize, tokenSize);
		graphics.setColor(Color.BLACK);
		String str = value + "";
		graphics.drawString(str, x + getStringWidth(str), y + getStringWidth(str) * 2);
	}

}
