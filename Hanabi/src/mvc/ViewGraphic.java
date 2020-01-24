package mvc;

import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.util.Collection;
import java.util.function.Consumer;

import fr.umlv.zen5.ApplicationContext;
import graphic.Cell;

/**
 * Represents a graphic view
 * 
 * @author Cahay-Durand
 *
 */
public class ViewGraphic implements View {
	private final ApplicationContext context;
	private final float width;
	private final float height;
	private final Font font;
	private FontMetrics metrics;
	private final Cell cell;

	/**
	 * Constructs a graphic view
	 * 
	 * @param context Application context
	 */
	public ViewGraphic(ApplicationContext context) {
		this.context = context;
		this.width = context.getScreenInfo().getWidth();
		this.height = context.getScreenInfo().getHeight();
		this.font = new Font("Serif", Font.BOLD, 12);
		this.cell = new Cell((int) width, (int) height);
	}

	/**
	 * Gets the font size from the screen size
	 * 
	 * @param size Font size
	 * @return Adapted font sizes
	 */
	private int sizeFont(int size) {
		return (int) (getWidth() / getHeight() * ((getWidth() + getHeight()) / 1000)) * size;
	}

	/**
	 * Gets the cell x point for the cell at index
	 * 
	 * @param indexCell Which cell
	 * @return X point of the cell
	 */
	public int getWidth(int indexCell) {
		return cell.getWidth(indexCell);
	}

	/**
	 * Gets the cell y point for the cell at index
	 * 
	 * @param indexCell Which cell
	 * @return Y point of the cell
	 */
	public int getHeight(int indexCell) {
		return cell.getHeight(indexCell);
	}

	/**
	 * Sets the font for graphics
	 * 
	 * @param graphics Application graphics
	 * @param size     Font size
	 */
	public void setFont(Graphics2D graphics, int size) {
		Font newFont = font.deriveFont((float) sizeFont(size));
		graphics.setFont(newFont);
		metrics = graphics.getFontMetrics();
	}

	/**
	 * Gets a x value which center the text on x
	 * 
	 * @param containerWidth Container containing the text
	 * @param stringWidth    Text width
	 * @return X value
	 */
	public int centerTextOnX(int containerWidth, int stringWidth) {
		return (containerWidth - stringWidth) / 2;
	}

	/**
	 * Draws a centered text in middle of the screen
	 * 
	 * @param graphics Application graphics
	 * @param text     Text to draw
	 * @param y        Y coordinate for text
	 */
	public void centeredText(Graphics2D graphics, String text, int y) {
		graphics.drawString(text, centerTextOnX((int) width, getStringWidth(text)), y);
	}

	/**
	 * Gets an item from the list with x and y positions
	 * 
	 * @param x      X cursor position
	 * @param y      Y cursor position
	 * @param list   Item list
	 * @param startX X starting point of the list
	 * @param startY Y starting point of the list
	 * @param width  List width
	 * @param height List height
	 * @return Element of the Item list
	 * @throws IllegalArgumentException If cursor positions are not on an item
	 */
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

	/**
	 * Draws Item list
	 * 
	 * @param graphics Application context
	 * @param list     Item list
	 * @param x        X starting point of the list
	 * @param y        Y starting point of the list
	 * @param width    List width
	 * @param height   List height
	 */
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
					(int) (y + rectangleHeight / 2 + graphics.getFont().getSize() / 4));

		}
	}

	/**
	 * Gets string width
	 * 
	 * @param string String to test
	 * @return String width
	 */
	public int getStringWidth(String string) {
		return metrics.stringWidth(string);
	}

	/**
	 * Renders a frame
	 * 
	 * @param arg0 Graphics consumer
	 */
	public void renderFrame(Consumer<Graphics2D> arg0) {
		context.renderFrame(arg0);
	}

	/**
	 * Draws a clearRectangle for the whole screen
	 * 
	 * @param graphics Application graphics
	 */
	public void clear(Graphics2D graphics) {
		graphics.clearRect(0, 0, (int) width, (int) height);
	}

	/**
	 * Gets the context
	 * 
	 * @return context
	 */
	public ApplicationContext getContext() {
		return context;
	}

	/**
	 * Gets the screen width
	 * 
	 * @return screen width
	 */
	public float getWidth() {
		return width;
	}

	/**
	 * Gets the screen height
	 * 
	 * @return screen height
	 */
	public float getHeight() {
		return height;
	}

}
