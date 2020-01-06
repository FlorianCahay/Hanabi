package input;

import cards.Card;
import colors.Color;
import player.Player;
import player.Players;

public interface Input {

	public int getValidInt(String error, int min, int max);

	public String getValidString(String error);

	public Color getValidColor();

	public String getValidPlayer(Players players);

	public Player getExistingPlayer(Players players, Player actualPlayer);

	public Card getValidCardFromHand(Player player);

	public void close();
}
