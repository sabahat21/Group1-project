/**
 * @author Sabahat Faheem, Ekenedilichukwu Nwume, Muhammad Ansari
 * Group 1-Fundamentals of Software Design and Development SYST 17796
 *
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ca.sheridancollege.project;

//main class to start the application
public class Main {
    public static void main(String[] args) {
        Game model = new Game(); //create model object
        GameView view = new GameView(); //create view object
        //create controller to interact with model and view.
        GameController controller = new GameController(model, view);
       //start the game by calling the method from controller class.
        controller.startGame();
    }
}


