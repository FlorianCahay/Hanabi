package plays;

import cards.Card;
import mvc.ViewTerminal;

public class PlayTypeViewTerminal extends ViewTerminal implements PlayTypeView {
	public void showPossiblePlays(PlayTypeList plays) {
		separator();
		System.out.println(plays);
	}

	public void askWhichPlayer() {
		System.out.println("To which player do you want to give a hint ?");
	}

	public void askColorOrValue() {
		System.out.println("1 : Color\n" + "2 : Value\n" + "Write down what type of hint you want to give :");
	}

	public void askColor() {
		System.out.println("Write down an existing card color in CAPITALS :");
	}

	public void askValue() {
		System.out.println("Write down an existing card value :");
	}

	public void askCard() {
		System.out.println("Which card do you want from your hand ? (write down card position, start at 1)");
	}

	public void showPlayedCard(Card card) {
		System.out.println(card.toString() + " has been played");
	}

	public void showDiscardedCard(Card card) {
		System.out.println(card.toString() + " has been discarded");
	}
}
