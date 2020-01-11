package cards;

import java.awt.Color;
import java.awt.Graphics2D;

import fr.umlv.zen5.ApplicationContext;
import mvc.ViewGraphic;

public class CardViewGraphic extends ViewGraphic implements CardView {

	private final float cardHeight;
	private final float cardWidth;

	public CardViewGraphic(ApplicationContext context) {
		super(context);
		this.cardWidth = getWidth(2) + getWidth(1) / 2;
		this.cardHeight = getHeight(3);
	}

	public void card(Graphics2D graphics, int x, int y, Card card) {
		setFont(graphics, 10);
		cardBackground(graphics, x, y, card.getColor().getColor());
		cardValue(graphics, x, y, card.getValue() + "");
	}

	private void cardValue(Graphics2D graphics, int x, int y, String value) {
		graphics.drawString(value, centerTextOnX((int) (cardWidth), getStringWidth(value)) + x,
				y + (int) (cardHeight / 2));
	}

	private void cardBackground(Graphics2D graphics, int x, int y, Color color) {
		graphics.setColor(color);
		graphics.fillRect(x, y, (int) (cardWidth), (int) (cardHeight));
		graphics.setColor(Color.BLACK);
		graphics.drawRect(x, y, (int) (cardWidth), (int) (cardHeight));
	}

	public void cardContainer(Graphics2D graphics, int x, int y, String value) {
		setFont(graphics, 10);
		cardBackground(graphics, x, y, Color.GRAY);
		cardValue(graphics, x, y, value);
	}

	public float getCardHeight() {
		return cardHeight;
	}

	public float getCardWidth() {
		return cardWidth;
	}

}
