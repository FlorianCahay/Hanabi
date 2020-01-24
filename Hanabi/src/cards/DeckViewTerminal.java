package cards;

import mvc.ViewTerminal;

/**
 * Represents a terminal deck view
 * 
 * @author Cahay-Durand
 *
 */
public class DeckViewTerminal extends ViewTerminal implements DeckView {
	
	public void showRemainingCards(int numberCards) {
		System.out.println("Remaining cards in deck : " + numberCards);
	}
}
