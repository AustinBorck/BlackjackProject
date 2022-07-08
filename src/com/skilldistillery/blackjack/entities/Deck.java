package com.skilldistillery.blackjack.entities;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
	List<Card> deck = new ArrayList<>(); 

	public Deck() {
		Suit[] suits = Suit.values();
		Rank[] ranks = Rank.values();
		for (Suit suit : suits) {
			for (Rank rank : ranks) {
				Card card = new Card(suit, rank);
				deck.add(card);
				}
			}
		}
		public void shuffle() {
			Collections.shuffle(deck);
		}
		public int checkDeckSize() {
			return deck.size();
		}
		public Card deal() {
			Card card = deck.remove(0);
			return card;
		}
	}
	
