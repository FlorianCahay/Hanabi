package fr.umlv.L3.mvc;

import java.util.ArrayList;

import fr.umlv.L3.classes.containers.Board;
import fr.umlv.L3.classes.containers.Box;
import fr.umlv.L3.classes.others.Player;

/**
 * 
 * Represent the game displayer
 *
 */
public class View {

	/**
	 * Print each players
	 * 
	 * @param players list of players to print
	 */
	public void drawPlayersHand(ArrayList<Player> players) {
		players.forEach(player -> System.out.println(player));
	}

	/*
	 * Print box
	 */
	public void drawBox(Box box) {
		System.out.println(box);
	}

	/**
	 * Print board
	 * 
	 * @param board Game board
	 */
	public void drawBoard(Board board) {
		System.out.println(board);
	}

	/**
	 * Print sentence asking for a name
	 * 
	 * @param i which player
	 */
	public void drawAskName(int i) {
		System.out.println("Player " + i + " write your name down :");
	}

	/**
	 * Print separator line
	 */
	public void drawSeparator() {
		System.out.println("-----------------------------------------");
	}

	/**
	 * Print sentence asking for a card in player hand
	 */
	public void drawAskCard() {
		System.out.println(
				"Which card do you want from your hand ? (write down number press enter then write down color in CAPITALS press enter)");
	}

	/**
	 * Print sentence asking a player to chose his next play
	 * 
	 * @param playerName name of the actual player
	 */
	public void drawTypeOfPlay(String playerName) {
		System.out.println("1 : Discard a card\n2 : Play a Card\n" + playerName + " write your choice number down :");
	}

	/**
	 * Print error for type of play
	 * 
	 * @param playerName Actual player name
	 */
	public void drawErrorTypeOfPlay(String playerName) {
		System.out.println("ERROR : Type of play number must be an integer (1 or 2)");
		drawTypeOfPlay(playerName);
	}

	/**
	 * Print error for card chose
	 */
	public void drawErrorCardChose() {
		System.out.println("ERROR : Write down number press enter then write down color in CAPITALS press enter");
		drawAskCard();
	}

	/**
	 * Print error for card chose not in hand
	 * 
	 * @param player Actual player
	 */
	public void drawErrorCardChoseNotInHand(Player player) {
		System.out.println("ERROR : Your hand doesn't contain the card you chose");
		drawPlayer(player);
		drawAskCard();
	}

	/**
	 * Print sentence to show score
	 * 
	 * @param points score at the end game
	 */
	public void drawEndGame(int points) {
		System.out.println("The game is over you scored " + points + " points WELL PLAYED !!!");
	}

	/**
	 * Print player
	 * 
	 * @param player Player to show
	 */
	public void drawPlayer(Player player) {
		System.out.println(player);
	}

	/**
	 * Print deck
	 * 
	 * @param deckSize Deck to show
	 */
	public void drawDeck(int deckSize) {
		System.out.println("remaining cards in deck : " + deckSize);
	}

	/**
	 * Print players, box and board
	 * 
	 * @param data Game data
	 */
	public void draw(Data data) {
		drawPlayersHand(data.getPlayers());
		drawDeck(data.getDeckSize());
		drawBox(data.getBox());
		drawBoard(data.getBoard());

	}
}
