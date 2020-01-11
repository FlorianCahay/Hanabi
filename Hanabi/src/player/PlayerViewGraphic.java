package player;

import java.awt.Graphics2D;

import fr.umlv.zen5.ApplicationContext;
import mvc.ViewGraphic;

public class PlayerViewGraphic extends ViewGraphic implements PlayerView {

	public PlayerViewGraphic(ApplicationContext context) {
		super(context);
	}

	@Override
	public void showPlayer(Player player) {
		renderFrame(graphics -> showPlayer(graphics, player));
	}

	private void showPlayer(Graphics2D graphics, Player player) {
		setFont(graphics, 5);
		var str = player.getName() + " it is your turn now";
		graphics.drawString(str, centerTextOnX((int) getWidth() - getWidth(25), getStringWidth(str)) + getWidth(25),
				getHeight(1));
		str = "Last hint someone gave you : " + player.readHint();
		graphics.drawString(str, centerTextOnX((int) getWidth() - getWidth(25), getStringWidth(str)) + getWidth(25),
				getHeight(2));
	}

	@Override
	public void askPlayType(String name) {
		// TODO Auto-generated method stub

	}

}
