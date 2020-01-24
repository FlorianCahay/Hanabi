package input;

import cards.Card;
import colors.Color;
import player.Player;
import player.Players;

/**
 * Represents interface for all types of input
 * 
 * @author Cahay-Durand
 *
 */
public interface Input {

	/**
	 * Gets a valid string from the input
	 * 
	 * @param error Error to show if the string is invalid
	 * @return Valid string
	 */
	String getValidString(String error);

	/**
	 * Gets a valid color from the input
	 * 
	 * @return Valid color
	 */
	Color getValidColor();

	/**
	 * Gets a valid player name not existing
	 * 
	 * @param players Players list
	 * @return Valid player name
	 */
	String getValidPlayer(Players players);

	/**
	 * Gets an existing player except actualPlayer
	 * 
	 * @param players      Players list
	 * @param actualPlayer Playing player
	 * @return Valid player
	 */
	Player getExistingPlayer(Players players, Player actualPlayer);

	/**
	 * Gets a valid from the player hand
	 * 
	 * @param player Player from which we get card
	 * @return Valid card
	 */
	Card getValidCardFromHand(Player player);

	/**
	 * Gets the number of Players
	 * 
	 * @param error Error to show if the number of players is not accepted
	 * @param min   Minimum value
	 * @param max   Maximum value
	 * @return Number of players
	 */
	int getNumberPLayers(String error, int min, int max);

	/**
	 * Gets a hint type value
	 * 
	 * @param error Error to show if the hint type value is not accepted
	 * @param min   Minimum value
	 * @param max   Maximum value
	 * @return Hint type value
	 */
	int getHintType(String error, int min, int max);

	/**
	 * Gets a card value
	 * 
	 * @param error Error to show if the card value is not accepted
	 * @param min   Minimum value
	 * @param max   Maximum value
	 * @return Card value
	 */
	int getCardValue(String error, int min, int max);

	/**
	 * Gets a play type value
	 * 
	 * @param error Error to show if the play type value is not accepted
	 * @param min   Minimum value
	 * @param max   Maximum value
	 * @return Play type value
	 */
	int getPlayType(String error, int min, int max);

	/**
	 * Closes the input system
	 */
	void close();
}
