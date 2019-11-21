package fr.umlv.igm.hanabi.classes;

public class Board extends Box {

	private final BoardCards cards = new BoardCards();

	public Board() {
		super(0, 3);
	}

	public void add(Card card) {
		cards.add(card);
	}

	@Override
	public String typeOfBox() {
		// TODO Auto-generated method stub
		return "Board";
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() +"\nBoard cards : "+ cards;
	}
}
