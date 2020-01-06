package tokens;

import mvc.ViewTerminal;

public class BoxViewTerminal extends ViewTerminal implements BoxView {
	public void showBox(Box box) {
		System.out.println(box);
	}
}
