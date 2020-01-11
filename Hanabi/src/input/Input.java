package input;

import cards.Card;
import colors.Color;
import player.Player;
import player.Players;

public interface Input {

	public String getValidString(String error);

	public Color getValidColor();

	public String getValidPlayer(Players players);

	public Player getExistingPlayer(Players players, Player actualPlayer);

	public Card getValidCardFromHand(Player player);

	public int getNumberPLayers(String error, int min, int max);

	public int getHintType(String error, int min, int max);

	public int getCardValue(String error, int min, int max);

	public int getPlayType(String error, int min, int max);

	public void close();
}
