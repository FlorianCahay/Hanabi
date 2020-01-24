package player;

import java.util.Iterator;

import cards.Deck;
import cards.Hand;
import input.Input;

/**
 * Represents an interface to manage the players view and the players model
 * 
 * @author Cahay-Durand
 *
 */
public class PlayersController {
	private final Players model;
	private final PlayersView view;

	/**
	 * Constructs a players controller
	 * 
	 * @param model Players model
	 * @param view  Players view
	 */
	public PlayersController(Players model, PlayersView view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Gets the input number of players
	 * 
	 * @param input Input system
	 * @return Number of players
	 */
	private int inputNumberOfPlayers(Input input) {
		return input.getNumberPLayers("This game can be played from " + Players.getMinPlayers() + " to "
				+ Players.getMaxPlayers() + " players", Players.getMinPlayers(), Players.getMaxPlayers());
	}

	/**
	 * Gets the number of players
	 * 
	 * @param input Input system
	 * @return Number of players
	 */
	public int setPlayersNumber(Input input) {
		view.askPlayersNumber();
		return inputNumberOfPlayers(input);
	}

	/**
	 * Adds a player by his name
	 * 
	 * @param input Input system
	 * @param hand  New player hand
	 */
	public void inputPlayerName(Input input, Hand hand) {
		model.add(new Player(input.getValidPlayer(model), hand));
	}

	/**
	 * Sets players names
	 * 
	 * @param numberPlayers Number of player
	 * @param input         Input system
	 * @param deck          Game deck
	 */
	public void setPlayersName(int numberPlayers, Input input, Deck deck) {
		int nbCards = 5;
		if (numberPlayers > 3) {
			nbCards = 4;
		}
		for (int i = 0; i < numberPlayers; i++) {
			view.askPlayerName(i);
			inputPlayerName(input, new Hand(deck, nbCards));
		}
	}

	/**
	 * Draws players cards
	 * 
	 * @param actualPlayer Playing player
	 * @param numberPlayer Number of players
	 */
	public void showPlayersCards(Player actualPlayer, int numberPlayer) {
		view.showPlayersCards(model, actualPlayer, numberPlayer);
	}

	/**
	 * Gets the players iterator
	 * 
	 * @return Players iterator
	 */
	public Iterator<Player> playersIterator() {
		return model.getIterator();
	}

	/**
	 * Gets the player model
	 * 
	 * @return model
	 */
	public Players getModel() {
		return model;
	}

}
