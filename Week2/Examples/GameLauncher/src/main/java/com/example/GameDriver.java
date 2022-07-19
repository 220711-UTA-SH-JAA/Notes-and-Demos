package com.example;

import com.example.models.Player;
import com.example.models.TicTacToeGame;
import com.example.models.TicTacToePlayer;

public class GameDriver {
	
	public static void main(String args[]) {
		
		TicTacToeGame ticTacToe = new TicTacToeGame();
		
		TicTacToePlayer p1 = new TicTacToePlayer("Ethan", 'X');
		TicTacToePlayer p2 = new TicTacToePlayer("Pablo", 'O');
		
		//With polymorphism we can pass our TicTacToePlayers into this Player array
		Player[] players = new Player[2];
		players[0] = p1;
		players[1] = p2;
		
		ticTacToe.setPlayers(players);
		
		System.out.println(ticTacToe);
		
	}

}
