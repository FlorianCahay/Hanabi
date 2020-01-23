package cards;

import java.awt.Graphics2D;
import java.util.Iterator;

import fr.umlv.zen5.ApplicationContext;
import mvc.ViewGraphic;
import player.Player;
import player.Players;

public class HandViewGraphic extends ViewGraphic implements HandView {

	private final CardViewGraphic cardView;
	private final int cardDifference;
	private final int actualPlayerX;
	private final int actualPlayerY;

	public HandViewGraphic(ApplicationContext context, CardViewGraphic cardView) {
		super(context);
		this.cardView = cardView;
		cardDifference = (int) (getCardWidth() + getCardWidth() / 4);
		actualPlayerX = getWidth(3);
		actualPlayerY = (int) (getHeight() - getCardHeight() - getHeight(1));
	}

	public void hand(Graphics2D graphics, Player player, float x, float y) {
		setFont(graphics, 10);
		for (int i = 0; i < player.getHandSize(); i++) {
			cardView.card(graphics, (int) (x + i * cardDifference), (int) y, player.getCard(i));
		}
		graphics.drawString(player.getName(),
				x + centerTextOnX((int) (player.getHandSize() * cardDifference), getStringWidth(player.getName())), y);
	}

	public void actualPlayerHand(Graphics2D graphics, Player player) {
		setFont(graphics, 10);
		for (int i = 0; i < player.getHandSize(); i++) {
			cardView.cardContainer(graphics, (int) (actualPlayerX + i * cardDifference), (int) actualPlayerY, "");
		}
		graphics.drawString(player.getName(), actualPlayerX
				+ centerTextOnX((int) (player.getHandSize() * cardDifference), getStringWidth(player.getName())),
				actualPlayerY);
	}

	public float getCardWidth() {
		return cardView.getCardWidth();
	}

	public float getCardHeight() {
		return cardView.getCardHeight();
	}

	public Card getCard(int x, int y, Player player) {
		for (int i = 0; i < player.getHandSize(); i++) {
			if (x > actualPlayerX + i * cardDifference && x < actualPlayerX + i * cardDifference + getCardWidth()
					&& y > actualPlayerY && y < actualPlayerY + getCardHeight()) {
				return player.getCard(i);
			}
		}
		throw new IllegalArgumentException("Positions given are not a hand card");
	}

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

	public int getActualPlayerX() {
		return actualPlayerX;
	}

	public int getActualPlayerY() {
		return actualPlayerY;
	}

}
