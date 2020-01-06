package cards;

import mvc.ViewTerminal;

public class DeckViewTerminal extends ViewTerminal implements DeckView {
	public void showRemainingCards(int numberCards) {
		append("Remaining cards in deck : ");
		append(numberCards);
	}
}
