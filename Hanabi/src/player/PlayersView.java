package player;

public interface PlayersView {

	public void askPlayersNumber();

	public void askPlayerName(int index);

	public void showPlayersCards(Players players, Player actualPlayer, int numberPlayers);
}
