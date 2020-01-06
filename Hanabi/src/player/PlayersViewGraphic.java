package player;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import fr.umlv.zen5.ApplicationContext;
import mvc.ViewGraphic;

public class PlayersViewGraphic extends ViewGraphic implements PlayersView {

	public PlayersViewGraphic(ApplicationContext context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void askPlayersNumber() {
		renderFrame(graphics -> askPlayersNumber(graphics));
	}

	private void askPlayersNumber(Graphics2D graphics) {
		graphics.setColor(Color.BLUE);
		graphics.fill(new Rectangle2D.Float(0, 0, getWidth() / 2, getHeight() / 2));
	}

	@Override
	public void askPlayerName(int index) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showPlayersCards(Players players) {
		// TODO Auto-generated method stub

	}

}
