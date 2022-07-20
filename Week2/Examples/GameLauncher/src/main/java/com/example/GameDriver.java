package com.example;

import java.util.Scanner;

import com.example.models.Game;
import com.example.models.Player;
import com.example.models.TicTacToeGame;
import com.example.models.TicTacToePlayer;

public class GameDriver {
	
	public static void main(String args[]) {
		
		//In Java 7 the feature called try with resources was created
		//This is essentially a try block that will automatically close when the resource is done being used
		//The only catch with this is that the resource must implement the AutoClosable interface
		//Now we don't have to manually close our scanner, it will be closed when the program finishes
		try(Scanner input = new Scanner(System.in)){
			System.out.println("How many players today?");
			
			int playerCount = input.nextInt();
			input.nextLine();
			
			Player[] players = new Player[playerCount];
			
			for(int i=0; i<playerCount; i++) {
				System.out.print("Player " + (i+1) + " please enter your name:");
				String name = input.nextLine();
				Player p = new Player(name);
				players[i] = p;
			}
			
			boolean continuePlaying = true;
			
			while(continuePlaying) {
				
				System.out.println("What game would you like to play today?");
				
				String gameName = input.nextLine();
				
				switch(gameName) {
					case "Tic Tac Toe":
						TicTacToeGame ticTacToe = new TicTacToeGame(players, input);
						ticTacToe.play();
						break;
					default:
						System.out.println("Sorry that game doesn't exist");
				}
				
				System.out.println("Current ScoreBoard:");
				for(int i=0; i<players.length;i++) {
					System.out.println("Player: " + players[i].getName() + " Score: " + players[i].getScore());
				}
				
				System.out.println("Would you like to play another? y/n");
				
				String yN = input.nextLine();
				
				if(yN.equals("n")) {
					continuePlaying=false;
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
