package com.example.models;

import java.util.Arrays;

//TicTacToGame is a Game that is Playable
public class TicTacToeGame extends Game implements IPlayable{
	
	public TicTacToeGame() {
		//Create and initalize a new board to play
		TicTacToeBoard board = new TicTacToeBoard();
		TicTacToeBoard.initializeBoard();
		this.setBoard(board);
	}

	public void play() {
		System.out.println("This is is what the board looks like:");
		//Print out the board
		System.out.println("Choose a coordinate corresponding to the board above to place your piece");
		//Play logic to implement tomorrow
		/*
		 * 1. Let a player choose a spot on the board
		 * 2. Calculate if they have won with the calculateWinner method
		 * 3. If no winner, and not all spaces full, change player, and go again
		 */
		
	}

	@Override
	void calculateWinner() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String toString() {
		return "TicTacToeGame [Players=" + Arrays.toString(getPlayers()) + ", Board=" + getBoard() + "]";
	}
	
	

}
