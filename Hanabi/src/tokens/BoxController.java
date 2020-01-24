package tokens;

/**
 * Represents an interface to manage the box view and the box model
 * 
 * @author Cahay-Durand
 *
 */
public class BoxController {
	private final Box model;
	private final BoxView view;

	/**
	 * Constructs box controller
	 * 
	 * @param model Box model
	 * @param view  Box view
	 */
	public BoxController(Box model, BoxView view) {
		this.model = model;
		this.view = view;
	}

	/**
	 * Gets box model
	 * 
	 * @return model
	 */
	public Box getModel() {
		return model;
	}

	/**
	 * Draws the box
	 */
	public void showBox() {
		view.showBox(model);
	}

}
