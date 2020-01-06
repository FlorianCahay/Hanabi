package cards;

import mvc.Controller;

public class DeckController implements Controller {
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
		updateView();
	}

	@Override
	public void updateView() {
		view.draw();
	}
}
