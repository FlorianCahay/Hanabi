package fr.umlv.L3.mvc;

import java.util.ArrayList;
import java.util.Scanner;

import fr.umlv.L3.classes.containers.Board;
import fr.umlv.L3.classes.containers.Box;
import fr.umlv.L3.classes.elements.Card;
import fr.umlv.L3.classes.elements.Color;
import fr.umlv.L3.classes.elements.Token;
import fr.umlv.L3.classes.others.Deck;
import fr.umlv.L3.classes.others.Player;

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
	private final Scanner scanner = new Scanner(System.in);
	private Player actualPlayer = null;

	/**
	 * get data board
	 * 
	 * @return data board
	 */
	public Board getBoard() {
		return board;
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
	public int playerChoseTypeOfPlay() {
		if (!scanner.hasNextInt()) {
			scanner.next();
			throw new IllegalStateException("choice number must be a integer of 1 or 2");
		}
		var choice = scanner.nextInt();
		if (choice == 1 || choice == 2) {
			return choice;
		}
		throw new IllegalStateException("choice number must be a integer of 1 or 2");
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
	public Card inputCard() {
		return new Card(inputValueCard(), inputColorCard());
	}

	private Color inputColorCard() {
		switch (scanner.next()) {
		case "RED":
			return Color.RED;
		case "BLUE":
			return Color.BLUE;
		case "YELLOW":
			return Color.YELLOW;
		case "WHITE":
			return Color.WHITE;
		case "GREEN":
			return Color.GREEN;
		default:
			throw new IllegalStateException(
					"Color string must be in capitals and be an existing color of the fireworks");
		}
	}

	private int inputValueCard() {
		var value = 0;
		if (!scanner.hasNextInt()) {
			scanner.next();
			throw new IllegalStateException("card value must be an integer between [1,5]");
		}
		value = scanner.nextInt();
		if (value < 1 || value > 5) {
			throw new IllegalStateException("card value must be an integer between [1,5]");
		}
		return value;
	}

	/**
	 * Test if player hand has the card
	 * 
	 * @param card Card to test
	 * @return True if card contained in player hand, False otherwise
	 */
	public boolean playerHasCard(Card card) {
		return actualPlayer.handContains(card);
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

	/**
	 * add a player to players list
	 */
	public void addPlayer() {
		players.add(new Player(scanner.next(), deck));
	}
}
