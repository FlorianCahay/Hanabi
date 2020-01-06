package mvc;

import java.awt.Graphics2D;
import java.util.function.Consumer;

import fr.umlv.zen5.ApplicationContext;

public class ViewGraphic implements View {
	private final ApplicationContext context;
	private final float width;
	private final float height;

	public ViewGraphic(ApplicationContext context) {
		this.context = context;
		this.width = context.getScreenInfo().getWidth();
		this.height = context.getScreenInfo().getHeight();
	}

	public void renderFrame(Consumer<Graphics2D> arg0) {
		context.renderFrame(arg0);
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

}
