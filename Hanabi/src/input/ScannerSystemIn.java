package input;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Supplier;

import cards.Card;
import colors.Color;
import player.Player;
import player.Players;

/**
 * Represents a scanner for System.in inputs
 * 
 * @author Cahay-Durand
 *
 */
public class ScannerSystemIn implements Input {
	private final Scanner scanner = new Scanner(System.in);
	private final ScannerSystemInView view = new ScannerSystemInView();

	/**
	 * Gets the next int value input include in [min,max]
	 * 
	 * @param min Minimum value
	 * @param max Maximum value
	 * @return Value in include in [min,max]
	 * @throws InputMismatchException If int not include [min,max]
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
	 * Gets the next string input
	 * 
	 * @return String input
	 */
	public String nextString() {
		return scanner.next();
	}

	/**
	 * Gets the next color input
	 * 
	 * @return Color input
	 */
	public Color nextColor() {
		return Color.valueOf(scanner.next());
	}

	/**
	 * Gets a valid object from the next supplier
	 * 
	 * @param error Error to show if the supplier can't get next
	 * @param next  Next type
	 * @return Valid Object from next supplier
	 */
	private Object getValid(String error, Supplier<Object> next) {
		var read = new Object();
		while (true) {
			try {
				read = next.get();
			} catch (Exception e) {
				view.error(error);
				continue;
			}
			return read;
		}
	}

	/**
	 * Gets a valid int include in [min,max]
	 * 
	 * @param error Error to show if the input is not valid
	 * @param min   Minimum value
	 * @param max   Maximum value
	 * @return Valid int include in [min,max]
	 */
	public int getValidInt(String error, int min, int max) {
		return (int) getValid(error, () -> nextInt(min, max));
	}

	@Override
	public String getValidString(String error) {
		return (String) getValid(error, () -> nextString());
	}

	@Override
	public Color getValidColor() {
		return (Color) getValid("Color string must be in capitals and be an existing color of the fireworks",
				() -> nextColor());
	}

	@Override
	public String getValidPlayer(Players players) {
		var name = new String();
		while (true) {
			name = getValidString("Your name as to be a string of at least 1 character");
			if (players.isNewPlayer(name)) {
				return name;
			}
			view.error("This player name already exists");
		}
	}

	@Override
	public Player getExistingPlayer(Players players, Player actualPlayer) {
		var name = new String();
		while (true) {
			name = getValidString("Your name as to be a string of at least 1 character");
			try {
				return players.getPlayer(name, actualPlayer);
			} catch (Exception e) {
				view.error("This player name doesn't exist");
			}
		}
	}

	@Override
	public int getNumberPLayers(String error, int min, int max) {
		return getValidInt(error, min, max);
	}

	@Override
	public int getPlayType(String error, int min, int max) {
		return getValidInt(error, min, max);
	}

	@Override
	public int getCardValue(String error, int min, int max) {
		return getValidInt(error, min, max);
	}

	@Override
	public int getHintType(String error, int min, int max) {
		return getValidInt(error, min, max);
	}

	@Override
	public Card getValidCardFromHand(Player player) {
		var card = player.getCard(
				getValidInt("Card value has to be include in [1," + player.getHandSize() + "]", 1, player.getHandSize())
						- 1);
		return card;
	}

	@Override
	public void close() {
		scanner.close();
	}
}
