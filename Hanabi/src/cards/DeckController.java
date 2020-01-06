package cards;

public class DeckController {
	private final Deck model;
	private final DeckView view;

	public DeckController(Deck model, DeckView view) {
		this.model = model;
		this.view = view;
	}

	public Deck getModel() {
		return model;
	}

	public void showRemainingCards() {
		view.showRemainingCards(model.getSize());
	}
}
