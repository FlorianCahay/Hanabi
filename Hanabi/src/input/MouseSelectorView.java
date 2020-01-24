package input;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.umlv.zen5.ApplicationContext;
import mvc.ViewGraphic;

/**
 * Represents the mouse selector view
 * 
 * @author Cahay-Durand
 *
 */
public class MouseSelectorView extends ViewGraphic {

	/**
	 * Constructs a mouse selector view
	 * 
	 * @param context Application context
	 */
	public MouseSelectorView(ApplicationContext context) {
		super(context);
	}

	/**
	 * Draws the player name
	 * 
	 * @param textWriter Writing name
	 */
	public void name(TextWriter textWriter) {
		renderFrame(graphics -> name(graphics, textWriter));
	}

	/**
	 * Draws the player name
	 * 
	 * @param graphics   Application graphics
	 * @param textWriter Writing name
	 */
	private void name(Graphics2D graphics, TextWriter textWriter) {
		setFont(graphics, 10);
		var character = textWriter.lastCharacter();
		var writingName = textWriter.textLessLast();
		graphics.drawString(character, getWidth(15) + getStringWidth(writingName), getHeight(10));
	}

	/**
	 * Draws a block to erase player name
	 */
	public void resetName() {
		renderFrame(graphics -> resetName(graphics));
	}

	/**
	 * Draws a block to erase player name
	 * 
	 * @param graphics Application graphics
	 */
	private void resetName(Graphics2D graphics) {
		graphics.setColor(Color.white);
		graphics.fillRect(getWidth(15), getHeight(9), getWidth(25), getHeight(1));
	}

	/**
	 * Draws an error message
	 * 
	 * @param error Message to draw
	 */
	public void error(String error) {
		renderFrame(graphics -> error(graphics, error));
	}

	/**
	 * Draws an error message
	 * 
	 * @param graphics Application graphics
	 * @param error    Message to draw
	 */
	private void error(Graphics2D graphics, String error) {
		setFont(graphics, 10);
		graphics.setColor(Color.white);
		graphics.fillRect(0, getHeight(2), (int) getWidth(25), getHeight(2));
		graphics.setColor(Color.red);
		graphics.drawString(error, 0, getHeight(3));
	}

}
