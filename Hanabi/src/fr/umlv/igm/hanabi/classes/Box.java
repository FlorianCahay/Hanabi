package fr.umlv.igm.hanabi.classes;

import java.util.ArrayList;

public class Box {
	private final ArrayList<Token> box = new ArrayList<>();

	public Box(int blueToken, int redToken) {
		for (int i = 0; i < blueToken; i++) {
			add(new Token(Color.BLUE));
		}
		for (int i = 0; i < redToken; i++) {
			add(new Token(Color.RED));
		}
	}

	public void add(Token token) {
		box.add(token);
	}

	public void remove(Token token) {
		box.remove(token);
	}

	public int getNumberToken(Token token) {
		int nbToken = 0;
		for (Token t : box) {
			if (t.equals(token)) {
				nbToken++;
			}
		}
		return nbToken;
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
