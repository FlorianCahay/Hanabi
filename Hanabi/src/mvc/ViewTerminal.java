package mvc;

public class ViewTerminal implements View {
	private StringBuilder print = new StringBuilder();

	public void separator() {
		print.append("----------------------------------\n");
	}

	public void append(String text) {
		print.append(text);
	}

	public void append(int text) {
		print.append(text);
	}

	public void draw() {
		System.out.println(print);
		print = new StringBuilder();
	}
}
