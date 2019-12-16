package fr.umlv.L3.mvc;

import fr.umlv.L3.classes.playtype.PlayType;

/**
 * 
 * Represent the game loop
 *
 */
public class Controller {
	public static void main(String[] args) {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				var data = new Data();
				var view = new View();
				var nbPlayers = setNbPlayers(data, view);

				initialisePlayers(data, view, nbPlayers);

				var i = 0;
				PlayType playChoice;
				var quit = false;

				while (!quit) {
					data.setActualPlayer(i);
					data.setPlayTypes();
					view.draw(data);
					playChoice = choseTypeOfPlay(data, view);
					playChoice.play(data, view);
					quit = isGameOver(data, view);
					i = (i + 1) % nbPlayers;
				}
				data.closeScanner();
			}
		});
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
			if (!data.addPlayer(view, nbPlayers)) {
				i--;
			}
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
		view.drawAskTypeOfPlay(data.getActualPlayer(), data.getPlayTypes());
		return data.playerChoseTypeOfPlay(view);
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

	/**
	 * get a valid number of playing players
	 * 
	 * @param data Game data
	 * @param view Game view
	 * @return valid number of players
	 */
	public static int setNbPlayers(Data data, View view) {
		view.drawAskPlayers();
		return data.inputNbPlayers(view);
	}
}
