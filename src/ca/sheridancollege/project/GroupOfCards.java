/**
 * @author Sabahat Faheem, Ekenedilichukwu Nwume, Muhammad Ansari
 * Group 1-Fundamentals of Software Design and Development SYST 17796
 */
package ca.sheridancollege.project;
/**
 * A concrete class that represents any grouping of cards for a Game. 
 */
import java.util.ArrayList;
import java.util.Collections;
//Group of cards class contains cards array list.
public class GroupOfCards {
    private ArrayList<Card> cards;
//declare an array list of cards named as cards.
    public GroupOfCards() {
        this.cards = new ArrayList<>();
    }
//add card.
    public void addCard(Card card) {
        cards.add(card);
    }
//shuffle the cards collection.
    public void shuffle() {
        Collections.shuffle(cards);
    }
//draw card
    public Card drawCard() {
        return cards.isEmpty() ? null : cards.remove(0);
    }
//toString method to print the deck(group of cards)
    @Override
    public String toString() {
        return cards.toString();
    }
}

