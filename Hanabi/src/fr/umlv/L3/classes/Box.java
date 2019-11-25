package fr.umlv.L3.classes;

import java.util.HashMap;

public class Box {
	private final HashMap<Token, Integer> box = new HashMap<>();

	public Box(int blueToken, int redToken) {
		add(new Token(Color.BLUE), blueToken);
		add(new Token(Color.RED), redToken);
	}

	public Box() {
		this(8, 0);
	}

	public void add(Token token, int value) {
		box.computeIfPresent(token, (k, v) -> v + value);
		box.computeIfAbsent(token, k -> value);
	}

	public void remove(Token token) {
		if (!box.containsKey(token)) {
			throw new IllegalStateException("box doesn't contain your token");
		}
		if (box.get(token) == 0) {
			box.remove(token);
		}
		box.computeIfPresent(token, (k, v) -> v - 1);
	}

	private int getNumberToken(Token token) {
		if (!box.containsKey(token)) {
			return 0;
		}
		return box.get(token);
	}

	public int getNumberBlueToken() {
		return getNumberToken(new Token(Color.BLUE));
	}

	public int getNumberRedToken() {
		return getNumberToken(new Token(Color.RED));
	}

	public String typeOfBox() {
		return "Box";
	}

	@Override
	public String toString() {
		return typeOfBox() + " contains " + getNumberBlueToken() + " blue tokens and " + getNumberRedToken()
				+ " red tokens";
	}
}
