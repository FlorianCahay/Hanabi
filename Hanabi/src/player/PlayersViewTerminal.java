package player;

import mvc.ViewTerminal;

public class PlayersViewTerminal extends ViewTerminal implements PlayersView {

	@Override
	public void askPlayersNumber() {
		separator();
		System.out.println("How many players are you write it down ? (min " + Players.getMinPlayers() + " and max "
				+ Players.getMaxPlayers() + ")");
	}

	@Override
	public void askPlayerName(int index) {
		separator();
		System.out.println("Player " + (index + 1) + " write your name down :");
	}

	public void showPlayersCards(Players players, Player actualPlayer, int numberPlayer) {
		separator();
		System.out.println(players);
	}

}
