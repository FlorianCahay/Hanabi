package tokens;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.umlv.zen5.ApplicationContext;
import mvc.ViewGraphic;

/**
 * Represents graphics box view
 * 
 * @author Cahay-Durand
 *
 */
public class BoxViewGraphic extends ViewGraphic implements BoxView {

	private final TokenViewGraphic tokenView;

	/**
	 * Constructs graphic box view
	 * 
	 * @param context          Application context
	 * @param tokenViewGraphic Graphic token view
	 */
	public BoxViewGraphic(ApplicationContext context, TokenViewGraphic tokenViewGraphic) {
		super(context);
		this.tokenView = tokenViewGraphic;
	}

	@Override
	public void showBox(Box box) {
		renderFrame(graphics -> showBox(graphics, box));
	}

	/**
	 * Draws the box
	 * 
	 * @param graphics Application graphics
	 * @param box      Game box
	 */
	private void showBox(Graphics2D graphics, Box box) {
		setFont(graphics, 10);
		String str = box.typeOfBox();
		graphics.fillRect(getWidth(25), getHeight(15), (int) getWidth() - getWidth(25), getHeight(13));
		var tokenY = getHeight(17);
		tokenView.token(graphics, getWidth(30), tokenY, box.getNumberToken(new Token(colors.Color.RED)), Color.red);
		tokenView.token(graphics, getWidth(35), tokenY, box.getNumberToken(new Token(colors.Color.BLUE)), Color.blue);
		graphics.drawString(str, centerTextOnX((int) getWidth() - getWidth(25), getStringWidth(str)) + getWidth(25),
				getHeight(14));
	}

}
