package cards;

import java.awt.Graphics2D;

import fr.umlv.zen5.ApplicationContext;
import mvc.ViewGraphic;

/**
 * Represents a graphic deck view
 * 
 * @author flori
 *
 */
public class DeckViewGraphic extends ViewGraphic implements DeckView {

	private final CardViewGraphic cardView;

	/**
	 * Constructs graphics deck view
	 * 
	 * @param context  Application context
	 * @param cardView Card view
	 */
	public DeckViewGraphic(ApplicationContext context, CardViewGraphic cardView) {
		super(context);
		this.cardView = cardView;
	}

	@Override
	public void showRemainingCards(int numberCards) {
		renderFrame(graphics -> showRemainingCards(graphics, numberCards));
	}

	/**
	 * Draws the number of remaining cards
	 * 
	 * @param graphics    Application graphics
	 * @param numberCards Remaining cards in deck
	 */
	private void showRemainingCards(Graphics2D graphics, int numberCards) {
		setFont(graphics, 10);
		cardView.cardContainer(graphics, getWidth(32), getHeight(10), numberCards + "");
	}

}
