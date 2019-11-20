package fr.umlv.igm.hanabi;

import java.util.Random;

public class Deck extends AbstractCardList {

	public Deck() {
		for (Color color : Color.values()) {
			for (int i = 0; i < 10; i++) {
				if (i < 3) {
					add(new Card(1, color));
				} else if (i < 5) {
					add(new Card(2, color));
				} else if (i < 7) {
					add(new Card(3, color));
				} else if (i < 9) {
					add(new Card(4, color));
				} else {
					add(new Card(5, color));
				}
			}
		}
	}

	public Card pickCard() {
		Random rand = new Random();
		return remove(rand.nextInt(size()));
	}

}
