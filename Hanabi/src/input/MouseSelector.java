package input;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.TimeUnit;

import cards.Card;
import cards.HandViewGraphic;
import colors.Color;
import fr.umlv.zen5.ApplicationContext;
import fr.umlv.zen5.Event;
import fr.umlv.zen5.Event.Action;
import fr.umlv.zen5.KeyboardKey;
import player.Player;
import player.Players;

public class MouseSelector implements Input {

	private final ApplicationContext context;
	private final TextWriter model = new TextWriter();
	private final MouseSelectorView view;
	private final HandViewGraphic handView;

	public MouseSelector(ApplicationContext context, HandViewGraphic handView) {
		this.context = context;
		this.view = new MouseSelectorView(context);
		this.handView = handView;
	}

	private Object getItem(float x, float y, Collection<Object> list, int startX, int startY, int width, int height) {
		var nbElements = list.size();
		var rectangleWidth = width / nbElements;
		var rectangleHeight = height;
		var iterator = list.iterator();
		for (int i = 0; i < nbElements; i++) {
			var element = iterator.next();
			if (x > startX + i * rectangleWidth && x < startX + i * rectangleWidth + rectangleWidth && y > startY
					&& y < startY + rectangleHeight) {
				return element;
			}
		}
		throw new IllegalArgumentException("Values given are not an item choice");
	}

	public int getValidInt(String error, int min, int max, int x, int y, int width, int height) {
		List<Object> list = new ArrayList<>();
		for (int i = min; i < max + 1; i++) {
			list.add(i);
		}
		waitEvent();
		for (;;) {
			Event event = context.pollOrWaitEvent(10);
			if (event == null) { // no event
				continue;
			}
			Point2D.Float location = event.getLocation();
			try {
				return (int) getItem(location.x, location.y, list, x, y, width, height);
			} catch (Exception e) {

			}
		}
	}

	private void waitEvent() {
		try {
			TimeUnit.MILLISECONDS.sleep(500);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		context.pollEvent();
	}

	@Override
	public Color getValidColor() {
		waitEvent();
		for (;;) {
			Event event = context.pollOrWaitEvent(10);
			if (event == null) { // no event
				continue;
			}
			Point2D.Float location = event.getLocation();
			try {
				return (Color) getItem(location.x, location.y, Arrays.asList(Color.values()), view.getWidth(25),
						view.getHeight(3), view.getWidth(15), view.getHeight(1));

			} catch (Exception e) {

			}
		}
	}

	@Override
	public int getNumberPLayers(String error, int min, int max) {
		return getValidInt(error, min, max, 0, view.getHeight(12), (int) view.getWidth(), view.getHeight(3));
	}

	@Override
	public int getPlayType(String error, int min, int max) {
		return getValidInt(error, min, max, view.getWidth(25), view.getHeight(3), view.getWidth(15), view.getHeight(1));
	}

	@Override
	public int getHintType(String error, int min, int max) {
		return getPlayType(error, min, max);
	}

	@Override
	public int getCardValue(String error, int min, int max) {
		return getPlayType(error, min, max);
	}

	@Override
	public String getValidString(String error) {
		for (;;) {
			Event event = context.pollOrWaitEvent(10);
			if (event == null) { // no event
				continue;
			}
			KeyboardKey key = event.getKey();
			if (key != null) {
				if (event.getAction() == Action.KEY_PRESSED) {
					if (key == KeyboardKey.SPACE) {
						if (model.toString().equals("")) {
							view.error(error);
							continue;
						} else {
							return model.toString();
						}
					}
					model.append(key.name());
					view.name(model);
				}
			}
		}
	}

	@Override
	public String getValidPlayer(Players players) {
		for (;;) {
			var name = getValidString("Name is not valid");
			if (players.isNewPlayer(name)) {
				model.reset();
				return name;
			}

			model.reset();
			view.resetName();
		}
	}

	@Override
	public Player getExistingPlayer(Players players, Player actualPlayer) {
		for (;;) {
			Event event = context.pollOrWaitEvent(10);
			if (event == null) { // no event
				continue;
			}
			Point2D.Float location = event.getLocation();
			try {
				return handView.getPlayer((int) location.x, (int) location.y, players, actualPlayer);
			} catch (Exception e) {

			}
		}
	}

	@Override
	public Card getValidCardFromHand(Player player) {
		List<Object> list = new ArrayList<>();
		for (int i = 0; i < player.getHandSize(); i++) {
			list.add(player.getCard(i));
		}
		for (;;) {
			Event event = context.pollOrWaitEvent(10);
			if (event == null) { // no event
				continue;
			}
			Point2D.Float location = event.getLocation();
			try {
				return handView.getCard((int) location.x, (int) location.y, player);
			} catch (Exception e) {

			}
		}
	}

	@Override
	public void close() {
		context.exit(0);
	}

}
