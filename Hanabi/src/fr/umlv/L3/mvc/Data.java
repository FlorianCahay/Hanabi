package fr.umlv.L3.mvc;

import java.util.ArrayList;

import fr.umlv.L3.classes.containers.Board;
import fr.umlv.L3.classes.containers.Box;
import fr.umlv.L3.classes.elements.Card;
import fr.umlv.L3.classes.elements.Color;
import fr.umlv.L3.classes.elements.Token;
import fr.umlv.L3.classes.hint.Hint;
import fr.umlv.L3.classes.hint.HintColor;
import fr.umlv.L3.classes.hint.HintValue;
import fr.umlv.L3.classes.others.Deck;
import fr.umlv.L3.classes.others.Player;
import fr.umlv.L3.classes.others.ScannerSystemIn;
import fr.umlv.L3.classes.playtype.PlayType;
import fr.umlv.L3.classes.playtype.PlayTypeList;

/**
 * 
 * Represent the data game manager
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
	 * get data board
	 * 
	 * @return data board
	 */
	public Board getBoard() {
		return board;
	}

	public PlayTypeList getPlayTypes() {
		return playTypes;
	}

	/**
	 * get data box
	 * 
	 * @return data box
	 */
	public Box getBox() {
		return box;
	}

	/**
	 * get data players
	 * 
	 * @return data players
	 */
	public ArrayList<Player> getPlayers() {
		return players;
	}

	/**
	 * set data actual player
	 * 
	 * @param actualPlayerIndex which player to get from players
	 */
	public void setActualPlayer(int actualPlayerIndex) {
		this.actualPlayer = players.get(actualPlayerIndex);
	}

	/**
	 * Get data deck size
	 * 
	 * @return Data deck size
	 */
	public int getDeckSize() {
		return deck.getSize();
	}

	/**
	 * get data actual player name
	 * 
	 * @return data actual player name
	 */
	public String getActualPlayerName() {
		return actualPlayer.getName();
	}

	/**
	 * get data actual player
	 * 
	 * @return data actual player
	 */
	public Player getActualPlayer() {
		return actualPlayer;
	}

	/**
	 * get which type of play the player want to do
	 * 
	 * @return choice of the player
	 * @throws IllegalArgumentException if choice number is not include in [1,2]
	 */
	public PlayType playerChoseTypeOfPlay(View view) {
		int i = scanner.getValidInt("You can only chose a value from 1 to " + playTypes.size(), view, 1,
				playTypes.size());
		return playTypes.getPlayType(i);
	}

	/**
	 * player discard a card in discarded cards
	 * 
	 * @param card  Card to discard
	 * @param token Token to move from board to box
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
	 * player play card on board
	 * 
	 * @param card Card to play
	 * 
	 */
	public void playerPlayCard(Card card) {
		if (board.isAddable(card)) {
			actualPlayer.discardCard(card);
			actualPlayer.pickCardInDeck(deck);
			board.addCard(card);
			return;
		}
		playerDiscardCard(card, new Token(Color.RED));
	}

	/**
	 * create card base on input from user
	 * 
	 * @return new Card
	 */
	public Card inputCard(View view) {
		return scanner.getValidCardFromHand(view, actualPlayer);
	}

	public int inputNbPlayers(View view) {
		return scanner.getValidInt("This game can be played from 2 to 5 players", view, 2, 5);
	}

	public void giveHint(View view) {
		var player = scanner.getValidPlayer(view, players);
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
	 * Test if the game is over
	 * 
	 * @return True if the game is over, False otherwise
	 */
	public boolean gameOver() {
		return board.gameOver(deck);
	}

	/**
	 * get score from board
	 * 
	 * @return score
	 */
	public int getScore() {
		return board.getScore();
	}

	public void setPlayTypes() {
		playTypes.clear();
		if (box.getNumberBlueToken() > 0) {
			playTypes.add(PlayType.HINT);
		}
		if (board.getNumberBlueToken() > 0) {
			playTypes.add(PlayType.DISCARD);
		}
	}

	/**
	 * add a player to players list
	 */
	public void addPlayer(View view, int nbPlayers) {
		players.add(new Player(scanner.getValidString("Your name as to be a string of at least 1 character", view),
				deck, nbPlayers));
	}
}
