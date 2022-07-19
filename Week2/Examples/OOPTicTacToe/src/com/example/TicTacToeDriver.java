package com.example;

import java.util.Scanner;

import com.example.models.Game;
import com.example.models.Player;
import com.example.models.TicTacToeGame;
import com.example.models.TicTacToePlayer;

public class TicTacToeDriver {
	
	public static void main(String args[]) {
		
		/*
		 * Scanner Class
		 * - Is how we can take in user input from the console without using arguments
		 * - This will be found in the java.utils package
		 * 
		 * The scanner needs some sort of input stream, we will be using the System.in stream
		 * which takes in user input from the console
		 * 
		 * The scanner class has methods for taking different types of information, whether it be numbers, string
		 * or entire lines of text
		 * 
		 */
		//We only ever want one input scanner in an application, because you might accidentally close them all
		Scanner input = new Scanner(System.in);
		
		//Game g = new Game();
		TicTacToeGame ticTacToe = new TicTacToeGame();
		
		System.out.println("Welcome to the game of: " + Game.NAME);
		
		//Cannot reassign the name
		//Game.NAME = "A different game";
		
		//To ask for/wait for user input we must call some method of the input object
		System.out.print("Player 1, please enter your name: ");
		
		//We can wait for the user to type in their name, and press enter
		String p1Name = input.nextLine();
		
		TicTacToePlayer p1 = new TicTacToePlayer(p1Name);
		
		//Upcasting, upcasting can be done automatically by java, because it is seen as safe, because
		//TicTacToe player HAS to have all the functionality of its parent
		Player upcast = new TicTacToePlayer("upcasting");
		TicTacToePlayer convertFromPlayer = (TicTacToePlayer) upcast;
		
		//Downcasting can be attempted with the parenthesis surrounding the type you want to cast it to
		//However, there is a change that java will be unable to cast this, leading to issues, and the programming not running
		//TicTacToePlayer downcast = (TicTacToePlayer) new Player("downcasting");
		
		Player p2 = new Player();
		
		//name is private, so we cannot access it from the Driver class
		//p1.name = "Ethan";
		//p1.setName(p1Name);
		//p1.setScore(0);
		p1.setSymbol('X');
		
		//p2 is just a Player object not a TicTacToePlayer object, so it does not have the symbol member
		//And it does not have the setter and getter for symbol
		//p2.setSymbol();
		System.out.println(p1);
		System.out.println(upcast);
		System.out.println(convertFromPlayer);
		System.out.println("Player 1 name: " + p1.getName());
		System.out.println("The score is shadowed: " + p1.getScore());
		
		//With static methods we can access the method without creating an instance of the class
		//Game.play();
		
		//char board[][] = Game.board;
		
		//System.out.println(board);
		
		//It is best practice to close the input stream when you are done using it
		input.close();
		
	}

}
