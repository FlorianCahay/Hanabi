package cards;

/**
 * Represents an interface to manage the deck view and the deck model
 * 
 * @author Cahay-Durand
 *
 */
public class DeckController {
	private final Deck model;
	private final DeckView view;

	/**
	 * Constructs deck controller with model and view
	 * 
	 * @param model Deck model
	 * @param view  Deck view
	 */
	public DeckController(Deck model, DeckView view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Gets the deck model
	 * 
	 * @return model
	 */
	public Deck getModel() {
		return model;
	}

	/**
	 * Draws the number of remaining cards
	 */
	public void showRemainingCards() {
		view.showRemainingCards(model.getSize());
	}
}
