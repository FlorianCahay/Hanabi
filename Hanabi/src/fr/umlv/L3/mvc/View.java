package fr.umlv.L3.mvc;

import java.util.ArrayList;

import fr.umlv.L3.classes.containers.Board;
import fr.umlv.L3.classes.containers.Box;
import fr.umlv.L3.classes.elements.Card;
import fr.umlv.L3.classes.others.Player;
import fr.umlv.L3.classes.playtype.PlayTypeList;

/**
 * 
 * Represent the game displayer.
 *
 */
public class View {

	/**
	 * Print each players.
	 * 
	 * @param players list of players to print
	 */
	public void drawPlayersHand(ArrayList<Player> players) {
		players.forEach(player -> System.out.println(player));
	}

	/**
	 * Print the specified box.
	 * @param box the box
	 */
	public void drawBox(Box box) {
		System.out.println(box);
	}

	/**
	 * Print board.
	 * 
	 * @param board Game board
	 */
	public void drawBoard(Board board) {
		System.out.println(board);
	}

	/**
	 * Print sentence asking for a name.
	 * 
	 * @param i which player
	 */
	public void drawAskName(int i) {
		drawSeparator();
		System.out.println("Player " + i + " write your name down :");
	}

	/**
	 * Print separator line.
	 */
	public void drawSeparator() {
		System.out.println("-----------------------------------------");
	}

	/**
	 * Print sentence asking for a card in player hand.
	 */
	public void drawAskCard() {
		drawSeparator();
		System.out.println("Which card do you want from your hand ? (write down card position, start at 1)");
	}

	/**
	 * Print sentence asking a player to chose his next play.
	 * 
	 * @param player player playing
	 * @param playTypes possible plays
	 */
	public void drawAskTypeOfPlay(Player player, PlayTypeList playTypes) {
		drawSeparator();
		System.out.println(player.getName() + " it is your turn now");
		drawPlayerHint(player);
		drawSeparator();
		System.out.println(playTypes);
		System.out.println(player.getName() + " Which play do you want to do write your choice number down :");
	}

	/**
	 * Print an error.
	 * 
	 * @param error string to add in the printed error
	 */
	public void drawError(String error) {
		System.out.println("ERROR : " + error);
	}

	/**
	 * Print error for type of play.
	 * 
	 * @param player player playing
	 * @param playTypes Possible plays
	 */
	public void drawErrorTypeOfPlay(Player player, PlayTypeList playTypes) {
		drawError("Type of play number must be an integer (1,2,3)");
		drawAskTypeOfPlay(player, playTypes);
	}

	/**
	 * Print error for card chose.
	 */
	public void drawErrorCardChose() {
		drawError("Write down number press enter then write down color in CAPITALS press enter");
		drawAskCard();
	}

	/**
	 * Print error for player doesn't exist.
	 */
	public void drawErrorPlayerDoesntExist() {
		drawError("The name you wrote is not an existing player");
	}

	/**
	 * Print error for card chose not in hand.
	 * 
	 * @param player actual player
	 */
	public void drawErrorCardChoseNotInHand(Player player) {
		drawError("Your hand doesn't contain the card you chose");
		drawPlayer(player);
		drawAskCard();
	}

	/**
	 * Print error for bad number of player.
	 */
	public void drawErrorNbPlayers() {
		drawError("min is 2 and max is 5");
		drawAskPlayers();
	}

	/**
	 * Print error for a bad play.
	 */
	public void drawErrortCantDoPlay() {
		drawError("you can't do this play");
	}

	/**
	 * Print sentence to show score.
	 * 
	 * @param points score at the end game
	 */
	public void drawEndGame(int points) {
		drawSeparator();
		System.out.println("The game is over you scored " + points + " points WELL PLAYED !!!");
	}

	/**
	 * Print player.
	 * 
	 * @param player player to show
	 */
	public void drawPlayer(Player player) {
		System.out.println(player);
	}

	/**
	 * Print the number of cards remaining.
	 * 
	 * @param deckSize deck to show
	 */
	public void drawDeck(int deckSize) {
		System.out.println("remaining cards in deck : " + deckSize);
	}

	/**
	 * Print a sentence asking for the number of players.
	 */
	public void drawAskPlayers() {
		drawSeparator();
		System.out.println("How many players are you write it down ? (min 2 and max 5) ");
	}

	/**
	 * Print a sentence asking for which player to give a hint.
	 */
	public void drawAskHint() {
		drawSeparator();
		System.out.println("To which player do you want to give a hint ?");
	}

	/**
	 * Print a sentence asking for the type hint to give.
	 */
	public void drawAskColorOrValue() {
		drawSeparator();
		System.out.println("1 : Color\n2 : Value\nWrite down what type of hint you want to give :");
	}

	/**
	 * Print a sentence asking for a card color.
	 */
	public void drawAskForColor() {
		drawSeparator();
		System.out.println("Write down an existing card color in CAPITALS :");
	}

	/**
	 * Print a sentence asking for a card value.
	 */
	public void drawAskForValue() {
		drawSeparator();
		System.out.println("Write down an existing card value :");
	}

	/**
	 * Print information that the card has been played.
	 * 
	 * @param card card to show
	 */
	public void drawPlayedCard(Card card) {
		System.out.println(card + " has been played");
	}

	/**
	 * Print information that the card has been discarded.
	 * 
	 * @param card card to show
	 */
	public void drawDiscardedCard(Card card) {
		System.out.println(card + " has been discarded");
	}

	/**
	 * Print player hint.
	 * 
	 * @param player player which we want to print hint
	 */
	public void drawPlayerHint(Player player) {
		System.out.println(player.readhint());
	}

	/**
	 * Print players, box and board.
	 * 
	 * @param data game data
	 */
	public void draw(Data data) {
		drawSeparator();
		drawPlayersHand(data.getPlayers());
		drawDeck(data.getDeckSize());
		drawBox(data.getBox());
		drawBoard(data.getBoard());
	}
}
