package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
	protected List<Card> hand = new ArrayList<>();

	public Hand() {
		super();
	}

	public List<Card> getHand() {
		return hand;
	}

	public void addCard(Card card) {
		hand.add(card);

	}

	public int getHandValue() {
		int value = 0;
		for (Card card : hand) {
			value += card.getValue();
		}
		return value;
	}

	@Override
	public String toString() {
		return "" + hand;
	}

	public void clearHands() {
		hand.removeAll(hand);
	}


}
