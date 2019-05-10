//************************************************************************
//	CrownGame.java
//  Developer:  Sondra
//  Purpose:	Review of Java classes and illustration of an array of objects
//
//	Creates a deck of Five Crown cards and deals the cards to the players.
//  This card game can be played with 1 - 7 players
//
//	This application does not actually play the game.
//************************************************************************


import java.util.Scanner;

public class CrownGame
{
	public static void main (String[] args)
	{
		Scanner in = new Scanner (System.in);

		//-----------------------------------------------------------------------------------------------
		// Declarations and Instantiations
		//-----------------------------------------------------------------------------------------------

		Deck newDeck = new Deck();
		Card tempCard;
		int numberOfPlayers = 0;
		int roundToDeal = 0;
		int numberOfCardsInDeck = newDeck.getNumberOfCards();
		int playerIndex = 0;
		int cardIndex = 0;
		final int FEWEST_PLAYERS = 1;
		final int MOST_PLAYERS = 7;
		final int LOWEST_ROUND = 3;
		final int HIGHEST_ROUND = 13;

		//-----------------------------------------------------------------------------------------------
		// Shuffle the card deck and input the number of players
		//-----------------------------------------------------------------------------------------------

		newDeck.shuffle();

		//-----------------------------------------------------------------------------------------------
		// For testing input the number of players and the round being played
		//-----------------------------------------------------------------------------------------------
	
		while(numberOfPlayers < FEWEST_PLAYERS || numberOfPlayers > MOST_PLAYERS)
		{	System.out.print("Number of players for the game (enter a number between 1-7): " );
			numberOfPlayers = in.nextInt();
		}

		while(roundToDeal < LOWEST_ROUND || roundToDeal > HIGHEST_ROUND)
		{	System.out.print("Which round would you like to deal (enter a number between 3 - 13): " );
			roundToDeal = in.nextInt();
		}
		
		//-----------------------------------------------------------------------------------------------
		// Create two-dimensional array to hold cards dealt to players.
		// Rows represent cards (1st card, 2nd card, etc.) and columns represent players (1st player, etc).
		//-----------------------------------------------------------------------------------------------
		Card[][] players = new Card[numberOfPlayers][roundToDeal];

		//-----------------------------------------------------------------------------------------------
		// Structure to deal the cards from the deck
		//-----------------------------------------------------------------------------------------------

		for (int cardCount = 0; cardCount < roundToDeal; cardCount++)
			for (int playerCount = 0; playerCount < numberOfPlayers; playerCount++)
			{	
				tempCard = newDeck.dealOneCard();
				players[playerCount][cardCount] = new Card(tempCard.getSuit(), tempCard.getFace());
			}

		//-----------------------------------------------------------------------------------------------
		// Structure to display each players cards and total points.
		//-----------------------------------------------------------------------------------------------

		for (int playerCount = 0; playerCount < numberOfPlayers; playerCount++)
		{	System.out.println("\n\nCards for player " + (playerCount+1) + ":");
			int playerCardTotal = 0;
			int points = 0;
			for (int cardCount = 0; cardCount <roundToDeal; cardCount++)
			{	points = players[playerCount][cardCount].getPoints();
				System.out.println("\t" + players[playerCount][cardCount].toString());
				playerCardTotal += points;
				
			}
			System.out.println("\tTotal points: " + playerCardTotal);
		}
		
		System.out.println("\nTesting Accessors: " + players[0][0].getFaceName() + " of " + players[0][0].getSuitName());


	}

}
