package com.skilldistillery.blackjack.app;

import java.util.Scanner;

import com.skilldistillery.blackjack.entities.BlackjackHand;
import com.skilldistillery.blackjack.entities.Dealer;
import com.skilldistillery.blackjack.entities.Player;

public class BlackJackApp {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		BlackJackApp app = new BlackJackApp();
		app.showRules();
		app.firstHands(scanner);
		app.playAgain(scanner);
	}

	public void showRules() {

		System.out.println("\t$$$$$ Welcome to the Blackjack Table $$$$$");
		System.out.println();
		System.out.println("\t     # The table rules are as follows #");
		System.out.println(" -Aces are worth 11");
		System.out.println(" -Face cards are worth 10");
		System.out.println(" -All other card values are the cards numeric value.");
		System.out.println(" -You are playing against the dealer, the objective is to get a total of 21");
		System.out.println(" -Or closer to 21 than the dealer, if you go over 21 you bust and loose.");
		System.out.println(" -Hit means you add a random card from the deck to your hand.");
		System.out.println(" -Stay means you do nothing and pass the turn onto the Dealer.");
		System.out.println();
		System.out.println("\t\t$$$$$ Goodluck! $$$$$");
		System.out.println();
	}

	public void firstHands(Scanner scanner) {
		Dealer dealer = new Dealer();
		Player player = new Player();
		dealer.grabDeck();
		System.out.println("Enter any key to continue.");
		scanner.next();
		scanner.nextLine();

		System.out.println("*** The dealer shuffles the deck. ***\n");
		dealer.shuffleIt();

		System.out.println("*** The dealer begins to deal the hands. ***\n");
		player.addCard(dealer.dealHand());

		System.out.println("Your first card is: " + player.getHand() + " Total value: " + player.getHandValue() + "\n");

		dealer.addDealerFirstCard(dealer.dealHand());

		System.out.println("*** The dealers first card is face down. ***\n");

		player.addCard(dealer.dealHand());

		System.out.println("Your hand is: " + player.getHand() + " Total value: " + player.getHandValue() + "\n");

		dealer.addDealerCard(dealer.dealHand());
		
		dealer.displayOneCard();

		String userChoice;
		boolean keepHitting = true;
		while (keepHitting) {
			
			if (player.getHand() instanceof BlackjackHand && ((BlackjackHand)(player.getHand())).isBust()) {
				System.out.println("==============================");
				System.out.println("== You busted, Dealer wins! ==");
				System.out.println("==============================");
				keepHitting = false;
				BlackJackApp blackJackApp = new BlackJackApp();
				blackJackApp.playAgain(scanner);
			} else if (player.getHand() instanceof BlackjackHand && ((BlackjackHand)(player.getHand())).isBlackjack()) {
				System.out.println("================");
				System.out.println("== You got 21 ==");
				System.out.println("================");

//				BlackJackApp blackJackApp = new BlackJackApp();
//				blackJackApp.playAgain(scanner);
				keepHitting = false;

			} else {
				System.out.println("\nWhat would you like to do?");
				System.out.print("Hit? or Stay? ");
				userChoice = scanner.nextLine();

				switch (userChoice) {
				case "Hit":
				case "hit":
				case "h":
					player.addCard(dealer.dealHand());
					System.out.println(
							"Your hand is: " + player.getHand() + " Total value: " + player.getHandValue() + "\n");
					break;

				case "Stay":
				case "stay":
				case "s":
					keepHitting = false;
					break;
				}
			}
		}
		boolean dealerHitting = true;
		System.out.println("\n*** The dealer flips the facedown card ***");
		while (dealerHitting) {
			if (dealer.getDealerHand() instanceof BlackjackHand && ((BlackjackHand)dealer.getDealerHand()).isBust()) {
				System.out.println("=================================");
				System.out.println("== The dealer busted. You win! ==");
				System.out.println("=================================");
				dealerHitting = false;
				
			} 
			while (dealer.getDealerHandValue() < 17) {
				System.out.println("The dealer chooses to hit...");
				dealer.addDealerCard(dealer.dealHand());
				System.out.println("The dealers hand is: " + dealer.getDealerHand() + " Value: " + dealer.getDealerHandValue() + "\n");
			}
			 if (dealer.getDealerHandValue() >= 17 && dealer.getDealerHandValue() < 21) {
				System.out.println("The dealer chooses to stay...");
				System.out.println(
						"The dealers hand is " + dealer.getDealerHand() + " Value: " + dealer.getDealerHandValue() + "\n");
				dealerHitting = false;
			}
				
			if (dealer.getDealerHandValue() > player.getHandValue() && dealer.getDealerHandValue() < 21) {
				System.out.println("=====================");
				System.out.println("== The dealer won! ==");
				System.out.println("=====================");
				dealerHitting = false;

			} if (player.getHandValue() > dealer.getDealerHandValue() && player.getHandValue() < 21) {
				System.out.println("==============");
				System.out.println("== You won! ==");
				System.out.println("==============");
				dealerHitting = false;

			}  if (player.getHandValue() == dealer.getDealerHandValue()) {
				System.out.println("=================");
				System.out.println("== It's a tie! ==");
				System.out.println("=================");
				dealerHitting = false;

			} else if (dealer.getDealerHand() instanceof BlackjackHand && ((BlackjackHand)dealer.getDealerHand()).isBlackjack()) {
				System.out.println("=====================================");
				System.out.println("== The dealer has 21. Dealer wins! ==");
				System.out.println("=====================================");
				dealerHitting = false;

			} else if(player.getHand() instanceof BlackjackHand && ((BlackjackHand)player.getHand()).isBlackjack()) {
				System.out.println("==========================");
				System.out.println("== You got 21. You win! ==");
				System.out.println("==========================");
				dealerHitting = false;
			}

		}

	}

	public void playAgain(Scanner scanner) {
		System.out.println("Would you like to play again? Yes or No?");
		String keepPlaying = scanner.nextLine();
		switch (keepPlaying) {
		case "YES":
		case "Yes":
		case "yes":
		case "Y":
		case "y":
			main(null);
			break;

		case "NO":
		case "No":
		case "no":
		case "N":
		case "n":
			System.out.println("Thank you for playing!");
			break;
		}
	}

}
