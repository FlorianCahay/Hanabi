package fr.umlv.L3.classes.hint;

import java.util.LinkedList;

import fr.umlv.L3.classes.elements.Card;

/**
 * 
 * Represent interface for hints.
 *
 */
public interface Hint {
	/**
	 * Give an information on player hand.
	 * 
	 * @param hand hand which we give information on
	 * @return string representing the information gave by the player
	 */
	public String giveInfo(LinkedList<Card> hand);

	/**
	 * Test if the card property is right one.
	 * 
	 * @param card card to test
	 * @return true if the card respect the property, false otherwise
	 */
	public boolean testCard(Card card);

	/**
	 * Get a string representing the hint type.
	 * 
	 * @return string representing the hint type
	 */
	public String getType();
}
