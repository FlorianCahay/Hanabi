package plays;

import java.util.HashSet;
import java.util.Set;

/**
 * Represents a list of possible plays
 * 
 * @author Cahay-Durand
 *
 */
public class PlayTypeList {
	private final Set<PlayType> types = new HashSet<>();

	/**
	 * Constructs play type list with PlayType.PLAY
	 */
	public PlayTypeList() {
		types.add(PlayType.PLAY);
	}

	/**
	 * Adds a play type
	 * 
	 * @param type Play to add
	 */
	public void add(PlayType type) {
		types.add(type);
	}

	/**
	 * Removes hint play and discard play
	 */
	public void clear() {
		types.remove(PlayType.HINT);
		types.remove(PlayType.DISCARD);
	}

	/**
	 * Gets play type list size
	 * 
	 * @return list size
	 */
	public int size() {
		return types.size();
	}

	/**
	 * Gets play type by index
	 * 
	 * @param indexPlay Play type index
	 * @return Corresponding play type
	 * @throws IllegalStateException If index superior than list size
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
			str.append(i).append(" : ");
			str.append(playType).append("\n");
			i++;
		}
		return str.toString();
	}
}
