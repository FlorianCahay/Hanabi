package player;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cards.HandViewGraphic;
import fr.umlv.zen5.ApplicationContext;
import mvc.ViewGraphic;

public class PlayersViewGraphic extends ViewGraphic implements PlayersView {

	private final HandViewGraphic handView;

	public PlayersViewGraphic(ApplicationContext context, HandViewGraphic handView) {
		super(context);
		this.handView = handView;
	}

	@Override
	public void askPlayersNumber() {
		renderFrame(graphics -> askPlayersNumber(graphics));
	}

	private void askPlayersNumber(Graphics2D graphics) {
		var str = "How many players are you ? (click on value)";
		setFont(graphics, 10);
		centeredText(graphics, str, getHeight(7));
		List<Object> list = new ArrayList<>();
		for (int i = Players.getMinPlayers(); i < Players.getMaxPlayers() + 1; i++) {
			list.add(i);
		}
		choices(graphics, list, 0, getHeight(12), (int) getWidth(), getHeight(3));
	}

	@Override
	public void askPlayerName(int index) {
		renderFrame(graphics -> askPlayerName(graphics, index));
	}

	private void askPlayerName(Graphics2D graphics, int index) {
		clear(graphics);
		var str = "Player " + (index + 1) + " write your name down : (press space bar to valid your name)";
		setFont(graphics, 10);
		centeredText(graphics, str, getHeight(7));
	}

	@Override
	public void showPlayersCards(Players players, Player actualPlayer, int numberPlayers) {
		renderFrame(graphics -> showPlayersCards(graphics, players, actualPlayer, numberPlayers));
	}

	private void showPlayersCards(Graphics2D graphics, Players players, Player actualPlayer, int numberPlayers) {
		clear(graphics);
		setFont(graphics, 10);
		handView.actualPlayerHand(graphics, actualPlayer);
		Iterator<Player> iterator = players.getIterator();
		int i = 1;
		while (iterator.hasNext()) {
			Player player = iterator.next();
			if (player.equals(actualPlayer)) {
				continue;
			}
			handView.hand(graphics, player, handView.getActualPlayerX(),
					handView.getActualPlayerY() - (i * (handView.getCardHeight() + handView.getCardHeight() / 4)));
			i++;
		}
	}

}
