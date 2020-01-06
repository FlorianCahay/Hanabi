package player;

import board.Board;
import cards.Deck;
import input.Input;
import mvc.Controller;
import plays.PlayType;
import plays.PlayTypeController;
import plays.PlayTypeList;
import tokens.Box;

public class PlayerController implements Controller {

	private Player model;
	private final PlayerView view;

	public PlayerController(Player model, PlayerView view) {
		super();
		this.model = model;
		this.view = view;
	}

	public void showPlayer() {
		view.showPlayer(model);
		updateView();
	}

	public void setPlayer(Player player) {
		this.model = player;
	}

	private PlayType setPlayType(Input input, PlayTypeList playTypes) {
		var i = input.getValidInt("You can only chose a value from 1 to " + playTypes.size(), 1, playTypes.size());
		return playTypes.getPlayType(i);
	}

	public void makeAPlay(Input input, PlayTypeController playTypeController, Player actualPlayer, Players players,
			Box box, Board board, Deck deck) {
		view.askPlayType(model.getName());
		updateView();
		var play = setPlayType(input, playTypeController.getModel());
		play.play(input, actualPlayer, players, playTypeController.getView(), box, board, deck);
	}

	public Player getModel() {
		return model;
	}

	@Override
	public void updateView() {
		view.draw();
	}

}
