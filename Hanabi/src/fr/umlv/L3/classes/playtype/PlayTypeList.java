package fr.umlv.L3.classes.playtype;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * 
 * Represent a set of the possible plays
 *
 */
public class PlayTypeList {
	private final SortedSet<PlayType> types = new TreeSet<>();

	/**
	 * Constructor initializing the list of play with the "PLAY"
	 */
	public PlayTypeList() {
		types.add(PlayType.PLAY);
	}

	/**
	 * Add a play to the play list
	 * 
	 * @param type Play type to add
	 */
	public void add(PlayType type) {
		types.add(type);
	}

	/**
	 * Remove "HINT" and "DISCARD" plays
	 */
	public void clear() {
		types.remove(PlayType.HINT);
		types.remove(PlayType.DISCARD);
	}

	/**
	 * Get size of the play list
	 * 
	 * @return play list size
	 */
	public int size() {
		return types.size();
	}

	/**
	 * Get a play type from an index value
	 * 
	 * @param indexPlay index of value of the play in the list
	 * @return corresponding play type
	 * @throws IllegalStateException if indexPlay is not a valid index in the play
	 *                               list
	 */
	public PlayType getPlayType(int indexPlay) {
		int i = 1;
		for (PlayType playType : types) {
			if (i == indexPlay) {
				return playType;
			}
			i++;
		}
		throw new IllegalStateException("The playTypeList doesn't contain that much elements");
	}

	@Override
	public String toString() {
		int i = 1;
		StringBuilder str = new StringBuilder();
		for (PlayType playType : types) {
			str.append(i);
			str.append(" : ");
			str.append(playType);
			str.append("\n");
			i++;
		}
		return str.toString();
	}
}
