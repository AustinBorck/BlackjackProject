package com.skilldistillery.blackjack.entities;

public class Player {
	BlackjackHand bjHand = new BlackjackHand();
	private Hand hand;
	
	public Player(){
		this.hand = new BlackjackHand();
	}
	public Player (Hand hand) {
		this.hand = hand;
	}
	public void addCard(Card cardToAdd) {
		hand.addCard(cardToAdd);
	}

	public Hand getHand() { 
		return this.hand;
	}

	public void setHand(Hand hand) {
		this.hand = hand;
	}
	public int getHandValue() {
		return hand.getHandValue();
	}
	
}
