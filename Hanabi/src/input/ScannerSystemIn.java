package input;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.function.Supplier;

import cards.Card;
import colors.Color;
import player.Player;
import player.Players;

public class ScannerSystemIn implements Input {
	private final Scanner scanner = new Scanner(System.in);
	private final ScannerSystemInView view = new ScannerSystemInView();

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
		return Color.valueOf(scanner.next());
	}

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

	public int getValidInt(String error, int min, int max) {
		return (int) getValid(error, () -> nextInt(min, max));
	}

	public String getValidString(String error) {
		return (String) getValid(error, () -> nextString());
	}

	public Color getValidColor() {
		return (Color) getValid("Color string must be in capitals and be an existing color of the fireworks",
				() -> nextColor());
	}

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

	public Card getValidCardFromHand(Player player) {
		var card = player.getCard(
				getValidInt("Card value has to be include in [1," + player.getHandSize() + "]", 1, player.getHandSize())
						- 1);
		return card;
	}

	public void close() {
		scanner.close();
	}
}
