package mvc;

import java.util.Iterator;

import board.Board;
import board.BoardController;
import board.BoardViewGraphic;
import board.BoardViewTerminal;
import cards.CardViewGraphic;
import cards.Deck;
import cards.DeckController;
import cards.DeckViewGraphic;
import cards.DeckViewTerminal;
import cards.HandViewGraphic;
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
import tokens.TokenViewGraphic;

/**
 * Represents an interface to manage the whole program
 * 
 * @author Cahay-Durand
 *
 */
public class Controller {

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
		var result = new String();
		System.out.println("Write \"T\" for terminal or write \"G\" for graphic view : ");
		for (;;) {
			result = input.getValidString(null);
			if (result.equals("G")) {
				input.close();
				Application.run(java.awt.Color.WHITE, Controller::graphic);
				break;
			} else if (result.equals("T")) {
				playGame();
				break;
			} else {
				System.out.println("You must write \"T\" or \"G\"");
			}
		}
	}

	/**
	 * Launch the graphic game
	 * 
	 * @param context Application context
	 */
	private static void graphic(ApplicationContext context) {
		CardViewGraphic cardView = new CardViewGraphic(context);
		TokenViewGraphic tokenView = new TokenViewGraphic(context);
		HandViewGraphic handView = new HandViewGraphic(context, cardView);
		input = new MouseSelector(context, handView);
		playersController = new PlayersController(new Players(), new PlayersViewGraphic(context, handView));
		deckController = new DeckController(new Deck(), new DeckViewGraphic(context, cardView));
		boxController = new BoxController(new Box(Color.BLUE), new BoxViewGraphic(context, tokenView));
		boardController = new BoardController(new Board(), new BoardViewGraphic(context, tokenView, cardView));
		actualPlayerController = new PlayerController(null, new PlayerViewGraphic(context));
		playTypeController = new PlayTypeController(new PlayTypeList(), new PlayTypeViewGraphic(context));
		playGame();
	}

	/**
	 * It Plays the game
	 */
	private static void playGame() {
		numberPlayers = playersController.setPlayersNumber(input);
		playersController.setPlayersName(numberPlayers, input, deckController.getModel());
		playersIterator = playersController.playersIterator();
		var quit = false;
		while (!quit) {
			actualPlayerController.setPlayer(playersIterator.next());
			showGame(actualPlayerController, numberPlayers);
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

	/**
	 * Draws game elements
	 * 
	 * @param actualPlayerController Actual player controller
	 * @param numberPlayers          Number of players
	 */
	private static void showGame(PlayerController actualPlayerController, int numberPlayers) {
		playersController.showPlayersCards(actualPlayerController.getModel(), numberPlayers);
		deckController.showRemainingCards();
		boxController.showBox();
		boardController.showBoard();
	}

}
