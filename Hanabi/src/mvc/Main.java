package mvc;

import java.util.Iterator;

import board.Board;
import board.BoardController;
import board.BoardViewGraphic;
import board.BoardViewTerminal;
import cards.Deck;
import cards.DeckController;
import cards.DeckViewGraphic;
import cards.DeckViewTerminal;
import colors.Color;
import fr.umlv.zen5.Application;
import fr.umlv.zen5.ApplicationContext;
import input.Input;
import input.MouseSelector;
import input.ScannerSystemIn;
import player.Player;
import player.PlayerController;
import player.PlayerViewGraphic;
import player.PlayerViewTerminal;
import player.Players;
import player.PlayersController;
import player.PlayersViewGraphic;
import player.PlayersViewTerminal;
import plays.PlayTypeController;
import plays.PlayTypeList;
import plays.PlayTypeViewGraphic;
import plays.PlayTypeViewTerminal;
import tokens.Box;
import tokens.BoxController;
import tokens.BoxViewGraphic;
import tokens.BoxViewTerminal;

public class Main {

	private static Input input = new ScannerSystemIn();
	private static PlayersController playersController = new PlayersController(new Players(),
			new PlayersViewTerminal());
	private static DeckController deckController = new DeckController(new Deck(), new DeckViewTerminal());
	private static BoxController boxController = new BoxController(new Box(Color.BLUE), new BoxViewTerminal());
	private static BoardController boardController = new BoardController(new Board(), new BoardViewTerminal());
	private static PlayerController actualPlayerController = new PlayerController(null, new PlayerViewTerminal());
	private static PlayTypeController playTypeController = new PlayTypeController(new PlayTypeList(),
			new PlayTypeViewTerminal());

	private static int numberPlayers = 0;
	private static Iterator<Player> playersIterator = null;

	public static void main(String[] args) {
		var graphic = false; // true for graphic and false for terminal
		if (graphic) {
			Application.run(java.awt.Color.WHITE, Main::graphic);
		} else {
			playGame();
		}
	}

	private static void graphic(ApplicationContext context) {
		input = new MouseSelector();
		playersController = new PlayersController(new Players(), new PlayersViewGraphic(context));
		deckController = new DeckController(new Deck(), new DeckViewGraphic(context));
		boxController = new BoxController(new Box(Color.BLUE), new BoxViewGraphic(context));
		boardController = new BoardController(new Board(), new BoardViewGraphic(context));
		actualPlayerController = new PlayerController(null, new PlayerViewGraphic(context));
		playTypeController = new PlayTypeController(new PlayTypeList(), new PlayTypeViewGraphic(context));
		playGame();
	}

	private static void playGame() {
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
