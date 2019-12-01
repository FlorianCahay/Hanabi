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
	HINT, DISCARD, PLAY;

	/**
	 * Make the corresponding play play
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
			view.drawSeparator();
			break;
		case PLAY:
			view.drawPlayer(data.getActualPlayer());
			view.drawAskCard();
			data.playerPlayCard(data.inputCard(view));
			view.drawSeparator();
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + this);
		}
	}

	@Override
	public String toString() {
		switch (this) {
		case HINT:
			return "Give a hint";
		case DISCARD:
			return "Dicard a card";
		case PLAY:
			return "Play a card";
		default:
			throw new IllegalArgumentException("Unexpected value: " + this);
		}
	}
}
