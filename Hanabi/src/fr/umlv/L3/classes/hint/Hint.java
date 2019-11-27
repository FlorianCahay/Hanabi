package fr.umlv.L3.classes.hint;

import java.util.LinkedList;

import fr.umlv.L3.classes.elements.Card;

public interface Hint {
	public String giveInfo(LinkedList<Card> hand);

	public boolean testCard(Card card);

	public String getType();
}
