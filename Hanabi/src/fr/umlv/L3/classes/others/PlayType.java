package fr.umlv.L3.classes.others;

import fr.umlv.L3.classes.elements.Color;
import fr.umlv.L3.classes.elements.Token;
import fr.umlv.L3.mvc.Data;
import fr.umlv.L3.mvc.View;

public enum PlayType {
	HINT, DISCARD, PLAY;

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
}
