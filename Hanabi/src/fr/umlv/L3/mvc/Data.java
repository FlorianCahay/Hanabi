package fr.umlv.L3.mvc;

import java.util.ArrayList;

import fr.umlv.L3.classes.cards.Card;
import fr.umlv.L3.classes.cards.Color;
import fr.umlv.L3.classes.containers.Board;
import fr.umlv.L3.classes.containers.Box;
import fr.umlv.L3.classes.hint.Hint;
import fr.umlv.L3.classes.hint.HintColor;
import fr.umlv.L3.classes.hint.HintValue;
import fr.umlv.L3.classes.others.Deck;
import fr.umlv.L3.classes.others.Player;
import fr.umlv.L3.classes.others.ScannerSystemIn;
import fr.umlv.L3.classes.others.Token;
import fr.umlv.L3.classes.playtype.PlayType;
import fr.umlv.L3.classes.playtype.PlayTypeList;

/**
 * 
 * Represent the data game manager.
 *
 */
public class Data {
	private final Board board = new Board();
	private final Box box = new Box();
	private final Deck deck = new Deck();
	private final ArrayList<Player> players = new ArrayList<>();
	private final ScannerSystemIn scanner = new ScannerSystemIn();
	private Player actualPlayer = null;
	private final PlayTypeList playTypes = new PlayTypeList();
	
	/**
	 * Get data board.
	 * 
	 * @return data board
	 */
	public Board getBoard() {
		return board;
	}

	/**
	 * Get data playTypes.
	 * 
	 * @return data playTypes
	 */
	public PlayTypeList getPlayTypes() {
		return playTypes;
	}

	/**
	 * Get data box.
	 * 
	 * @return data box
	 */
	public Box getBox() {
		return box;
	}

	/**
	 * Get data players.
	 * 
	 * @return data players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * Set data actual player.
	 * 
	 * @param actualPlayerIndex which player to get from players
	 */
	public void setActualPlayer(int actualPlayerIndex) {
		this.actualPlayer = players.get(actualPlayerIndex);
	}

	/**
	 * Get data deck size.
	 * 
	 * @return Data deck size
	 */
	public int getDeckSize() {
		return deck.getSize();
	}

	/**
	 * Get data actual player name.
	 * 
	 * @return data actual player name
	 */
	public String getActualPlayerName() {
		return actualPlayer.getName();
	}

	/**
	 * Get data actual player.
	 * 
	 * @return data actual player
	 */
	public Player getActualPlayer() {
		return actualPlayer;
	}

	/**
	 * Close the scanner.
	 */
	public void closeScanner() {
		scanner.close();
	}

	/**
	 * Get which type of play the player want to do.
	 * 
	 * @param view game view
	 * @return choice of the player
	 * @throws IllegalArgumentException if choice number is not include in [1,2]
	 */
	public PlayType playerChoseTypeOfPlay(View view) {
		int i = scanner.getValidInt("You can only chose a value from 1 to " + playTypes.size(), view, 1,
				playTypes.size());
		return playTypes.getPlayType(i);
	}

	/**
	 * Player discard the specified card in discarded cards.
	 * 
	 * @param card card to discard
	 * @param token token to move from board to box
	 */
	public void playerDiscardCard(Card card, Token token) {
		if (board.remove(token)) {
			box.add(token, 1);
		}
		actualPlayer.discardCard(card);
		actualPlayer.pickCardInDeck(deck);
		board.addDiscardedCard(card);
	}

	/**
	 * Player play the specified card on the board.
	 * 
	 * @param card card to play
	 * @return true if card is played, false if card is discarded
	 * 
	 */
	public boolean playerPlayCard(Card card) {
		if (board.isAddable(card)) {
			actualPlayer.discardCard(card);
			actualPlayer.pickCardInDeck(deck);
			board.addCard(card);
			return true;
		}
		playerDiscardCard(card, new Token(Color.RED));
		return false;
	}

	/**
	 * Create card base on input from user.
	 * 
	 * @param view game view
	 * @return new Card
	 */
	public Card inputCard(View view) {
		return scanner.getValidCardFromHand(view, actualPlayer);
	}

	/**
	 * Get a valid number of players.
	 * 
	 * @param view game view
	 * @return valid number of players
	 */
	public int inputNbPlayers(View view) {
		return scanner.getValidInt("This game can be played from 2 to 5 players", view, 2, 5);
	}

	/**
	 * Actual player give a hint to any player.
	 * 
	 * @param view game view
	 */
	public void giveHint(View view) {
		var player = scanner.getValidPlayer(view, players, actualPlayer);
		view.drawAskColorOrValue();
		var choice = scanner.getValidInt("You can only give hint about color or value", view, 1, 2);
		Hint hint;
		if (choice == 1) {
			view.drawAskForColor();
			hint = new HintColor(scanner.getValidColor(view));
		} else {
			view.drawAskForValue();
			hint = new HintValue(scanner.getValidInt("Card value has to be include in [1,5]", view, 1, 5));
		}
		player.setHint(hint);
		var token = new Token(Color.BLUE);
		if (box.remove(token)) {
			board.add(token, 1);
		}
	}

	/**
	 * Test if the game is over.
	 * 
	 * @return True if the game is over, False otherwise
	 */
	public boolean gameOver() {
		return board.gameOver(deck);
	}

	/**
	 * Get score from board.
	 * 
	 * @return score
	 */
	public int getScore() {
		return board.getScore();
	}

	/**
	 * Reset the playTypes list and add possible plays.
	 */
	public void setPlayTypes() {
		playTypes.clear();
		if (board.getNumberBlueToken() > 0) {
			playTypes.add(PlayType.DISCARD);
		}
		if (box.getNumberBlueToken() > 0) {
			playTypes.add(PlayType.HINT);
		}

	}

	/**
	 * Add a player to players list.
	 * 
	 * @param view game view
	 * @param nbPlayers number of playing players
	 * @return true if player is added, false otherwise
	 */
	public boolean addPlayer(View view, int nbPlayers) {
		var name = scanner.getValidString("Your name as to be a string of at least 1 character", view);
		for (Player player : players) {
			if (player.getName().equals(name)) {
				view.drawError("The name you wrote already exists");
				return false;
			}
		}
		players.add(new Player(name, deck, nbPlayers));
		return true;
	}
}
