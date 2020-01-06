package input;

import mvc.ViewTerminal;

public class ScannerSystemInView extends ViewTerminal {
	public void error(String error) {
		System.out.println("ERROR : " + error);
	}
}
