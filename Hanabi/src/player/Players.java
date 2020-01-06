package player;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Players {
	private static final int minPlayers = 2;
	private static final int maxPlayers = 5;
	private final Set<Player> players = new HashSet<>();

	public boolean add(Player newPlayer) {
		for (Player player : players) {
			if (player.equals(newPlayer)) {
				return false;
			}
		}
		players.add(newPlayer);
		return true;
	}

	public Iterator<Player> getIterator() {
		return players.iterator();
	}

	public boolean isNewPlayer(String name) {
		for (Player player : players) {
			if (player.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}

	public Player getPlayer(String name, Player actualPlayer) {
		for (Player player : players) {
			if (player.getName().equals(name) && !actualPlayer.getName().equals(name)) {
				return player;
			}
		}
		throw new IllegalStateException("this player doesn't exist");
	}

	public static int getMinPlayers() {
		return minPlayers;
	}

	public static int getMaxPlayers() {
		return maxPlayers;
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		for (Player player : players) {
			str.append(player).append("\n");
		}
		return str.toString().substring(0, str.length() - 1);
	}
}
