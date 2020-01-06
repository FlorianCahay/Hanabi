package plays;

import board.Board;
import cards.Card;
import cards.Deck;
import colors.Color;
import input.Input;
import player.Player;
import player.Players;
import tokens.Box;
import tokens.Token;

public enum PlayType {
	HINT("Give a hint"), DISCARD("Discard a card"), PLAY("Play a card");

	private final String string;

	private PlayType(String string) {
		this.string = string;
	}

	public void play(Input input, Player actualPlayer, Players players, PlayTypeView view, Box box, Board board,
			Deck deck) {
		switch (this) {
		case HINT:
			hint(input, actualPlayer, players, view, box, board);
			break;
		case DISCARD:
			discard(view, input, actualPlayer, board, box, deck);
			break;
		case PLAY:
			playCard(view, board, box, deck, input, actualPlayer);
			break;
		default:
			throw new IllegalArgumentException("Unexpected value: " + this);
		}
	}

	@Override
	public String toString() {
		return string;
	}

	private void hint(Input input, Player actualPlayer, Players players, PlayTypeView view, Box box, Board board) {
		view.askWhichPlayer();
		view.draw();
		var player = input.getExistingPlayer(players, actualPlayer);
		view.askColorOrValue();
		view.draw();
		var choice = input.getValidInt("You can only give hint about color or value", 1, 2);
		if (choice == 1) {
			view.askColor();
			view.draw();
			player.setHint(input.getValidColor());
		} else {
			view.askValue();
			view.draw();
			player.setHint(input.getValidInt("Card value has to be include in [1,5]", 1, 5));
		}
		moveTokenHint(box, board);
	}

	private void moveTokenHint(Box box, Board board) {
		var token = new Token(Color.BLUE);
		if (box.remove(token)) {
			board.add(token, 1);
		}
	}

	private void discard(PlayTypeView view, Input input, Player actualPlayer, Board board, Box box, Deck deck) {
		view.askCard();
		view.draw();
		var card = input.getValidCardFromHand(actualPlayer);
		discardCard(board, box, new Token(Color.BLUE), actualPlayer, card, deck);
	}

	private void discardCard(Board board, Box box, Token token, Player actualPlayer, Card card, Deck deck) {
		if (board.remove(token)) {
			box.add(token, 1);
		}
		actualPlayer.discardCard(card);
		actualPlayer.pickCardInDeck(deck);
		board.addDiscardedCard(card);
	}

	private void playCard(PlayTypeView view, Board board, Box box, Deck deck, Input input, Player actualPlayer) {
		view.askCard();
		view.draw();
		var card = input.getValidCardFromHand(actualPlayer);
		if (playerPlayCard(card, board, box, actualPlayer, deck)) {
			view.showPlayedCard(card);
			view.draw();
			return;
		}
		view.showDiscardedCard(card);
		view.draw();
	}

	private boolean playerPlayCard(Card card, Board board, Box box, Player actualPlayer, Deck deck) {
		if (board.isAddable(card)) {
			actualPlayer.discardCard(card);
			actualPlayer.pickCardInDeck(deck);
			board.addCard(card);
			return true;
		}
		discardCard(board, box, new Token(Color.RED), actualPlayer, card, deck);
		return false;
	}
}
