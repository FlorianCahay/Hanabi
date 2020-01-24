package plays;

import cards.Card;

/**
 * Represents play type view
 * 
 * @author Cahay-Durand
 *
 */
public interface PlayTypeView {
	/**
	 * Draws the possible plays
	 * 
	 * @param plays Possible plays
	 */
	void showPossiblePlays(PlayTypeList plays);

	/**
	 * Draws question asking which player to chose
	 */
	void askWhichPlayer();

	/**
	 * Draws question asking for color or value
	 */
	public void askColorOrValue();

	/**
	 * Draws question asking for color
	 */
	void askColor();

	/**
	 * Draws question asking for value
	 */
	void askValue();

	/**
	 * Draws question asking for card
	 */
	void askCard();

	/**
	 * Draws the played Card
	 * 
	 * @param card Played card
	 */
	void showPlayedCard(Card card);

	/**
	 * Draws the discarded Card
	 * 
	 * @param card Discarded card
	 */
	void showDiscardedCard(Card card);
}
