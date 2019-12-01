package fr.umlv.L3.classes.hint;

import fr.umlv.L3.classes.elements.Card;

/**
 * 
 * Represent a hint for a value
 *
 */
public class HintValue extends AbstractHint {
	private final int value;

	/**
	 * Constructor initializing HintValue with a value
	 * 
	 * @param value hint value to test
	 */
	public HintValue(int value) {
		this.value = value;
	}

	@Override
	public boolean testCard(Card card) {
		if (card.getValue() == value) {
			return true;
		}
		return false;
	}

	@Override
	public String getType() {
		return "Value " + value;
	}

}
