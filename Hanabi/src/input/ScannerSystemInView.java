package input;

import mvc.ViewTerminal;

/**
 * Represents the scanner view
 * 
 * @author flori
 *
 */
public class ScannerSystemInView extends ViewTerminal {
	/**
	 * Draws an error
	 * 
	 * @param error Error to show
	 */
	public void error(String error) {
		System.out.println("ERROR : " + error);
	}
}
