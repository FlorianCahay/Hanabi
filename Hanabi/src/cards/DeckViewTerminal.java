package cards;

import mvc.ViewTerminal;

public class DeckViewTerminal extends ViewTerminal implements DeckView {
	public void showRemainingCards(int numberCards) {
		System.out.println("Remaining cards in deck : " + numberCards);
	}
}
