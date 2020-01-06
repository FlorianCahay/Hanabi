package player;

import mvc.ViewTerminal;

public class PlayersViewTerminal extends ViewTerminal implements PlayersView {

	@Override
	public void askPlayersNumber() {
		separator();
		append("How many players are you write it down ? (min ");
		append(Players.getMinPlayers());
		append(" and max ");
		append(Players.getMaxPlayers());
		append(")");
	}

	@Override
	public void askPlayerName(int index) {
		separator();
		append("Player ");
		append(index + 1);
		append(" write your name down :");
	}

	public void showPlayersCards(Players players) {
		separator();
		append(players.toString());
	}

}
