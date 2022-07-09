package com.skilldistillery.blackjack.entities;


public class BlackjackHand extends Hand {
	public BlackjackHand() {
		super();
	}

	public int getHandValue() {
		int total = 0;
		for (Card card : hand) {
			total += card.getValue();
		}
		return total;
	}

	public boolean isBlackjack() {
		if (this.getHandValue() == 21) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isBust() {
		if (this.getHandValue() > 21) {
			return true;
		} else {
			return false;
		}
	}

}
