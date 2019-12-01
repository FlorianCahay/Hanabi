package fr.umlv.L3.classes.hint;

import java.util.LinkedList;

import fr.umlv.L3.classes.elements.Card;

/**
 * 
 * Represent interface for hints
 *
 */
public interface Hint {
	/**
	 * give an information on player hand
	 * 
	 * @param hand Hand which we give information on
	 * @return string representing the information gave by the player
	 */
	public String giveInfo(LinkedList<Card> hand);

	/**
	 * test if the card property is right one
	 * 
	 * @param card Card to test
	 * @return true if the card respect the property, false otherwise
	 */
	public boolean testCard(Card card);

	/**
	 * get a string representing the hint type
	 * 
	 * @return string representing the hint type
	 */
	public String getType();
}
