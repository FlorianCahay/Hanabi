package cards;

import java.awt.Graphics2D;

import fr.umlv.zen5.ApplicationContext;
import mvc.ViewGraphic;

public class DeckViewGraphic extends ViewGraphic implements DeckView {

	private final CardViewGraphic cardView;

	public DeckViewGraphic(ApplicationContext context, CardViewGraphic cardView) {
		super(context);
		this.cardView = cardView;
	}

	@Override
	public void showRemainingCards(int numberCards) {
		renderFrame(graphics -> showRemainingCards(graphics, numberCards));
	}

	private void showRemainingCards(Graphics2D graphics, int numberCards) {
		setFont(graphics, 10);
		cardView.cardContainer(graphics, getWidth(32), getHeight(10), numberCards + "");
	}

}
