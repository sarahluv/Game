/*******************************************************************************
Name: Sarah Redmon
Date: 1/22/19
Instructor: Ms. Tucker
Class: Card
Purpose: To display & show points of cards based on suit and face
*******************************************************************************
*/

/*------------------------------------------------------------------------------
    FEEDBACK FROM INSTRUCTOR:
    Sarah, this is very good!  Make sure the getSuitName() for a Joker does not 
    return "Joker".  Jokers do not have a suit.  Use an empty string "".  
    Otherwise, VERY nicely done.
-------------------------------------------------------------------------------*/

public class Card
{
    private int suit;
    private int face;
    private int points;

    public Card (int suit, int face)
    {      
        /*------------------------------------------------------------------------------
        Constructor: does parameters on cards based on suit and face
        ------------------------------------------------------------------------------
        */
        if (suit >= 0 && suit <= 5) {
            this.suit = suit;
        } else {
            this.suit = -1;
        }
        if (face >= 3 && face <= 14) {
            this.face = face;
        } else {
            this.face = -1;
        }
        if ((suit >= 0 && suit <= 5) && (face >= 3 && face <= 14)) {
            setPoints(points);
        } else {
            this.points = 0;
        }
    }

    public int getSuit()
    {
        /*------------------------------------------------------------------------------
        Accessor: returns suit
        ------------------------------------------------------------------------------
        */
        return suit;
    }
    public int getFace()
    {
        /*------------------------------------------------------------------------------
        Accessor: returns face
        ------------------------------------------------------------------------------
        */
        return face;
    }
    public int getPoints()
    {
        /*------------------------------------------------------------------------------
        Accessor: returns points
        ------------------------------------------------------------------------------
        */
        return points;
    }
    
    public String getSuitName()
    {
        /*------------------------------------------------------------------------------
        Helping Method: gets suit name based on suit number
        ------------------------------------------------------------------------------
        */
        switch (suit) {
        case 1:
        return "Spades";
        case 2:
        return "Hearts";
        case 3:
        return "Clubs";
        case 4:
        return "Diamonds";
        case 5:
        return "Stars";
        default:
        return ""; //previously "Joker"
        }
    }
    public String getFaceName()
    {
        /*------------------------------------------------------------------------------
        Helping Method: gets face name based on face number
        ------------------------------------------------------------------------------
        */
        switch (face) {
        case 3:
        return "3";
        case 4:
        return "4";
        case 5:
        return "5";
        case 6:
        return "6";
        case 7:
        return "7";
        case 8:
        return "8";
        case 9:
        return "9";
        case 10:
        return "10";
        case 11:
        return "Jack";
        case 12:
        return "Queen";
        case 13:
        return "King";
        default:
        return ""; //previously "Joker"
        }
    }
    public void setPoints(int point)
    {
        /*------------------------------------------------------------------------------
        Helping Method: adds points up based on face of cards
        ------------------------------------------------------------------------------
        */
        if (face == 3) {
            points = points + 3;
        }
        else if (face == 4) {
            points = points + 4;
        }
        else if (face == 5) {
            points = points + 5;
        }
        else if (face == 6) {
            points = points + 6;
        }
        else if (face == 7) {
            points = points + 7;
        }
        else if (face == 8) {
            points = points + 8;
        }
        else if (face == 9) {
            points = points + 9;
        }
        else if (face == 10) {
            points = points + 10;
        }
        else if (face == 11) {
            points = points + 11;
        }
        else if (face == 12) {
            points = points + 12;
        }
        else if (face == 13) {
            points = points + 13;
        }
        else if (face == 14) {
            points = points + 50;
        }
    }
    
    public String toString()
    {
        /*------------------------------------------------------------------------------
        toString() Method: returns face name & suit name (face only for Joker as face)
        ------------------------------------------------------------------------------
        */
        if (face == 14) {
            return getFaceName();
        } else {
            return getFaceName() + " of " + getSuitName();
        }
    }
}
