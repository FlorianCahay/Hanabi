package tokens;

public class BoxController {
	private final Box model;
	private final BoxView view;

	public BoxController(Box model, BoxView view) {
		this.model = model;
		this.view = view;
	}

	public Box getModel() {
		return model;
	}

	public void showBox() {
		view.showBox(model);
	}

}
