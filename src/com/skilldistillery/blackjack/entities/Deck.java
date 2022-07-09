package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	private List<Card> deck = new ArrayList<>(52); 
	
	public Deck() {
	}
	public List<Card> makeDeck(){	
		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();
		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				Card card = new Card(suit, rank);
				deck.add(card);
				}
			}
		return deck;
		}
	
		public void shuffle() {
			Collections.shuffle(deck);
		}
		
		public int checkDeckSize() {
			return deck.size();
		}
		
		public Card dealCard() {
			Card card = deck.remove(0);
			return card;
		}
		
		public void dealCard(Hand hand) {
			
		}
		
	}
	
