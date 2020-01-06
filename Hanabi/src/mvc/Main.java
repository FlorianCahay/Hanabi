package mvc;

import java.util.Iterator;

import board.Board;
import board.BoardController;
import board.BoardViewTerminal;
import cards.Deck;
import cards.DeckController;
import cards.DeckViewTerminal;
import colors.Color;
import input.Input;
import input.ScannerSystemIn;
import player.Player;
import player.PlayerController;
import player.PlayerViewTerminal;
import player.Players;
import player.PlayersController;
import player.PlayersViewTerminal;
import plays.PlayTypeController;
import plays.PlayTypeList;
import plays.PlayTypeViewTerminal;
import tokens.Box;
import tokens.BoxController;
import tokens.BoxViewTerminal;

public class Main {
	private final static Input input = new ScannerSystemIn();
	private final static PlayersController playersController = new PlayersController(new Players(),
			new PlayersViewTerminal());
	private final static DeckController deckController = new DeckController(new Deck(), new DeckViewTerminal());
	private final static BoxController boxController = new BoxController(new Box(Color.BLUE), new BoxViewTerminal());
	private final static BoardController boardController = new BoardController(new Board(), new BoardViewTerminal());
	private final static PlayerController actualPlayerController = new PlayerController(null, new PlayerViewTerminal());
	private final static PlayTypeController playTypeController = new PlayTypeController(new PlayTypeList(),
			new PlayTypeViewTerminal());
	private static int numberPlayers = 0;
	private static Iterator<Player> playersIterator = null;

	public static void main(String[] args) {
		numberPlayers = playersController.setPlayersNumber(input);
		playersController.setPlayersName(numberPlayers, input, deckController.getModel());
		playersIterator = playersController.playersIterator();
		var quit = false;
		while (!quit) {
			showGame();
			actualPlayerController.setPlayer(playersIterator.next());
			actualPlayerController.showPlayer();
			playTypeController.showPossiblePlays(boxController.getModel(), boardController.getModel());
			actualPlayerController.makeAPlay(input, playTypeController, actualPlayerController.getModel(),
					playersController.getModel(), boxController.getModel(), boardController.getModel(),
					deckController.getModel());
			if (!playersIterator.hasNext()) {
				playersIterator = playersController.playersIterator();
			}
			quit = boardController.gameOver(deckController.getModel());
		}
		input.close();
	}

	private static void showGame() {
		playersController.showPlayersCards();
		deckController.showRemainingCards();
		boxController.showBox();
		boardController.showBoard();
	}

}
