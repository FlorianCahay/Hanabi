package cards;

import java.awt.Graphics2D;
import java.util.Iterator;

import fr.umlv.zen5.ApplicationContext;
import mvc.ViewGraphic;
import player.Player;
import player.Players;

/**
 * Represents a graphic hand view
 * 
 * @author Cahay-Durand
 *
 */
public class HandViewGraphic extends ViewGraphic implements HandView {

	private final CardViewGraphic cardView;
	private final int cardDifference;
	private final int actualPlayerX;
	private final int actualPlayerY;

	/**
	 * Constructs graphic hand view
	 * 
	 * @param context  Application context
	 * @param cardView Card view
	 */
	public HandViewGraphic(ApplicationContext context, CardViewGraphic cardView) {
		super(context);
		this.cardView = cardView;
		cardDifference = (int) (getCardWidth() + getCardWidth() / 4);
		actualPlayerX = getWidth(3);
		actualPlayerY = (int) (getHeight() - getCardHeight() - getHeight(1));
	}

	/**
	 * Draws player hand
	 * 
	 * @param graphics Application graphics
	 * @param player   Player to draw
	 * @param x        Upper left corner x
	 * @param y        Upper left corner y
	 */
	public void hand(Graphics2D graphics, Player player, float x, float y) {
		setFont(graphics, 10);
		for (int i = 0; i < player.getHandSize(); i++) {
			cardView.card(graphics, (int) (x + i * cardDifference), (int) y, player.getCard(i));
		}
		graphics.drawString(player.getName(),
				x + centerTextOnX((int) (player.getHandSize() * cardDifference - getCardWidth() / 4),
						getStringWidth(player.getName())),
				y - graphics.getFont().getSize() / 12);
	}

	/**
	 * Draws the playing player hand (hiding its cards)
	 * 
	 * @param graphics Application context
	 * @param player   Player to draw
	 */
	public void actualPlayerHand(Graphics2D graphics, Player player) {
		setFont(graphics, 10);
		for (int i = 0; i < player.getHandSize(); i++) {
			cardView.cardContainer(graphics, (int) (actualPlayerX + i * cardDifference), (int) actualPlayerY, "");
		}
		graphics.drawString(player.getName(),
				actualPlayerX + centerTextOnX((int) (player.getHandSize() * cardDifference - getCardWidth() / 4),
						getStringWidth(player.getName())),
				actualPlayerY - graphics.getFont().getSize() / 12);
	}

	/**
	 * Gets card width
	 * 
	 * @return card width
	 */
	public float getCardWidth() {
		return cardView.getCardWidth();
	}

	/**
	 * Gets card height
	 * 
	 * @return card height
	 */
	public float getCardHeight() {
		return cardView.getCardHeight();
	}

	/**
	 * Gets a card by his coordinates
	 * 
	 * @param x      Cursor position
	 * @param y      Cursor position
	 * @param player Playing player
	 * @return The selected card
	 * @throws IllegalArgumentException If the coordinates are not one of a card
	 */
	public Card getCard(int x, int y, Player player) {
		for (int i = 0; i < player.getHandSize(); i++) {
			if (x > actualPlayerX + i * cardDifference && x < actualPlayerX + i * cardDifference + getCardWidth()
					&& y > actualPlayerY && y < actualPlayerY + getCardHeight()) {
				return player.getCard(i);
			}
		}
		throw new IllegalArgumentException("Positions given are not a hand card");
	}

	/**
	 * Gets player by his hand position
	 * 
	 * @param x            Cursor position
	 * @param y            Cursor position
	 * @param players      Players of the game
	 * @param actualPlayer Playing player
	 * @return The selected player
	 * @throws IllegalArgumentException If the cursor is not on a player hand
	 */
	public Player getPlayer(int x, int y, Players players, Player actualPlayer) {
		int cardHeightDifference = (int) (getCardHeight() + getCardHeight() / 4);
		Iterator<Player> iterator = players.getIterator();
		int i = 1;
		while (iterator.hasNext()) {
			var player = iterator.next();
			if (player.equals(actualPlayer)) {
				continue;
			}
			if (x > actualPlayerX && x < actualPlayerX + this.cardDifference * actualPlayer.getHandSize()
					&& y > actualPlayerY - i * cardHeightDifference
					&& y < actualPlayerY - (i - 1) * cardHeightDifference) {
				return player;
			}
			i++;
		}
		throw new IllegalArgumentException("Positions given are not a player");
	}

	/**
	 * Gets actualPlayer hand x position (upper left corner)
	 * 
	 * @return actualPlayerX
	 */
	public int getActualPlayerX() {
		return actualPlayerX;
	}

	/**
	 * Gets actualPlayer hand y position (upper left corner)
	 * 
	 * @return actualPlayerY
	 */
	public int getActualPlayerY() {
		return actualPlayerY;
	}

}
