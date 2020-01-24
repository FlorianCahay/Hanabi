package player;

import board.Board;
import cards.Deck;
import input.Input;
import plays.PlayType;
import plays.PlayTypeController;
import plays.PlayTypeList;
import tokens.Box;

/**
 * Represents an interface to manage the player view and the player model
 * 
 * @author Cahay-Durand
 *
 */
public class PlayerController {

	private Player model;
	private final PlayerView view;

	/**
	 * Constructs a player controller
	 * 
	 * @param model Player model
	 * @param view  Player view
	 */
	public PlayerController(Player model, PlayerView view) {
		super();
		this.model = model;
		this.view = view;
	}

	/**
	 * Draws a player
	 */
	public void showPlayer() {
		view.showPlayer(model);
	}

	/**
	 * Sets the player model
	 * 
	 * @param player Player model
	 */
	public void setPlayer(Player player) {
		this.model = player;
	}

	/**
	 * Gets a play type
	 * 
	 * @param input     Input system
	 * @param playTypes List of plays
	 * @return Play type
	 */
	private PlayType setPlayType(Input input, PlayTypeList playTypes) {
		var i = input.getPlayType("You can only chose a value from 1 to " + playTypes.size(), 1, playTypes.size());
		return playTypes.getPlayType(i);
	}

	/**
	 * Makes a play
	 * 
	 * @param input              Input system
	 * @param playTypeController Play type controller
	 * @param actualPlayer       Playing player
	 * @param players            List of players
	 * @param box                Game box
	 * @param board              Game board
	 * @param deck               Game deck
	 */
	public void makeAPlay(Input input, PlayTypeController playTypeController, Player actualPlayer, Players players,
			Box box, Board board, Deck deck) {
		view.askPlayType(model.getName());
		var play = setPlayType(input, playTypeController.getModel());
		play.play(input, actualPlayer, players, playTypeController.getView(), box, board, deck);
	}

	/**
	 * Gets the player model
	 * 
	 * @return model
	 */
	public Player getModel() {
		return model;
	}

}
