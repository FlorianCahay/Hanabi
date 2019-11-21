package fr.umlv.igm.hanabi.mvc;

public class Controller {
	public static void main(String[] args) {
		int nbPlayers = 2;
		Data data = new Data();
		View view = new View();
		data.initialisePlayers(nbPlayers);

		for (int i = 0; i < nbPlayers; i++) {
			view.drawAskName(i + 1);
			data.setPlayerName(i);
			view.drawSeparator();
		}

		int i = 0;
		int choice = 0;
		while (true) {
			view.draw(data);
			view.drawSeparator();
			view.drawTypeOfPlay(data.getPlayers().getPlayer(i).getName());
			choice = data.playerChoseTypeOfPlay();
			view.drawSeparator();
			if (choice == 1) {
				view.drawAskCardToDiscard();
				data.playerDiscardCard(i);
			} else {

			}
			i = (i + 1) % nbPlayers;
		}

	}
}