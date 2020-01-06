package tokens;

import java.util.HashMap;

import colors.Color;

public class Box {
	private final HashMap<Token, Integer> box = new HashMap<>();

	public Box(Color color) {
		if (color.equals(Color.BLUE)) {
			add(new Token(Color.BLUE), 8);
		} else if (color.equals(Color.RED)) {
			add(new Token(Color.RED), 3);
		}
	}

	public void add(Token token, int value) {
		box.computeIfPresent(token, (k, v) -> v + value);
		box.computeIfAbsent(token, k -> value);
	}

	public boolean remove(Token token) {
		if (box.get(token) == 0) {
			return false;
		}
		box.computeIfPresent(token, (k, v) -> v - 1);
		return true;
	}

	public int getNumberToken(Token token) {
		try {
			return box.get(token);
		} catch (Exception e) {
			return 0;
		}

	}

	public String typeOfBox() {
		return "Box";
	}

	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append(typeOfBox()).append(" contains : ");
		for (Token token : box.keySet()) {
			str.append(box.get(token)).append(" ").append(token).append(",");
		}
		return str.substring(0, str.length() - 1);
	}
}
