package input;

import mvc.ViewTerminal;

public class ScannerSystemInView extends ViewTerminal {
	public void error(String error) {
		append("ERROR : ");
		append(error);
	}
}
