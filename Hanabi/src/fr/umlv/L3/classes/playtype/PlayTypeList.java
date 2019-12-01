package fr.umlv.L3.classes.playtype;

import java.util.SortedSet;
import java.util.TreeSet;

public class PlayTypeList {
	private final SortedSet<PlayType> types = new TreeSet<>();

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
			str.append(i);
			str.append(" : ");
			str.append(playType);
			str.append("\n");
			i++;
		}
		return str.toString();
	}
}
