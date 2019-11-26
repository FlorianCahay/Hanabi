package fr.umlv.L3.mvc;

import fr.umlv.L3.classes.elements.Card;
import fr.umlv.L3.classes.elements.Color;
import fr.umlv.L3.classes.elements.Token;

/**
 * 
 * Represent the game loop
 *
 */
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
					view.drawErrorTypeOfPlay(data.getActualPlayerName());
				}
			}
			view.drawSeparator();

			if (playChoice == 1) {
				view.drawPlayer(data.getActualPlayer());
				view.drawAskCard();
				data.playerDiscardCard(choseCard(data, view), new Token(Color.BLUE));
				view.drawSeparator();
			} else {
				view.drawPlayer(data.getActualPlayer());
				view.drawAskCard();
				data.playerPlayCard(choseCard(data, view));
				view.drawSeparator();
			}
			playChoice = 0;

			if (data.gameOver()) {
				view.drawEndGame(data.getScore());
				view.drawSeparator();
				return;
			}

			i = (i + 1) % nbPlayers;

		}
	}

	/**
	 * initialize players by asking their names
	 * 
	 * @param data      Game data
	 * @param view      Game view
	 * @param nbPlayers number of players to initialize
	 */
	public static void initialisePlayers(Data data, View view, int nbPlayers) {
		for (int i = 0; i < nbPlayers; i++) {
			view.drawAskName(i + 1);
			data.addPlayer();
			view.drawSeparator();
		}
	}

	/**
	 * player chose card in his hand
	 * 
	 * @param data Game data
	 * @param view Game view
	 * @return Card initialize
	 */
	public static Card choseCard(Data data, View view) {
		Card card = null;
		while (!data.playerHasCard(card)) {
			if (card != null) {
				view.drawErrorCardChoseNotInHand(data.getActualPlayer());
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
