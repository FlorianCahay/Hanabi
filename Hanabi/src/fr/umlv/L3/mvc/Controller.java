package fr.umlv.L3.mvc;

import fr.umlv.L3.classes.Card;

public class Controller {
	public static void main(String[] args) {
		int nbPlayers = 2;
		Data data = new Data();
		View view = new View();

		initialisePlayers(data, view, nbPlayers);

		int i = 0;
		int playChoice = 0;

		while (true) {

			data.setActualPlayer(i);

			view.draw(data);
			view.drawSeparator();

			view.drawTypeOfPlay(data.getActualPlayerName());
			while (playChoice == 0) {
				try {
					playChoice = data.playerChoseTypeOfPlay();
				} catch (Exception e) {
					view.drawErrorTypeOfPlay();
				}
			}
			view.drawSeparator();

			if (playChoice == 1) {
				view.drawAskCardToDiscard();
				data.playerDiscardCard(choseCard(data, view));
				view.drawSeparator();
			} else {
				view.drawAskCardToPlay();
				data.playerPlayCard(choseCard(data, view));
				view.drawSeparator();
			}

			if (data.gameOver()) {
				view.drawEndGame(data.getScore());
				view.drawSeparator();
				return;
			}

			i = (i + 1) % nbPlayers;

		}
	}

	public static void initialisePlayers(Data data, View view, int nbPlayers) {
		for (int i = 0; i < nbPlayers; i++) {
			view.drawAskName(i + 1);
			data.addPlayer();
			view.drawSeparator();
		}
	}

	public static Card choseCard(Data data, View view) {
		Card card = null;
		while (!data.playerHasCard(card)) {
			if (card != null) {
				view.drawErrorCardChoseNotInHand();
			}
			try {
				card = data.inputCard();
			} catch (Exception e) {
				view.drawErrorCardChose();
			}
		}
		return card;
	}
}
