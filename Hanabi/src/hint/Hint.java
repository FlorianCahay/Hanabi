package hint;

/**
 * Represents a hint that can be read
 * 
 * @author Cahay-Durand
 *
 */
public class Hint {
	private String hint;
	private boolean read;

	/**
	 * Constructs a void hint
	 */
	public Hint() {
		this.read = true;
	}

	/**
	 * Constructs a hint with content
	 * 
	 * @param hint Message to stock
	 */
	public Hint(String hint) {
		this.hint = hint;
		this.read = false;
	}

	/**
	 * Reads the hint
	 * 
	 * @return Hint message
	 */
	public String readHint() {
		if (read == true) {
			return "None";
		}
		read = true;
		return hint;
	}

	/**
	 * Sets the hint with a message
	 * 
	 * @param hint Message to stock
	 */
	public void setHint(String hint) {
		this.hint = hint;
		read = false;
	}
}
