/**
 * @author Sabahat Faheem, Ekenedilichukwu Nwume, Muhammad Ansari
 * Group 1-Fundamentals of Software Design and Development SYST 17796
 */
package ca.sheridancollege.project;

import java.util.ArrayList;
//Player class to model each player contains name of player, hand and points.
public class Player {
    private String name;
    private ArrayList<Card> hand;
    private int points;
//constructor to create the player object.
    public Player(String name) {
        this.name = name;
        this.hand = new ArrayList<>();
        this.points = 0;
    }
//return player name.
    public String getName() {
        return name;
    }
//return player's hand to assign the group of card to the player
    public ArrayList<Card> getHand() {
        return hand;
    }
//draw card from deck and adding to the player's hand.
    public void drawCard(GroupOfCards deck) {
        Card card = deck.drawCard();
        if (card != null) {
            hand.add(card);
        }
    }
//calculate the player's score.
    public int calculateScore() {
        int score = 0;
        int aceCount = 0;
        for (Card card : hand) {
            score += card.getValue();
            if (card.getRank().equals("Ace")) {
                aceCount++;
            }
        }
        while (score > 21 && aceCount > 0) {
            score -= 10;
            aceCount--;
        }
        return score;
    }
//add points to player based on each turn.
    public void addPoint() {
        points++;
    }
//return points
    public int getPoints() {
        return points;
    }
//override toString method.
    @Override
    public String toString() {
        return name + "'s hand: " + hand + " (Score: " + calculateScore() + ")";
    }
}


