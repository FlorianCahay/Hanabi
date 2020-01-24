package tokens;

import java.util.HashMap;

import colors.Color;

/**
 * Represents a token container
 * 
 * @author Cahay-Durand
 *
 */
public class Box {
	private final HashMap<Token, Integer> box = new HashMap<>();

	/**
	 * Constructs a box filling with 8 blue tokens or 3 red tokens
	 * 
	 * @param color Token color to fill
	 */
	public Box(Color color) {
		if (color.equals(Color.BLUE)) {
			add(new Token(Color.BLUE), 8);
		} else if (color.equals(Color.RED)) {
			add(new Token(Color.RED), 3);
		}
	}

	/**
	 * Adds tokens
	 * 
	 * @param token Token color
	 * @param value Number of token to add
	 */
	public void add(Token token, int value) {
		box.computeIfPresent(token, (k, v) -> v + value);
		box.computeIfAbsent(token, k -> value);
	}

	/**
	 * Removes one token
	 * 
	 * @param token Token color
	 * @return True if a token has been removed, false otherwise
	 */
	public boolean remove(Token token) {
		if (box.get(token) == 0) {
			return false;
		}
		box.computeIfPresent(token, (k, v) -> v - 1);
		return true;
	}

	/**
	 * Gets the number of token
	 * 
	 * @param token Token color
	 * @return Number of token
	 */
	public int getNumberToken(Token token) {
		try {
			return box.get(token);
		} catch (Exception e) {
			return 0;
		}
	}

	/**
	 * Gets the box name
	 * 
	 * @return box name
	 */
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
