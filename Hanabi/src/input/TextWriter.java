package input;

public class TextWriter {

	private String text = new String();

	public void reset() {
		text = new String();
	}

	public void append(String string) {
		if (text.length() < 20) {
			text += string;
		}
	}

	public String textLessLast() {
		return text.subSequence(0, text.length() - 1).toString();
	}

	public String lastCharacter() {
		return text.substring(text.length() - 1);
	}

	@Override
	public String toString() {
		return text;
	}
}
