package fr.umlv.L3.mvc;

import java.awt.Color;

import fr.umlv.L3.classes.playtype.PlayType;
import fr.umlv.zen5.Application;
import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.Event.Action;

/**
 * 
 * Represent the game loop
 *
 */
public class Controller {
	public static void main(String[] args) {
		Application.run(Color.WHITE, Controller::app);
	}
	
	
	private static void app(ApplicationContext context) {
		// get the size of the screen
		var screenInfo = context.getScreenInfo();
		var width = screenInfo.getWidth();
		var height = screenInfo.getHeight();
		System.out.println("size of the screen (" + width + " x " + height + ")");
		
		var data = new Data();
		var view = new View(context, width, height);
		var nbPlayers = 2; //setNbPlayers(data, view);
		initialisePlayers(data, view, 1);
		var i = 0;
		data.setActualPlayer(i);
		//PlayType playChoice;
		var quit = false;
		view.drawGraphics(data);
		
		while (!quit) {
			Event event = context.pollOrWaitEvent(10);
			if (event == null) { // no event
				continue;
			}
			Action action = event.getAction();
			if (action == Action.KEY_PRESSED || action == Action.KEY_RELEASED) {
				System.out.println("Aaaaahh!");
				context.exit(0);
				return;
			}
			view.drawGraphics(data);
			
			data.setActualPlayer(i);
//			data.setPlayTypes();
//			view.draw(data);
//			playChoice = choseTypeOfPlay(data, view);
//			playChoice.play(data, view);
//			quit = isGameOver(data, view);
			i = (i + 1) % nbPlayers;
		}
		data.closeScanner();
	}

	/**
	 * Initialize players by asking their names.
	 * 
	 * @param data      game data
	 * @param view      game view
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
	 * Return corresponding value of a play.
	 * 
	 * @param data game data
	 * @param view game view
	 * @return value of choice
	 */
	public static PlayType choseTypeOfPlay(Data data, View view) {
		view.drawAskTypeOfPlay(data.getActualPlayer(), data.getPlayTypes());
		return data.playerChoseTypeOfPlay(view);
	}

	/**
	 * Show score if the game is over.
	 * 
	 * @param data game data
	 * @param view game view
	 * @return true if game is over, false otherwise
	 */
	public static boolean isGameOver(Data data, View view) {
		if (data.gameOver()) {
			view.drawEndGame(data.getScore());
			return true;
		}
		return false;
	}

	/**
	 * Get a valid number of playing players.
	 * 
	 * @param data game data
	 * @param view game view
	 * @return valid number of players
	 */
	public static int setNbPlayers(Data data, View view) {
		view.drawAskPlayers();
		return data.inputNbPlayers(view);
	}
}
