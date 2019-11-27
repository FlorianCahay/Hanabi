package fr.umlv.L3.mvc;

import fr.umlv.L3.classes.others.PlayType;

/**
 * 
 * Represent the game loop
 *
 */
public class Controller {
	public static void main(String[] args) {

		var data = new Data();
		var view = new View();

		var nbPlayers = setNbPlayers(data, view);

		initialisePlayers(data, view, nbPlayers);

		var i = 0;
		PlayType playChoice;
		var quit = false;

		while (!quit) {
			data.setActualPlayer(i);
			view.draw(data);
			playChoice = choseTypeOfPlay(data, view);
			playChoice.play(data, view);
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
			data.addPlayer(view, nbPlayers);
		}
	}

	/**
	 * return corresponding value of a play
	 * 
	 * @param data Game data
	 * @param view Game view
	 * @return value of choice
	 */
	public static PlayType choseTypeOfPlay(Data data, View view) {
		view.drawAskTypeOfPlay(data.getActualPlayer());
		switch (data.playerChoseTypeOfPlay(view)) {
		case 1:
			return PlayType.HINT;
		case 2:
			return PlayType.DISCARD;
		case 3:
			return PlayType.PLAY;
		default:
			throw new IllegalArgumentException("Unexpected value");
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
			return true;
		}
		return false;
	}

	public static int setNbPlayers(Data data, View view) {
		view.drawAskPlayers();
		return data.inputNbPlayers(view);
	}
}
