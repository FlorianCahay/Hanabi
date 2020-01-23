package mvc;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.Collection;
import java.util.function.Consumer;

import fr.umlv.zen5.ApplicationContext;
import graphic.Cell;

public class ViewGraphic implements View {
	private final ApplicationContext context;
	private final float width;
	private final float height;
	private final Font font;
	private FontMetrics metrics;
	private final Cell cell;

	public ViewGraphic(ApplicationContext context) {
		this.context = context;
		this.width = context.getScreenInfo().getWidth();
		this.height = context.getScreenInfo().getHeight();
		this.font = new Font("Serif", Font.BOLD, 12);
		this.cell = new Cell((int) width, (int) height);
	}

	private int sizeFont(int size) {
		return (int) (getWidth() / getHeight() * ((getWidth() + getHeight()) / 1000)) * size;
	}

	public int getWidth(int indexCell) {
		return cell.getWidth(indexCell);
	}

	public int getHeight(int indexCell) {
		return cell.getHeight(indexCell);
	}

	public void setFont(Graphics2D graphics, int size) {
		Font newFont = font.deriveFont((float) sizeFont(size));
		graphics.setFont(newFont);
		metrics = graphics.getFontMetrics();
	}

	public int centerTextOnX(int containerWidth, int stringWidth) {
		return (containerWidth - stringWidth) / 2;
	}

	public void centeredText(Graphics2D graphics, String text, int y) {
		graphics.drawString(text, centerTextOnX((int) width, getStringWidth(text)), y);
	}

	public static Object getItem(float x, float y, Collection<Object> list, int startX, int startY, int width,
			int height) {
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

	public void choices(Graphics2D graphics, Collection<Object> list, int x, int y, int width, int height) {
		var nbElements = list.size();
		var rectangleWidth = width / nbElements;
		var rectangleHeight = height;
		var iterator = list.iterator();
		for (int i = 0; i < nbElements; i++) {
			var element = iterator.next().toString();
			graphics.drawRect((int) (x + i * rectangleWidth), y, (int) rectangleWidth, (int) (rectangleHeight));
			graphics.drawString(element,
					x + centerTextOnX((int) rectangleWidth, getStringWidth(element)) + i * rectangleWidth,
					(int) (y + rectangleHeight / 2));

		}
	}

	public int getStringWidth(String string) {
		return metrics.stringWidth(string);
	}

	public void renderFrame(Consumer<Graphics2D> arg0) {
		context.renderFrame(arg0);
	}

	public void clear(Graphics2D graphics) {
		graphics.clearRect(0, 0, (int) width, (int) height);
	}

	public ApplicationContext getContext() {
		return context;
	}

	public float getWidth() {
		return width;
	}

	public float getHeight() {
		return height;
	}

}
