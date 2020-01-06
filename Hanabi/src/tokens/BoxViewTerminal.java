package tokens;

import mvc.ViewTerminal;

public class BoxViewTerminal extends ViewTerminal implements BoxView {
	public void showBox(Box box) {
		append(box.toString());
	}
}
