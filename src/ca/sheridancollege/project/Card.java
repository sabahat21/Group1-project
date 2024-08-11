/*@author Sabahat Faheem, Ekenedilichukwu Nwume, Muhammad Ansari
 * Group 1-Fundamentals of Software Design and Development SYST 17796
*/
package ca.sheridancollege.project;

//Card class contains suit, rank and value is a concrete class to create card.
public class Card {
    private String suit;
    private String rank;
    private int value;
//Constructor to create the card.
    public Card(String suit, String rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
//getter for all three properties
    public String getSuit() {
        return suit;
    }

    public String getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }
//override toString method to print the card object.
    @Override
    public String toString() {
        return rank + " of " + suit;
    }
}


