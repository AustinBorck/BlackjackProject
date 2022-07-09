package com.skilldistillery.blackjack.entities;

public class Dealer extends Player{
private Deck deck;
private Hand dealerhand;
	public Dealer() {
	this.deck = new Deck();
	this.dealerhand = new BlackjackHand(); 
	}
	
	public Dealer (Hand dealerhand) {
		this.dealerhand = dealerhand;
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
		dealerhand.addCard(cardToAdd);

	}
	public void addDealerCard(Card cardToAdd) {
		dealerhand.addCard(cardToAdd);
	}
	public Hand getDealerHand() {
		return this.dealerhand;
	}
	public void setDealerHand(Hand dealerhand) {
		this.dealerhand = dealerhand;
	}
	public int getDealerHandValue() {
		return dealerhand.getHandValue();
	}
	public Card getDealersSecondCard() {
		
		for(int i = 1; i <= dealerhand.hand.size(); i++) {
			
			return dealerhand.hand.get(i);
		}
		return dealerhand.hand.get(1);
	}
}
