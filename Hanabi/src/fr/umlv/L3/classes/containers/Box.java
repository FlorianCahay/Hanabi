package fr.umlv.L3.classes.containers;

import java.util.HashMap;

import fr.umlv.L3.classes.elements.Color;
import fr.umlv.L3.classes.elements.Token;

/**
 * Represent a token container.
 */
public class Box {
	private final HashMap<Token, Integer> box = new HashMap<>();

	/**
	 * Constructs a Box with blue and red tokens.
	 * 
	 * @param blueToken number of blue tokens to add
	 * @param redToken  number of red tokens to add
	 * @throws IllegalArgumentException if blueToken or redToken are negative
	 */
	public Box(int blueToken, int redToken) {
		if (blueToken < 0 || redToken < 0) {
			throw new IllegalArgumentException("blue and red tokens must be a positive integer");
		}
		add(new Token(Color.BLUE), blueToken);
		add(new Token(Color.RED), redToken);
	}

	/**
	 * Constructs a Box with 8 blue tokens and 0 red tokens.
	 */
	public Box() {
		this(8, 0);
	}

	/**
	 * Add the specified token to the box.
	 * 
	 * @param token token with a precise color
	 * @param value number of token to add
	 */
	public void add(Token token, int value) {
		box.computeIfPresent(token, (k, v) -> v + value);
		box.computeIfAbsent(token, k -> value);
	}

	/**
	 * Remove the specified token from the box.
	 * 
	 * @param token Token to remove from the box
	 * @return true if the token has been removed, false otherwise
	 */
	public boolean remove(Token token) {
		if (box.get(token) == 0) {
			return false;
		}
		box.computeIfPresent(token, (k, v) -> v - 1);
		return true;
	}

	private int getNumberToken(Token token) {
		return box.get(token);
	}

	/**
	 * Get the number of blue tokens in the box.
	 * 
	 * @return the number of blue tokens in the box
	 */
	public int getNumberBlueToken() {
		return getNumberToken(new Token(Color.BLUE));
	}

	/**
	 * Get the number of red tokens in the box.
	 * 
	 * @return the number of red tokens in the box
	 */
	public int getNumberRedToken() {
		return getNumberToken(new Token(Color.RED));
	}

	/**
	 * Get the box name.
	 * 
	 * @return Name of the box
	 */
	public String typeOfBox() {
		return "Box";
	}

	/**
	 * Returns a string representation of the contents of the box.
	 */
	@Override
	public String toString() {
		return typeOfBox() + " contains " + getNumberBlueToken() + " blue tokens and " + getNumberRedToken()
				+ " red tokens";
	}
}
