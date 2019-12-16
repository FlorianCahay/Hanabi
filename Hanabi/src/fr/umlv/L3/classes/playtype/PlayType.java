package fr.umlv.L3.classes.playtype;

import fr.umlv.L3.classes.elements.Color;
import fr.umlv.L3.classes.elements.Token;
import fr.umlv.L3.mvc.Data;
import fr.umlv.L3.mvc.View;

/**
 * 
 * Represent an enumerate for each type of play.
 *
 */
public enum PlayType {
	HINT("Give a hint"), 
	DISCARD("Discard a card"), 
	PLAY("Play a card");

	private final String string;

	/**
	 * Constructs a PlayType.
	 * 
	 * @param string
	 */
	private PlayType(String string) {
		this.string = string;
	}

	/**
	 * Make the corresponding play.
	 * 
	 * @param data game data
	 * @param view game view
	 */
	public void play(Data data, View view) {
		switch (this) {
			case HINT:
				hint(data, view);
				break;
			case DISCARD:
				discardCard(data, view);
				break;
			case PLAY:
				playCard(data, view);
				break;
			default:
				throw new IllegalArgumentException("Unexpected value: " + this);
		}
	}

	private void hint(Data data, View view) {
		view.drawAskHint();
		data.giveHint(view);
	}

	private void discardCard(Data data, View view) {
		view.drawAskCard();
		view.drawPlayer(data.getActualPlayer());
		data.playerDiscardCard(data.inputCard(view), new Token(Color.BLUE));
	}

	private void playCard(Data data, View view) {
		view.drawAskCard();
		view.drawPlayer(data.getActualPlayer());
		var card = data.inputCard(view);
		if (data.playerPlayCard(card)) {
			view.drawPlayedCard(card);
			return;
		}
		view.drawDiscardedCard(card);
	}

	/**
	 * Returns a string representation of the type.
	 */
	@Override
	public String toString() {
		return string;
	}
}
