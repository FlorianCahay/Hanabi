package fr.umlv.L3.classes.hint;

import java.util.LinkedList;

import fr.umlv.L3.classes.elements.Card;

/**
 * 
 * Represent an abstract class for hints.
 *
 */
public abstract class AbstractHint implements Hint {

	@Override
	public String giveInfo(LinkedList<Card> hand) {
		var str = new StringBuilder();
		str.append("Cards in position [");
		for (int i = 0; i < hand.size(); i++) {
			if (testCard(hand.get(i))) {
				str.append(i + 1);
				str.append("|");
			}
		}
		str.append("]: ");
		str.append(getType());
		return str.toString();
	}

}
