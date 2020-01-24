package player;

/**
 * Represents Players view
 * 
 * @author Cahay-Durand
 *
 */
public interface PlayersView {

	/**
	 * Asks for the number of players
	 */
	void askPlayersNumber();

	/**
	 * Asks for the player name
	 * 
	 * @param index Player index
	 */
	void askPlayerName(int index);

	/**
	 * Draws players cards
	 * 
	 * @param players       Players list
	 * @param actualPlayer  Playing player
	 * @param numberPlayers Number of player
	 */
	void showPlayersCards(Players players, Player actualPlayer, int numberPlayers);
}
