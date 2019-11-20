package fr.umlv.igm.hanabi;

import java.util.ArrayList;

public class Players {
	private final ArrayList<Player> players = new ArrayList<>();

	public void add(Player player) {
		players.add(player);
	}

	public void setPlayerName(int i, String name) {
		players.get(i).setName(name);
	}

	public String getPlayerName(int i) {
		return players.get(i).getName();
	}

	public int getPlayersSize() {
		return players.size();
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Player player : players) {
			str.append(player);
			str.append("\n");
		}
		return str.toString();
	}

}
