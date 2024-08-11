/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/*@author Sabahat Faheem, Ekenedilichukwu Nwume, Muhammad Ansari
 * Group 1-Fundamentals of Software Design and Development SYST 17796
*/
package ca.sheridancollege.project;
//To display the message import Scanner.
import java.util.Scanner;
//View class of MVC pattern handles all statements to prompt the user.
public class GameView {
    private Scanner scanner;
//constructor to create the scanner object.
    public GameView() {
        this.scanner = new Scanner(System.in);
    }
//display the message passed by controller 
    public void displayMessage(String message) {
        System.out.println(message);
    }
//display the game state for all players and dealer.
    public void displayGameState(Game game) {
        for (Player player : game.getPlayers()) {
            System.out.println(player);
        }
        Player dealer = game.getDealer();
        System.out.println(dealer.getName() + "'s visible card: " + dealer.getHand().get(0));
    }
//display the final scores after game finishes.
    public void displayFinalState(Game game) {
        for (Player player : game.getPlayers()) {
            System.out.println(player);
        }
        System.out.println(game.getDealer());
    }

    //Prompt the user to number of players
    public int getNumberOfPlayers() {
        System.out.println("How many players will be playing?");
        return scanner.nextInt();
    }
    //prompt the user to store the player information.
    public String getPlayerName(int playerNumber) {
        System.out.println("Enter the name of player " + playerNumber + ":");
        scanner.nextLine();
        return scanner.nextLine();
    }
    //Ask the player to choose hit(draw card) or stand(stop)
    public String getPlayerChoice(Player player) {
        System.out.println(player.getName() + ", do you want to 'hit' or 'stand'?");
        return scanner.nextLine();
    }
}
