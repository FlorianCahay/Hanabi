package fr.umlv.L3.classes.others;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import fr.umlv.L3.classes.elements.Card;
import fr.umlv.L3.classes.elements.Color;
import fr.umlv.L3.mvc.View;

public class ScannerSystemIn {
	private final Scanner scanner = new Scanner(System.in);

	public int nextInt(int min, int max) {
		var value = min - 1;
		if (scanner.hasNextInt()) {
			value = scanner.nextInt();
		} else {
			scanner.next();
		}
		if (value < min || value > max) {
			throw new InputMismatchException("the input int is not inlcude in [" + min + "," + max + "]");
		}
		return value;
	}

	public String nextString() {
		return scanner.next();
	}

	public Color nextColor() {
		switch (scanner.next()) {
		case "RED":
			return Color.RED;
		case "BLUE":
			return Color.BLUE;
		case "YELLOW":
			return Color.YELLOW;
		case "WHITE":
			return Color.WHITE;
		case "GREEN":
			return Color.GREEN;
		default:
			throw new IllegalStateException(
					"Color string must be in capitals and be an existing color of the fireworks");
		}
	}

	public int getValidInt(String error, View view, int min, int max) {
		var value = 0;
		while (true) {
			try {
				value = nextInt(min, max);
			} catch (Exception e) {
				view.drawError(error);
				continue;
			}
			return value;
		}
	}

	public String getValidString(String error, View view) {
		var str = new String();
		while (true) {
			try {
				str = nextString();
			} catch (Exception e) {
				view.drawError(error);
				continue;
			}
			return str;
		}
	}

	public Color getValidColor(View view) {
		var color = Color.WHITE;
		while (true) {
			try {
				color = nextColor();
			} catch (Exception e) {
				view.drawError("Color string must be in capitals and be an existing color of the fireworks");
				continue;
			}
			return color;
		}
	}

	public Player getValidPlayer(View view, ArrayList<Player> players) {
		var name = new String();
		while (true) {
			name = getValidString("Your name as to be a string of at least 1 character", view);
			for (Player player : players) {
				if (player.getName().equals(name)) {
					return player;
				}
			}
			view.drawErrorPlayerDoesntExist();
		}

	}

	public Card getValidCardFromHand(View view, Player player) {
		var card = new Card(getValidInt("Card value has to be include in [1,5]", view, 1, 5), getValidColor(view));
		while (!player.handContains(card)) {
			view.drawErrorCardChoseNotInHand(player);
			card = new Card(getValidInt("Card value has to be include in [1,5]", view, 1, 5), getValidColor(view));
		}
		return card;
	}
}
