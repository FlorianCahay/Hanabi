package fr.umlv.igm.hanabi.mvc;

import fr.umlv.igm.hanabi.classes.Board;
import fr.umlv.igm.hanabi.classes.Box;
import fr.umlv.igm.hanabi.classes.Players;

public class View {
	public void drawPlayersHand(Players players) {
		System.out.println(players);
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
		System.out.println("Which card do you want to discard from your hand ? (write down the index of the card)");
	}

	public void drawAskCardToPlay() {
		System.out.println("Which card do you want to play from your hand ? (write down the index of the card)");
	}

	public void drawTypeOfPlay(String playerName) {
		System.out.println("1 : Discard a card\n2 : Play a Card\n" + playerName + " write your choice number down :");
	}

	public void draw(Data data) {
		drawPlayersHand(data.getPlayers());
		drawBox(data.getBox());
		drawBoard(data.getBoard());
	}
}