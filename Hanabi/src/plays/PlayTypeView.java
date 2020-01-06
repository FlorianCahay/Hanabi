package plays;

import cards.Card;

public interface PlayTypeView {
	public void showPossiblePlays(PlayTypeList plays);

	public void askWhichPlayer();

	public void askColorOrValue();

	public void askColor();

	public void askValue();

	public void askCard();

	public void showPlayedCard(Card card);

	public void showDiscardedCard(Card card);
}
