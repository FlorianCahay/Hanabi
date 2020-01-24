package player;

public interface PlayerView {
	/**
	 * Draws player informations
	 * 
	 * @param player Player which to show info
	 */
	void showPlayer(Player player);

	/**
	 * Draws a question to ask type of play
	 * 
	 * @param name Player name
	 */
	void askPlayType(String name);
}
