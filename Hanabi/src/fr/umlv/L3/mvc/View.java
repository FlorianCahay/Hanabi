package fr.umlv.L3.mvc;

import java.util.ArrayList;

import fr.umlv.L3.classes.Board;
import fr.umlv.L3.classes.Box;
import fr.umlv.L3.classes.Player;

public class View {
	public void drawPlayersHand(ArrayList<Player> players) {
		players.forEach(player -> System.out.println(player));
	}

	public void drawBox(Box box) {
		System.out.println(box);
	}

	public void drawBoard(Board board) {
		System.out.println(board);
	}

	public void drawAskName(int i) {
		System.out.println("Player " + i + " write your name down :");
	}

	public void drawSeparator() {
		System.out.println("-----------------------------------------");
	}

	public void drawAskCardToDiscard() {
		System.out.println(
				"Which card do you want to discard from your hand ? (write down number press enter then write down color in CAPITALS press enter)");
	}

	public void drawAskCardToPlay() {
		System.out.println(
				"Which card do you want to play from your hand ? (write down number press enter then write down color in CAPITALS press enter)");
	}

	public void drawTypeOfPlay(String playerName) {
		System.out.println("1 : Discard a card\n2 : Play a Card\n" + playerName + " write your choice number down :");
	}

	public void drawErrorTypeOfPlay() {
		System.out.println("ERROR : Type of play number must be an integer(1 or 2)");
	}

	public void drawErrorCardChose() {
		System.out.println("ERROR : Write down number press enter then write down color in CAPITALS press enter");
	}

	public void drawErrorCardChoseNotInHand() {
		System.out.println("ERROR : Your hand doesn't contain the card you chose");
	}

	public void drawEndGame(int points) {
		System.out.println("The game is over you scored " + points + " points WELL PLAYED !!!");
	}

	public void draw(Data data) {
		drawPlayersHand(data.getPlayers());
		drawBox(data.getBox());
		drawBoard(data.getBoard());
	}
}
