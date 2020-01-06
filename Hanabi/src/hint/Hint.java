package hint;

public class Hint {
	private String hint;
	private boolean read;

	public Hint() {
		this.read = true;
	}

	public Hint(String hint, int value) {
		this.hint = hint;
		this.read = false;
	}

	public String readHint() {
		if (read == true) {
			return "None";
		}
		read = true;
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
		read = false;
	}
}
