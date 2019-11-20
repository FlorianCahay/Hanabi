package fr.umlv.igm.hanabi;

public class Controller {
	public static void main(String[] args) {
		Data data = new Data();
		View view = new View();
		data.initialisePlayers(2);
		for (int i = 0; i < data.getPlayers().getPlayersSize(); i++) {
			view.drawAskName(i + 1);
			data.setPlayerName(i);
		}
		view.draw(data);
		int i = 0;
		while (true) {
			view.drawTypeOfPlay(data.getPlayers().getPlayerName(i));
			data.playerChoseTypeOfPlay();
			i = (i + 1) % 2;
		}

	}
}