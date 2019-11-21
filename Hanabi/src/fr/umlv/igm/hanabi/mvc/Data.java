package fr.umlv.igm.hanabi.mvc;

import java.util.Scanner;

import fr.umlv.igm.hanabi.classes.Board;
import fr.umlv.igm.hanabi.classes.Box;
import fr.umlv.igm.hanabi.classes.Card;
import fr.umlv.igm.hanabi.classes.Color;
import fr.umlv.igm.hanabi.classes.Player;
import fr.umlv.igm.hanabi.classes.Players;
import fr.umlv.igm.hanabi.classes.Token;
import fr.umlv.igm.hanabi.classes.cards.Deck;
import fr.umlv.igm.hanabi.classes.cards.Hand;

public class Data {
	private final Deck deck = new Deck();
	private final Box box = new Box(8, 0);
	private final Board board = new Board();
	private final Players players = new Players();
	private final Scanner scan = new Scanner(System.in);

	public Deck getDeck() {
		return deck;
	}

	public Players getPlayers() {
		return players;
	}

	public Box getBox() {
		return box;
	}

	public Board getBoard() {
		return board;
	}

	public void setPlayerName(int i) {
		players.setPlayerName(i, scan.next());
	}

	public int playerChoseTypeOfPlay() {
		int choice;
		while (true) {
			choice = scan.nextInt();
			if (choice == 1 && box.getNumberBlueToken() < 8) {
				return 1;
			}
			if (choice == 2) {
				return 2;
			}
		}
	}

	public Card playerDiscardCard(int indexPlayer) {
		int indexCard = 0;
		Player player = players.getPlayer(indexPlayer);
		while (indexCard < 1 || indexCard > player.getSizeHand() + 1) {
			indexCard = scan.nextInt();
		}
		board.remove(new Token(Color.BLUE));
		box.add(new Token(Color.BLUE));
		return players.getPlayer(indexPlayer).playCard(indexCard - 1, board);
	}

	public void initialisePlayers(int nbPlayers) {
		int nbCards = 5;
		if (nbPlayers > 3 && nbPlayers < 6) {
			nbCards = 4;
		}
		for (int i = 0; i < nbPlayers; i++) {
			players.add(new Player(new Hand(deck, nbCards)));
		}
	}

	/**
	 * Updates the data contained in the GameData.
	 */
	public void updateData() {

	}
}
