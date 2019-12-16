package fr.umlv.L3.classes.hint;

import fr.umlv.L3.classes.elements.Card;
import fr.umlv.L3.classes.elements.Color;

/**
 * 
 * Represent a hint for a color.
 *
 */
public class HintColor extends AbstractHint {
	private final Color color;

	/**
	 * Constructs a HintColor with a color.
	 * 
	 * @param color hint color to test
	 */
	public HintColor(Color color) {
		this.color = color;
	}

	/**
	 * Test if the card has the right color.
	 * 
	 * @return true if the card has the right color, false otherwise
	 */
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
