package com.skilldistillery.blackjack.entities;

public class Dealer extends Player{
private Deck deck;
//private Hand dealerhand;
	public Dealer() {
	this.deck = new Deck();
//	this.dealerhand = new BlackjackHand(); 
	}
	public void displayOneCard() {
		System.out.println("The dealers has one card face up " + bjHand.getHand().get(1) + " Value: " + bjHand.getHand().get(1).getValue());
	}
	
	public Dealer (BlackjackHand dealerhand) {
		this.bjHand = dealerhand;
	}
	
	public void grabDeck() {
		this.deck.makeDeck();
	}
	
	public void shuffleIt() {
		deck.shuffle();
	}
	
	public Card dealHand() {
		
		return deck.dealCard();
	}
	
	public void addDealerFirstCard(Card cardToAdd) {
		bjHand.addCard(cardToAdd);

	}
	public void addDealerCard(Card cardToAdd) {
		bjHand.addCard(cardToAdd);
	}
	public Hand getDealerHand() {
		return this.bjHand;
	}
	public void setDealerHand(BlackjackHand dealerhand) {
		this.bjHand = dealerhand;
	}
	public int getDealerHandValue() {
		return bjHand.getHandValue();
	}
	public Card getDealersSecondCard() {
		
		for(int i = 1; i < bjHand.getHand().size(); i++) {
			
			return bjHand.getHand().get(i);
		}
		return null;
	}
}
