//************************************************************************
//  Deck.java
//  Developer:  Vijay
//  Purpose:
//	Represents an 116-card Five Crowns deck.  It uses an 116-element 
//  array of Card objects.
//************************************************************************

import java.util.Random;

final public class Deck
{

	//***********************************************************************************
	//  Instance variables
	//		Constants are defined for numeric literals which will be used
	//		Notice several constants are declared as static so that only one copy of these
	//		static variables are kept in memory for all instances of a card deck in lieu of
	//		one copy for each deck.
	//
	//		deck is an array of Five Crowns Cards (116 cards)
	//		cardsNotDealt is an integer which tracks the number of cards left undealt
	//***********************************************************************************
	
	private static final int NUMBER_OF_CARDS = 116;
	private static final int LOWEST_CARD_IN_DECK = 3;
	private static final int HIGHEST_CARD_IN_DECK = 13;
	private static final int JOKER_FACE_VALUE = 14;
	private static final int JOKER_SUIT_VALUE = 0;
	private static final int NUMBER_OF_SUITS = 5;
	private static final int NUMBER_OF_IDENTICAL_CARDS = 2;
	private static final int NUMBER_OF_JOKERS = 6;
	
	private Card[] deck = new Card[NUMBER_OF_CARDS];
	private int cardsNotDealt;

	//***********************************************************************************
	//  Constructor
	//		It loads the array with the correct suit and face value for a deck used
	//      in Five Crowns.  
	//***********************************************************************************

	public Deck()
	{
		//--------------------------------------
		//  Default constructor.
		//--------------------------------------
		int cardIndex = 0;
		cardsNotDealt = NUMBER_OF_CARDS;
		
		//--------------------------------------
		//  There are 2 copies of each card in the deck (except jokers)
		//--------------------------------------
	    for (int copy = 1; copy <= NUMBER_OF_IDENTICAL_CARDS; copy++)
		{
			for (int suit = 1; suit <= NUMBER_OF_SUITS; suit++)
			{	
				for (int face = LOWEST_CARD_IN_DECK; face <= HIGHEST_CARD_IN_DECK; face++)
				{	deck[cardIndex] = new Card(suit, face);
					cardIndex++;
				}
			}
		}
		
		//--------------------------------------
		//  Create the Jokers
		//--------------------------------------	
		for (int i = 1; i <= NUMBER_OF_JOKERS; i++)
		{	deck[cardIndex] = new Card(JOKER_SUIT_VALUE,JOKER_FACE_VALUE);
			cardIndex++;
		}
	}

	//***********************************************************************************
	//  Mutator to simulate shuffling the cards.  This is done by randomly swapping
	//  cards in the deck.
	//***********************************************************************************

	public void shuffle()
	{	int swapIndex;
		Card temp;
		Random gen = new Random();

		for (int number_of_shuffles = 1; number_of_shuffles < 3; number_of_shuffles++)
		{
			for (int i = 0; i < NUMBER_OF_CARDS; i++)
			{
				swapIndex = gen.nextInt(NUMBER_OF_CARDS) ;
				temp = new Card(deck[i].getSuit(), deck[i].getFace());
				deck[i] = deck[swapIndex];
				deck[swapIndex] = temp;
			}
		}
		
		cardsNotDealt = NUMBER_OF_CARDS;
	}
	
	
	//***********************************************************************************
	// Accessors for other classes to be able to retrieve the number of cards in the deck
	// and the number of cards yet to be dealt.
	//***********************************************************************************
	public int getNumberOfCards()
	{	return NUMBER_OF_CARDS;	}

	public int getNumberOfCardsNotDealt()
	{	return cardsNotDealt;	}


	//***********************************************************************************
	// Method to deal one card from the deck
	//***********************************************************************************

	public Card dealOneCard()
	{	Card nextCard = null;
		if (cardsNotDealt > 0)
		{	nextCard = deck[NUMBER_OF_CARDS-cardsNotDealt];
			cardsNotDealt--;
		}
		return nextCard;
	}
	//***********************************************************************************
	//  toString Method
	//***********************************************************************************

 	public String toString()
 	{	String deckString = "";

		for (int i = 0; i < NUMBER_OF_CARDS; i++)
			 deckString += i + " " + deck[i].toString() + "\n";
		return (deckString);
	}
}

