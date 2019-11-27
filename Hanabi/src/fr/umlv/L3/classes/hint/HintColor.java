package fr.umlv.L3.classes.hint;

import fr.umlv.L3.classes.elements.Card;
import fr.umlv.L3.classes.elements.Color;

public class HintColor extends AbstractHint {
	private final Color color;

	/**
	 * @param color
	 */
	public HintColor(Color color) {
		this.color = color;
	}

	public boolean testCard(Card card) {
		if (card.getColor() == color) {
			return true;
		}
		return false;
	}

	@Override
	public String getType() {
		return "Color " + color;
	}

}
