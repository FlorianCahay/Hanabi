package plays;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Arrays;

import cards.Card;
import fr.umlv.zen5.ApplicationContext;
import mvc.ViewGraphic;

/**
 * Represents graphic play type view
 * 
 * @author Cahay-Durand
 *
 */
public class PlayTypeViewGraphic extends ViewGraphic implements PlayTypeView {

	/**
	 * Constructs graphic play type view
	 * 
	 * @param context Application context
	 */
	public PlayTypeViewGraphic(ApplicationContext context) {
		super(context);
	}

	/**
	 * Clears the last question asked
	 * 
	 * @param graphics Application graphics
	 */
	private void clearQuestion(Graphics2D graphics) {
		graphics.setColor(Color.white);
		graphics.fillRect(getWidth(25), getHeight(2) + getHeight(1) / 2, getWidth(16), getHeight(3));
		graphics.setColor(Color.black);
	}

	@Override
	public void showPossiblePlays(PlayTypeList plays) {
		renderFrame(graphics -> showPossiblePlays(graphics, plays));
	}

	/**
	 * Draws possible plays
	 * 
	 * @param graphics Application graphics
	 * @param plays    Possible plays
	 */
	private void showPossiblePlays(Graphics2D graphics, PlayTypeList plays) {
		setFont(graphics, 5);
		String str = "Which play do you want to do ?(click on value)";
		drawQuestion(graphics, str);
		ArrayList<Object> list = new ArrayList<>();
		for (int i = 1; i < plays.size() + 1; i++) {
			list.add(plays.getPlayType(i));
		}
		choices(graphics, list, getWidth(25), getHeight(3), getWidth(15), getHeight(1));
	}

	/**
	 * Draws a question
	 * 
	 * @param graphics Application graphics
	 * @param str      Question to draw
	 */
	private void drawQuestion(Graphics2D graphics, String str) {
		graphics.drawString(str, getWidth(25) + centerTextOnX(getWidth(15), getStringWidth(str)),
				getHeight(3) - graphics.getFont().getSize() / 4);
	}

	@Override
	public void askWhichPlayer() {
		renderFrame(graphics -> askWhichPlayer(graphics));
	}

	/**
	 * Draws question asking which player
	 * 
	 * @param graphics Application graphics
	 */
	private void askWhichPlayer(Graphics2D graphics) {
		clearQuestion(graphics);
		setFont(graphics, 5);
		drawQuestion(graphics, "Choose a player to give a hint to him (click on player hand)");
	}

	@Override
	public void askColorOrValue() {
		renderFrame(graphics -> askColorOrValue(graphics));
	}

	/**
	 * Draws question asking for color or value
	 * 
	 * @param graphics Application graphics
	 */
	private void askColorOrValue(Graphics2D graphics) {
		clearQuestion(graphics);
		setFont(graphics, 5);
		drawQuestion(graphics, "Give Color hint or Value hint ? (click on value)");
		var list = new ArrayList<Object>();
		list.add("Color");
		list.add("Value");
		choices(graphics, list, getWidth(25), getHeight(3), getWidth(15), getHeight(1));
	}

	@Override
	public void askColor() {
		renderFrame(graphics -> askColor(graphics));
	}

	/**
	 * Draws question asking for color
	 * 
	 * @param graphics Application graphics
	 */
	private void askColor(Graphics2D graphics) {
		clearQuestion(graphics);
		setFont(graphics, 5);
		drawQuestion(graphics, "Choose a Color for your hint (click on value)");
		choices(graphics, Arrays.asList((Object[]) colors.Color.values()), getWidth(25), getHeight(3), getWidth(15),
				getHeight(1));
	}

	@Override
	public void askValue() {
		renderFrame(graphics -> askValue(graphics));
	}

	/**
	 * Draws question asking for value
	 * 
	 * @param graphics Application graphics
	 */
	private void askValue(Graphics2D graphics) {
		clearQuestion(graphics);
		setFont(graphics, 5);
		drawQuestion(graphics, "Choose a Value for your hint (click on value)");
		var list = new ArrayList<Object>();
		for (int i = Card.getLowestvalue(); i < Card.getHighestvalue() + 1; i++) {
			list.add(i);
		}
		choices(graphics, list, getWidth(25), getHeight(3), getWidth(15), getHeight(1));
	}

	@Override
	public void askCard() {
		renderFrame(graphics -> askCard(graphics));
	}

	/**
	 * Draws question asking for card
	 * 
	 * @param graphics Application graphics
	 */
	private void askCard(Graphics2D graphics) {
		clearQuestion(graphics);
		setFont(graphics, 5);
		drawQuestion(graphics, "Choose one of your Cards (click on card in your hand)");
	}

	@Override
	public void showPlayedCard(Card card) {
		// TODO Auto-generated method stub

	}

	@Override
	public void showDiscardedCard(Card card) {
		// TODO Auto-generated method stub

	}

}
