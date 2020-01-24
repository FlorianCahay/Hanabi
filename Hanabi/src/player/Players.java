package player;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Represents a list of players
 * 
 * @author Cahay-Durand
 *
 */
public class Players {
	private static final int minPlayers = 2;
	private static final int maxPlayers = 5;
	private final Set<Player> players = new HashSet<>();

	/**
	 * Adds a player if not existing
	 * 
	 * @param newPlayer Player to add
	 * @return True if the has been added, false otherwise
	 */
	public boolean add(Player newPlayer) {
		for (Player player : players) {
			if (player.equals(newPlayer)) {
				return false;
			}
		}
		players.add(newPlayer);
		return true;
	}

	/**
	 * Gets the players list iterator
	 * 
	 * @return Players iterator
	 */
	public Iterator<Player> getIterator() {
		return players.iterator();
	}

	/**
	 * Test if name is not an existing player
	 * 
	 * @param name Player name
	 * @return True the name is not an existing player, false otherwise
	 */
	public boolean isNewPlayer(String name) {
		for (Player player : players) {
			if (player.getName().equals(name)) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Gets a player which is not the playing player
	 * 
	 * @param name         Player name
	 * @param actualPlayer Playing player
	 * @return Player
	 * @throws IllegalStateException If the player name doesn't exist
	 */
	public Player getPlayer(String name, Player actualPlayer) {
		for (Player player : players) {
			if (player.getName().equals(name) && !actualPlayer.getName().equals(name)) {
				return player;
			}
		}
		throw new IllegalStateException("this player doesn't exist");
	}

	/**
	 * Gets the minimum number of players
	 * 
	 * @return minPlayers
	 */
	public static int getMinPlayers() {
		return minPlayers;
	}

	/**
	 * Gets the maximum number of players
	 * 
	 * @return maxPlayers
	 */
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
