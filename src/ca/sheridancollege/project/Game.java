/*@author Sabahat Faheem, Ekenedilichukwu Nwume, Muhammad Ansari
 * Group 1-Fundamentals of Software Design and Development SYST 17796
*/
package ca.sheridancollege.project;

import java.util.ArrayList;
//Game class serves as the model has players array, dealer object
//and deck.
public class Game {
    private ArrayList<Player> players;
    private Player dealer;
    private GroupOfCards deck;
//constructor to create the game object.
    public Game() {
        this.players = new ArrayList<>();
        this.dealer = new Player("Dealer");
        this.deck = new GroupOfCards();
        initializeDeck();
    }
//add players to the game.
    public void addPlayer(Player player) {
        players.add(player);
    }
//specify the card properties, rank and values (numbers).
    private void initializeDeck() {
        String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
        String[] ranks = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
        int[] values = {2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 11};
//implements that a unique card is assigned to the player
        for (String suit : suits) {
            for (int i = 0; i < ranks.length; i++) {
                deck.addCard(new Card(suit, ranks[i], values[i]));
            }
        }
        //shuffle the group of cards (change the card position).
        deck.shuffle();
    }
//initial state of game to assign 2 cards to each player.
    public void initialDeal() {
        for (Player player : players) {
            player.drawCard(deck);
            player.drawCard(deck);
        }
        dealer.drawCard(deck);
        dealer.drawCard(deck);
    }
//Display all players in array list
    public ArrayList<Player> getPlayers() {
        return players;
    }
//return dealer.
    public Player getDealer() {
        return dealer;
    }
//return deck
    public GroupOfCards getDeck() {
        return deck;
    }
}

