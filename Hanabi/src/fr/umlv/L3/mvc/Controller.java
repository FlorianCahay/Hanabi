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
		var nbPlayers = 2;
		var data = new Data();
		var view = new View();

		initialisePlayers(data, view, nbPlayers);

		var i = 0;
		var playChoice = 0;
		var quit = false;

		while (!quit) {
			data.setActualPlayer(i);
			view.draw(data);
			view.drawSeparator();
			playChoice = choseTypeOfPlay(data, view);
			play(data, view, playChoice);
			playChoice = 0;
			quit = isGameOver(data, view);
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

	/**
	 * return corresponding value of a play
	 * 
	 * @param data Game data
	 * @param view Game view
	 * @return value of choice
	 */
	public static int choseTypeOfPlay(Data data, View view) {
		var playChoice = 0;
		view.drawAskTypeOfPlay(data.getActualPlayerName());
		while (playChoice == 0) {
			try {
				playChoice = data.playerChoseTypeOfPlay();
			} catch (Exception e) {
				view.drawErrorTypeOfPlay(data.getActualPlayerName());
			}
		}
		view.drawSeparator();
		return playChoice;
	}

	/**
	 * make a play
	 * 
	 * @param data       Game data
	 * @param view       Game view
	 * @param playChoice value of the play
	 */
	public static void play(Data data, View view, int playChoice) {
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
	}

	/**
	 * show score if game is over
	 * 
	 * @param data Game data
	 * @param view Game view
	 * @return True if game is over, False otherwise
	 */
	public static boolean isGameOver(Data data, View view) {
		if (data.gameOver()) {
			view.drawEndGame(data.getScore());
			view.drawSeparator();
			return true;
		}
		return false;
	}
}
