package cards;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.umlv.zen5.ApplicationContext;
import mvc.ViewGraphic;

/**
 * Represents a graphic card view
 * 
 * @author Cahay-Durand
 *
 */
public class CardViewGraphic extends ViewGraphic implements CardView {

	private final float cardHeight;
	private final float cardWidth;

	/**
	 * Constructs a graphic card view
	 * 
	 * @param context Application context
	 */
	public CardViewGraphic(ApplicationContext context) {
		super(context);
		this.cardWidth = getWidth(2) + getWidth(1) / 2;
		this.cardHeight = getHeight(3);
	}

	/**
	 * Draws a card
	 * 
	 * @param graphics Application graphics
	 * @param x        Upper left corner x
	 * @param y        Upper left corner y
	 * @param card     Card to draw
	 */
	public void card(Graphics2D graphics, int x, int y, Card card) {
		setFont(graphics, 10);
		cardBackground(graphics, x, y, card.getColor().getColor());
		cardValue(graphics, x, y, card.getValue() + "");
	}

	/**
	 * Draws the card value in its center
	 * 
	 * @param graphics Application graphics
	 * @param x        Upper left corner x
	 * @param y        Upper left corner y
	 * @param value    Value to draw
	 */
	private void cardValue(Graphics2D graphics, int x, int y, String value) {
		graphics.drawString(value, centerTextOnX((int) (cardWidth), getStringWidth(value)) + x,
				y + (int) (cardHeight / 4) + graphics.getFont().getSize());
	}

	/**
	 * Draws the card background as the card color
	 * 
	 * @param graphics Application graphics
	 * @param x        Upper left corner x
	 * @param y        Upper left corner y
	 * @param color    Background color
	 */
	private void cardBackground(Graphics2D graphics, int x, int y, Color color) {
		graphics.setColor(color);
		graphics.fillRect(x, y, (int) (cardWidth), (int) (cardHeight));
		graphics.setColor(Color.BLACK);
		graphics.drawRect(x, y, (int) (cardWidth), (int) (cardHeight));
	}

	/**
	 * Draws a grey background card with value
	 * 
	 * @param graphics Application graphics
	 * @param x        Upper left corner x
	 * @param y        Upper left corner y
	 * @param value    Container Value
	 */
	public void cardContainer(Graphics2D graphics, int x, int y, String value) {
		setFont(graphics, 10);
		cardBackground(graphics, x, y, Color.GRAY);
		cardValue(graphics, x, y, value);
	}

	/**
	 * Gets card height
	 * 
	 * @return cardHeight
	 */
	public float getCardHeight() {
		return cardHeight;
	}

	/**
	 * Gets card width
	 * 
	 * @return cardWidth
	 */
	public float getCardWidth() {
		return cardWidth;
	}

}
