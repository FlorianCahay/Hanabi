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

/**
 * Represents an enumerate of possible plays
 * 
 * @author flori
 *
 */
public enum PlayType {
	HINT("Give a hint"), DISCARD("Discard a card"), PLAY("Play a card");

	private final String string;

	/**
	 * Constructs a play with description
	 * 
	 * @param string Description
	 */
	private PlayType(String string) {
		this.string = string;
	}

	/**
	 * Makes a play depending on the play
	 * 
	 * @param input        Input system
	 * @param actualPlayer Playing player
	 * @param players      Players list
	 * @param view         Play type view
	 * @param box          Game box
	 * @param board        Game board
	 * @param deck         Game deck
	 */
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

	/**
	 * Makes hint play
	 * 
	 * @param input        Input system
	 * @param actualPlayer Playing player
	 * @param players      Players list
	 * @param view         Play type view
	 * @param box          Game box
	 * @param board        Game board
	 */
	private void hint(Input input, Player actualPlayer, Players players, PlayTypeView view, Box box, Board board) {
		view.askWhichPlayer();
		var player = input.getExistingPlayer(players, actualPlayer);
		view.askColorOrValue();
		var choice = input.getHintType("You can only give hint about color or value", 1, 2);
		if (choice == 1) {
			view.askColor();
			player.setHint(input.getValidColor());
		} else {
			view.askValue();
			player.setHint(input.getCardValue("Card value has to be include in [1,5]", 1, 5));
		}
		moveTokenHint(box, board);
	}

	/**
	 * Moves blue token from box to board
	 * 
	 * @param box   Game box
	 * @param board Game board
	 */
	private void moveTokenHint(Box box, Board board) {
		var token = new Token(Color.BLUE);
		if (box.remove(token)) {
			board.add(token, 1);
		}
	}

	/**
	 * Makes discard play
	 * 
	 * @param view         Play type view
	 * @param input        Input system
	 * @param actualPlayer Playing player
	 * @param board        Game board
	 * @param box          Game box
	 * @param deck         Game deck
	 */
	private void discard(PlayTypeView view, Input input, Player actualPlayer, Board board, Box box, Deck deck) {
		view.askCard();
		var card = input.getValidCardFromHand(actualPlayer);
		discardCard(board, box, new Token(Color.BLUE), actualPlayer, card, deck);
	}

	/**
	 * Discards card from player hand
	 * 
	 * @param board        Game board
	 * @param box          Game box
	 * @param token        Token to move
	 * @param actualPlayer Playing player
	 * @param card         Card to discard
	 * @param deck         Game deck
	 */
	private void discardCard(Board board, Box box, Token token, Player actualPlayer, Card card, Deck deck) {
		if (board.remove(token)) {
			box.add(token, 1);
		}
		actualPlayer.discardCard(card);
		actualPlayer.pickCardInDeck(deck);
		board.addDiscardedCard(card);
	}

	/**
	 * Makes play card play
	 * 
	 * @param view         Play type view
	 * @param board        Game board
	 * @param box          Game box
	 * @param deck         Game deck
	 * @param input        Input system
	 * @param actualPlayer Playing player
	 */
	private void playCard(PlayTypeView view, Board board, Box box, Deck deck, Input input, Player actualPlayer) {
		view.askCard();
		var card = input.getValidCardFromHand(actualPlayer);
		if (playerPlayCard(card, board, box, actualPlayer, deck)) {
			view.showPlayedCard(card);
			return;
		}
		view.showDiscardedCard(card);
	}

	/**
	 * Plays a player card
	 * 
	 * @param card         Card to play
	 * @param board        Game board
	 * @param box          Game box
	 * @param actualPlayer Playing player
	 * @param deck         Game deck
	 * @return True if card has been played, false otherwise
	 */
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
