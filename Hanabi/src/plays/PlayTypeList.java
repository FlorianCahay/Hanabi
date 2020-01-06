package plays;

import java.util.HashSet;
import java.util.Set;

public class PlayTypeList {
	private final Set<PlayType> types = new HashSet<>();

	public PlayTypeList() {
		types.add(PlayType.PLAY);
	}

	public void add(PlayType type) {
		types.add(type);
	}

	public void clear() {
		types.remove(PlayType.HINT);
		types.remove(PlayType.DISCARD);
	}

	public int size() {
		return types.size();
	}

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
