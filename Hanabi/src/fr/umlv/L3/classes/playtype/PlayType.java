package fr.umlv.L3.classes.playtype;

import fr.umlv.L3.classes.elements.Color;
import fr.umlv.L3.classes.elements.Token;
import fr.umlv.L3.mvc.Data;
import fr.umlv.L3.mvc.View;

/**
 * 
 * Represent an enumerate for each type of play
 *
 */
public enum PlayType {
	HINT("Give a hint"), DISCARD("Discard a card"), PLAY("Play a card");

	private final String string;

	/**
	 * @param string
	 */
	private PlayType(String string) {
		this.string = string;
	}

	/**
	 * Make the corresponding play
	 * 
	 * @param data Game data
	 * @param view Game view
	 */
	public void play(Data data, View view) {
		switch (this) {
		case HINT:
			view.drawAskHint();
			data.giveHint(view);
			break;
		case DISCARD:
			view.drawPlayer(data.getActualPlayer());
			view.drawAskCard();
			data.playerDiscardCard(data.inputCard(view), new Token(Color.BLUE));
			break;
		case PLAY:
			view.drawPlayer(data.getActualPlayer());
			view.drawAskCard();
			data.playerPlayCard(data.inputCard(view));
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + this);
		}
	}

	@Override
	public String toString() {
		return string;
	}
}
