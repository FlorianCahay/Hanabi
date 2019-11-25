package fr.umlv.L3.mvc;

import java.util.ArrayList;
import java.util.Scanner;

import fr.umlv.L3.classes.Board;
import fr.umlv.L3.classes.Box;
import fr.umlv.L3.classes.Card;
import fr.umlv.L3.classes.Color;
import fr.umlv.L3.classes.Deck;
import fr.umlv.L3.classes.Player;
import fr.umlv.L3.classes.Token;

public class Data {
	private final Board board = new Board();
	private final Box box = new Box();
	private final Deck deck = new Deck();
	private final ArrayList<Player> players = new ArrayList<>();
	private final Scanner scanner = new Scanner(System.in);
	private Player actualPlayer = null;

	public Board getBoard() {
		return board;
	}

	public Box getBox() {
		return box;
	}

	public ArrayList<Player> getPlayers() {
		return players;
	}

	public void setActualPlayer(int actualPlayerIndex) {
		this.actualPlayer = players.get(actualPlayerIndex);
	}

	public String getActualPlayerName() {
		return actualPlayer.getName();
	}

	public int playerChoseTypeOfPlay() {
		if (!scanner.hasNextInt()) {
			scanner.next();
			throw new IllegalStateException("choice number must be a integer of 1 or 2");
		}
		int choice = scanner.nextInt();
		if (choice == 1 || choice == 2) {
			return choice;
		}
		throw new IllegalStateException("choice number must be a integer of 1 or 2");
	}

	public void playerDiscardCard(Card card) {
		Token token = new Token(Color.BLUE);
		board.remove(token);
		box.add(token, 1);
		actualPlayer.discardCard(card);
		actualPlayer.pickCardInDeck(deck);
	}

	public void playerPlayCard(Card card) {
		if (board.isAddable(card)) {
			actualPlayer.discardCard(card);
			actualPlayer.pickCardInDeck(deck);
			board.addCard(card);
			return;
		}
		Token token = new Token(Color.RED);
		board.remove(token);
		box.add(token, 1);
		actualPlayer.discardCard(card);
		actualPlayer.pickCardInDeck(deck);
	}

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
		int value = 0;
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

	public boolean playerHasCard(Card card) {
		return actualPlayer.handContains(card);
	}

	public boolean gameOver() {
		return board.gameOver(deck);
	}

	public int getScore() {
		return board.getScore();
	}

	public void addPlayer() {
		String name;
		name = scanner.next();
		players.add(new Player(name, deck));
	}
}
