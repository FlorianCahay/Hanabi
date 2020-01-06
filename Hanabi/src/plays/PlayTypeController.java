package plays;

import board.Board;
import colors.Color;
import mvc.Controller;
import tokens.Box;
import tokens.Token;

public class PlayTypeController implements Controller {

	private final PlayTypeList model;
	private final PlayTypeView view;

	public PlayTypeController(PlayTypeList model, PlayTypeView view) {
		this.model = model;
		this.view = view;
	}

	private void setPlayTypes(Box box, Board board) {
		model.clear();
		if (board.getNumberToken(new Token(Color.BLUE)) > 0) {
			model.add(PlayType.DISCARD);
		}
		if (box.getNumberToken(new Token(Color.BLUE)) > 0) {
			model.add(PlayType.HINT);
		}
	}

	public PlayTypeList getModel() {
		return model;
	}

	public PlayTypeView getView() {
		return view;
	}

	public void showPossiblePlays(Box box, Board board) {
		setPlayTypes(box, board);
		view.showPossiblePlays(model);
		updateView();
	}

	@Override
	public void updateView() {
		view.draw();
	}

}
