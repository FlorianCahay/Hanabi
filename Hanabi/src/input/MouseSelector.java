package input;

import cards.Card;
import colors.Color;
import player.Player;
import player.Players;

public class MouseSelector implements Input{

	@Override
	public int getValidInt(String error, int min, int max) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getValidString(String error) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Color getValidColor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getValidPlayer(Players players) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Player getExistingPlayer(Players players, Player actualPlayer) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Card getValidCardFromHand(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void close() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateView() {
		// TODO Auto-generated method stub
		
	}

}
