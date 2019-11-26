package fr.umlv.L3.classes.containers;

import java.util.HashMap;

import fr.umlv.L3.classes.elements.Color;
import fr.umlv.L3.classes.elements.Token;

/**
 * Represent a token container with a HashMap
 */
public class Box {
	private final HashMap<Token, Integer> box = new HashMap<>();

	/**
	 * Constructor initializing Box with blue and red tokens
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
	 * Constructor initializing Box with 8 blue tokens and 0 red tokens
	 */
	public Box() {
		this(8, 0);
	}

	/**
	 * Add a token to the box
	 * 
	 * @param token Token with a precise color
	 * @param value Number of token to add
	 */
	public void add(Token token, int value) {
		box.computeIfPresent(token, (k, v) -> v + value);
		box.computeIfAbsent(token, k -> value);
	}

	/**
	 * Remove a token from the box
	 * 
	 * @param token Token to remove from the box
	 * @return True if the token has been removed, False otherwise
	 */
	public boolean remove(Token token) {
		if (box.get(token) == 0) {
			return false;
		}
		box.computeIfPresent(token, (k, v) -> v - 1);
		return true;
	}

	private int getNumberToken(Token token) {
		if (!box.containsKey(token)) {
			return 0;
		}
		return box.get(token);
	}

	/**
	 * get the number of blue tokens in the box
	 * 
	 * @return the number of blue tokens
	 */
	public int getNumberBlueToken() {
		return getNumberToken(new Token(Color.BLUE));
	}

	/**
	 * get the number of red tokens in the box
	 * 
	 * @return the number of red tokens
	 */
	public int getNumberRedToken() {
		return getNumberToken(new Token(Color.RED));
	}

	/**
	 * get the box name
	 * 
	 * @return Name of the box
	 */
	public String typeOfBox() {
		return "Box";
	}

	@Override
	public String toString() {
		return typeOfBox() + " contains " + getNumberBlueToken() + " blue tokens and " + getNumberRedToken()
				+ " red tokens";
	}
}
