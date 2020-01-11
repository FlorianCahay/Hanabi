package tokens;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.umlv.zen5.ApplicationContext;
import mvc.ViewGraphic;

public class TokenViewGraphic extends ViewGraphic implements TokenView {

	private final int tokenSize;

	public TokenViewGraphic(ApplicationContext context) {
		super(context);
		this.tokenSize = (int) ((getWidth() + getHeight()) / 40);
	}

	public void token(Graphics2D graphics, int x, int y, int value, Color color) {
		setFont(graphics,10);
		graphics.setColor(color);
		graphics.fillOval(x, y, tokenSize, tokenSize);
		graphics.setColor(Color.BLACK);
		String str = value + "";
		graphics.drawString(str, x + getStringWidth(str), y + getStringWidth(str) * 2);
	}

}
