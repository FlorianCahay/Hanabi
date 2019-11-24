package fr.umlv.igm.hanabi.classes;

public class Board extends Box {

	private final BoardCards cards = new BoardCards();

	public Board() {
		super(0, 3);
	}

	public void playCard(Card card) {
		cards.add(card);
	}

	public boolean isPlayable(Card c) {
		if (cards.contains(c)) {
			return false;
		}
		if (c.getValue() == 1) {
			return true;
		}
		if (!cards.contains(new Card(c.getValue() - 1, c.getColor()))) {
			return false;
		}
		return true;
	}

	@Override
	public String typeOfBox() {
		// TODO Auto-generated method stub
		return "Board";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\nBoard cards : " + cards;
	}
}
