package fr.umlv.igm.hanabi;

import java.util.Scanner;

public class Data {
	private final Deck deck = new Deck();
	private final Players players = new Players();
	private final Scanner scan = new Scanner(System.in);

	public Deck getDeck() {
		return deck;
	}

	public Players getPlayers() {
		return players;
	}

	public void setPlayerName(int i) {
		players.setPlayerName(i, scan.next());
	}

	public void playerChoseTypeOfPlay() {
		int choice = scan.nextInt();
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
