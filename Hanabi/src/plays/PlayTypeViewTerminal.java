package plays;

import cards.Card;
import mvc.ViewTerminal;

public class PlayTypeViewTerminal extends ViewTerminal implements PlayTypeView {
	public void showPossiblePlays(PlayTypeList plays) {
		separator();
		append(plays.toString());
	}

	public void askWhichPlayer() {
		append("To which player do you want to give a hint ?");
	}

	public void askColorOrValue() {
		append("1 : Color\n");
		append("2 : Value\n");
		append("Write down what type of hint you want to give :");
	}

	public void askColor() {
		append("Write down an existing card color in CAPITALS :");
	}

	public void askValue() {
		append("Write down an existing card value :");
	}

	public void askCard() {
		append("Which card do you want from your hand ? (write down card position, start at 1)");
	}

	public void showPlayedCard(Card card) {
		append(card.toString());
		append(" has been played");
	}

	public void showDiscardedCard(Card card) {
		append(card.toString());
		append(" has been discarded");
	}
}
