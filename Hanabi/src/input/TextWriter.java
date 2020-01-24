package input;

/**
 * Represents a text wrote string by string
 * 
 * @author Cahay-Durand
 *
 */
public class TextWriter {

	private String text = new String();

	/**
	 * Resets the text
	 */
	public void reset() {
		text = new String();
	}

	/**
	 * Appends a string to the text
	 * 
	 * @param string String to append
	 */
	public void append(String string) {
		if (text.length() < 20) {
			text += string;
		}
	}

	/**
	 * Gets the text less the last character
	 * 
	 * @return text
	 */
	public String textLessLast() {
		return text.subSequence(0, text.length() - 1).toString();
	}

	/**
	 * Gets the last character
	 * 
	 * @return last character
	 */
	public String lastCharacter() {
		return text.substring(text.length() - 1);
	}

	@Override
	public String toString() {
		return text;
	}
}
