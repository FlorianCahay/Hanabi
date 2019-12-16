package fr.umlv.L3.classes.others;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Supplier;

import fr.umlv.L3.classes.elements.Card;
import fr.umlv.L3.classes.elements.Color;
import fr.umlv.L3.mvc.View;

/**
 * 
 * Represent a scanner scanning System.in entry.
 *
 */
public class ScannerSystemIn {
	private final Scanner scanner = new Scanner(System.in);

	/**
	 * Get a valid int value input by user.
	 * 
	 * @param min minimum value
	 * @param max maximum value
	 * @return a valid int value input by user
	 * @throws InputMismatchException if the value not corresponding to a hint
	 *                                include in min and max
	 */
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

	/**
	 * Get a valid string input by user.
	 * 
	 * @return valid string input by user
	 */
	public String nextString() {
		return scanner.next();
	}

	/**
	 * Get a valid color input by user.
	 * 
	 * @return valid color
	 * @throws IllegalStateException if input not corresponding to any color
	 */
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

	/**
	 * 
	 * @param error error to print if not valid
	 * @param view game view
	 * @param next supplier
	 * @return new valid object
	 */
	private Object getValid(String error, View view, Supplier<Object> next) {
		var read = new Object();
		while (true) {
			try {
				read = next.get();
			} catch (Exception e) {
				view.drawError(error);
				continue;
			}
			return read;
		}
	}

	/**
	 * Keep trying to get a valid int value.
	 * 
	 * @param error error to print if not valid value
	 * @param view game view
	 * @param min minimum value
	 * @param max maximum value
	 * @return valid int value include in min and max
	 */
	public int getValidInt(String error, View view, int min, int max) {
		return (int) getValid(error, view, () -> nextInt(min, max));
	}

	/**
	 * Keep trying to get a valid string.
	 * 
	 * @param error error to print if not valid string
	 * @param view game view
	 * @return valid string
	 */
	public String getValidString(String error, View view) {
		return (String) getValid(error, view, () -> nextString());
	}

	/**
	 * Keep trying to get a valid color.
	 * 
	 * @param view game view
	 * @return valid color
	 */
	public Color getValidColor(View view) {
		return (Color) getValid("Color string must be in capitals and be an existing color of the fireworks", view,
				() -> nextColor());
	}

	/**
	 * Keep trying to get a valid player.
	 * 
	 * @param view game view
	 * @param players player list
	 * @param actualPlayer playing player
	 * @return existing player
	 */
	public Player getValidPlayer(View view, ArrayList<Player> players, Player actualPlayer) {
		var name = new String();
		while (true) {
			name = getValidString("Your name as to be a string of at least 1 character", view);
			for (Player player : players) {
				if (player.getName().equals(name) && !player.getName().equals(actualPlayer.getName())) {
					return player;
				}
			}
			view.drawErrorPlayerDoesntExist();
		}

	}

	/**
	 * Keep trying to get a valid card from hand of the player.
	 * 
	 * @param view game view
	 * @param player player to get the hand
	 * @return valid card contained in player hand
	 */
	public Card getValidCardFromHand(View view, Player player) {
		var card = player.getCard(getValidInt("Card value has to be include in [1," + player.getHandSize() + "]", view,
				1, player.getHandSize()) - 1);
		return card;
	}

	/**
	 * Close the scanner.
	 */
	public void close() {
		scanner.close();
	}

}
