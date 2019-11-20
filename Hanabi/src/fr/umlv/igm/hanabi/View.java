package fr.umlv.igm.hanabi;

public class View {
	public void drawPlayersHand(Players players) {
		System.out.println(players);
	}

	public void drawAskName(int i) {
		System.out.println("Player " + i + " write your name down :");
	}

	public void drawTypeOfPlay(String playerName) {
		System.out.println("1 : Discard a card\n2 : Play a Card\n" + playerName + " write your choice number down :");
	}

	public void draw(Data data) {
		drawPlayersHand(data.getPlayers());
	}
}