package plays;

import board.Board;
import colors.Color;
import tokens.Box;
import tokens.Token;

/**
 * Represents an interface to manage the playType view and the playType model
 * 
 * @author Cahay-Durand
 *
 */
public class PlayTypeController {

	private final PlayTypeList model;
	private final PlayTypeView view;

	/**
	 * Constructs play type controller
	 * 
	 * @param model Play type model
	 * @param view  Play type view
	 */
	public PlayTypeController(PlayTypeList model, PlayTypeView view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Set the possible plays
	 * 
	 * @param box   Game box
	 * @param board Game board
	 */
	private void setPlayTypes(Box box, Board board) {
		model.clear();
		if (board.getNumberToken(new Token(Color.BLUE)) > 0) {
			model.add(PlayType.DISCARD);
		}
		if (box.getNumberToken(new Token(Color.BLUE)) > 0) {
			model.add(PlayType.HINT);
		}
	}

	/**
	 * Gets play type model
	 * 
	 * @return model
	 */
	public PlayTypeList getModel() {
		return model;
	}

	/**
	 * Gets play type view
	 * 
	 * @return view
	 */
	public PlayTypeView getView() {
		return view;
	}

	/**
	 * Draws possible plays
	 * 
	 * @param box   Game box
	 * @param board Game board
	 */
	public void showPossiblePlays(Box box, Board board) {
		setPlayTypes(box, board);
		view.showPossiblePlays(model);
	}

}
