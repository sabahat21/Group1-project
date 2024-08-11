/**
 * @author Sabahat Faheem, Ekenedilichukwu Nwume, Muhammad Ansari
 * Group 1-Fundamentals of Software Design and Development SYST 17796
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

//MVC pattern is implemented through Model,View and Controller class.
public class GameController {
    private Game model; //instatiate model object
    private GameView view; //instantiate view object
//Constructor to create the instances.
    public GameController(Game model, GameView view) {
        this.model = model;
        this.view = view;
    }
//startGame method to start the game in Controller class
    public void startGame() {
        view.displayMessage("Welcome to the Blackjack Game!");
//add player to the game by calling add player method in game model
        addPlayers();
        model.initialDeal();//to distribute card initially
        updateView();//update the view, display the game state
//game logic to calculate points based on game rules if score reaches 21 then
//announce the black jack (win)
        for (Player player : model.getPlayers()) {
            if (player.calculateScore() == 21) {
                view.displayMessage(player.getName() + " has a Blackjack!");
                player.addPoint();
                continue;
            }
            //if player decides to continue
            boolean keepPlaying = true;
            //when score <21 and player continues to play
            while (keepPlaying && player.calculateScore() < 21) {
                String input = view.getPlayerChoice(player);
                if (input.equalsIgnoreCase("hit")) {
                    player.drawCard(model.getDeck());
                    view.displayMessage(player.getName() + "'s new hand: " + player.getHand() + " (Score: " + player.calculateScore() + ")");
                } else if (input.equalsIgnoreCase("stand")) {
                    keepPlaying = false;
                } else {
                    view.displayMessage("Invalid command. Please try again.");
                }
            }
        //when score > 21 then player loses
            if (player.calculateScore() > 21) {
                view.displayMessage(player.getName() + " has gone bust!");
            }
        }
//calling methods from controller to play Dealer's turn
        playDealerTurn();
        determineWinners();// determine the winner
        //End the game with message
        view.displayMessage("Thank you for playing!");
    }
//define addPlayer method, get # of players after prompting the user.
    private void addPlayers() {
        int numberOfPlayers = view.getNumberOfPlayers();
//storing player's information.
        for (int i = 1; i <= numberOfPlayers; i++) {
            String playerName = view.getPlayerName(i);
            model.addPlayer(new Player(playerName));
        }
    }
//method to play the dealer's turn.
    private void playDealerTurn() {
        //create player as dealer
        Player dealer = model.getDealer();
//if dealer scores 17 then dealer wins otherwise continue to play the game
        while (dealer.calculateScore() < 17) {
            dealer.drawCard(model.getDeck());
        }
        view.displayMessage("Dealer's hand: " + dealer.getHand() + " (Score: " + dealer.calculateScore() + ")");
    }
//After each turn to calculate the score and determine winner.
    private void determineWinners() {
        Player dealer = model.getDealer();
        int dealerScore = dealer.calculateScore();

        for (Player player : model.getPlayers()) {
            int playerScore = player.calculateScore();
            if (playerScore > 21) {
                view.displayMessage(player.getName() + " busts and loses.");
            } else if (dealerScore > 21 || playerScore > dealerScore) {
                view.displayMessage(player.getName() + " wins!");
                player.addPoint();
            } else if (playerScore == dealerScore) {
                view.displayMessage(player.getName() + " ties with the dealer.");
            } else {
                view.displayMessage(player.getName() + " loses.");
            }
        }
        view.displayFinalState(model);
    }
//update the game state by displaying the player's and dealer score.
    private void updateView() {
        view.displayGameState(model);
    }
}


