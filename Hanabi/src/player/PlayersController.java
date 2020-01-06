package player;

import java.util.Iterator;

import cards.Deck;
import cards.Hand;
import input.Input;
import mvc.Controller;

public class PlayersController implements Controller {
	private final Players model;
	private final PlayersView view;

	public PlayersController(Players players, PlayersView view) {
		this.model = players;
		this.view = view;
	}

	private int inputNumberOfPlayers(Input input) {
		return input.getValidInt("This game can be played from " + Players.getMinPlayers() + " to "
				+ Players.getMaxPlayers() + " players", Players.getMinPlayers(), Players.getMaxPlayers());
	}

	public int setPlayersNumber(Input input) {
		view.askPlayersNumber();
		updateView();
		return inputNumberOfPlayers(input);
	}

	public void inputPlayerName(Input input, Hand hand) {
		model.add(new Player(input.getValidPlayer(model), hand));
	}

	public void setPlayersName(int numberPlayers, Input input, Deck deck) {
		int nbCards = 5;
		if (numberPlayers > 3) {
			nbCards = 4;
		}
		for (int i = 0; i < numberPlayers; i++) {
			view.askPlayerName(i);
			updateView();
			inputPlayerName(input, new Hand(deck, nbCards));
		}
	}

	public void showPlayersCards() {
		view.showPlayersCards(model);
		updateView();
	}

	public Iterator<Player> playersIterator() {
		return model.getIterator();
	}

	public Players getModel() {
		return model;
	}

	public void updateView() {
		view.draw();
	}

}
