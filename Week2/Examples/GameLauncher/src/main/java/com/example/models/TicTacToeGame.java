package com.example.models;

import java.util.Arrays;
import java.util.Scanner;

import com.example.exceptions.ExpectedNumbersException;
import com.example.exceptions.IncorrectInputFormatException;
import com.example.exceptions.InvalidPositionException;

//TicTacToGame is a Game that is Playable
public class TicTacToeGame extends Game implements IPlayable{
	
	private Scanner input;
	private TicTacToePlayer currentPlayer;
	private TicTacToePlayer winner = null;
	private TicTacToePlayer p1;
	private TicTacToePlayer p2;
	private Character[][] gameBoard;
	
	public TicTacToeGame() {
		//Create and initalize a new board to play
		TicTacToeBoard board = new TicTacToeBoard();
		TicTacToeBoard.initializeBoard();
		this.setBoard(board);
		gameBoard = TicTacToeBoard.getBoard();
	}
	
	public TicTacToeGame(Player[] players, Scanner input) {
		//this() will call the no args constructor of the TicTacToeGame class
		this();
		TicTacToePlayer[] tPlayers = new TicTacToePlayer[2];
		//tPlayers[0] = new TicTacToePlayer(players[0].getName(), 'X');
		//tPlayers[1] = new TicTacToePlayer(players[1].getName(), 'O');
		this.setPlayers(tPlayers);
		this.input = input;
	}

	public void play() {
		p1 = new TicTacToePlayer(this.getPlayers()[0].getName(), 'X');
		p2 = new TicTacToePlayer(this.getPlayers()[1].getName(), 'X');
		System.out.println("Welcome to Tic Tac Toe!");
		System.out.println("Player: " + this.getPlayers()[0].getName() + " is X, Player: " + this.getPlayers()[1].getName() + " is O");
		System.out.println("This is is what the board looks like:");
		//Play logic to implement tomorrow
		/*
		 * 1. Let a player choose a spot on the board
		 * 2. Calculate if they have won with the calculateWinner method
		 * 3. If no winner, and not all spaces full, change player, and go again
		 */
		boolean firstPlayer = true;
		boolean notTieGame = true;
		currentPlayer = (TicTacToePlayer) this.getPlayers()[0];

		while((winner == null) && notTieGame) {
			System.out.println("[ 00 01 02 ] \n[ 10 11 12 ] \n[ 20 21 22 ]");
			System.out.println("Choose a coordinate corresponding to the board above to place your piece");
			System.out.print(currentPlayer.getName() + " choose your position: ");
			String position = input.nextLine();
			//Lets talk about exceptions after our 15 minute break
			try{
				validatePosition(position);
				placeSymbol(position);
				calculateWinner();
				notTieGame = calculateTieGame();
				firstPlayer = !firstPlayer;
				if(!firstPlayer) {
					currentPlayer = (TicTacToePlayer) this.getPlayers()[1];
				} else {
					currentPlayer = (TicTacToePlayer) this.getPlayers()[0];
				}
				System.out.println(this.getBoard().toString());
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		if(winner == null) {
			System.out.println("There was a tie");
		} else {
			winner.setScore(winner.getScore() + 1);
			System.out.println("CONGRATS TO: " + winner.getName() + " they are the champion of Tic Tac Toe");
		}
		
	}
	
	private boolean calculateTieGame() {
		for(int i=0; i<3; i++) {
			for(int j=0; j<3; j++) {
				if(gameBoard[i][j].equals('_')) {
					return true;
				}
			}
		}
		return false;
	}
	
	private void placeSymbol(String position) {
		Character symbol = currentPlayer.getSymbol();
		Integer pos1 = Integer.valueOf(""+position.charAt(0));
		Integer pos2 = Integer.valueOf(""+position.charAt(1));
		
		gameBoard[pos1][pos2] = symbol;
		
		TicTacToeBoard.setBoard(gameBoard);
	}
	
	private boolean validatePosition(String position) throws Exception {
		//The string should look something like this 01 00 02
		//We can check if the length of the string is 2
		//Are both values between 0 and 2
		//Is there an underscore
		if(position.length() == 2) {
			
			Character pos1 = position.charAt(0);
			Character pos2 = position.charAt(1);
			
			Integer index1 = null;
			Integer index2 = null;
			
			if(Character.isDigit(pos1) && Character.isDigit(pos2)) {
				index1 = Integer.valueOf(""+position.charAt(0));
				index2 = Integer.valueOf(""+position.charAt(1));
			}else {
				throw new ExpectedNumbersException();
			}
			
			if(((index1 >=0 && index1 <= 2) && (index2 >=0 && index2 <= 2)) && (gameBoard[index1][index2].equals('_'))) {
				return true;
			} else {
				throw new InvalidPositionException();
			}
			
		} else {
			throw new IncorrectInputFormatException("We expected two numbers");
		}
	}

	@Override
	public void calculateWinner() {
		// To win, we must have 3 in a row in any direction
		// We initialize the board with underscores so we can ignore those
		// We just need to check if any three spaces in a row are the same
		/*
		 * 
		 * [ 00 01 02 ]
		 * [ 10 11 12 ]
		 * [ 20 21 22 ]
		 * 
		 */
		Character[][] board = TicTacToeBoard.getBoard();
		// [ X X X ] -> win [ _ _ _ ] -> its not a win
		if((board[0][0].equals(board[0][1]) && board[0][1].equals(board[0][2]) && !board[0][0].equals('_'))){
			winner = currentPlayer;
			return;
		}
		
		if((board[1][0].equals(board[1][1]) && board[1][1].equals(board[1][2]) && !board[1][0].equals('_'))){
			winner = currentPlayer;
			return;
		}
		
		if((board[2][0].equals(board[2][1]) && board[2][1].equals(board[2][2]) && !board[2][0].equals('_'))){
			winner = currentPlayer;
			return;
		}
		
		if((board[0][0].equals(board[1][0]) && board[1][0].equals(board[2][0]) && !board[0][0].equals('_'))){
			winner = currentPlayer;
			return;
		}
		
		if((board[0][1].equals(board[1][1]) && board[1][1].equals(board[2][1]) && !board[0][1].equals('_'))){
			winner = currentPlayer;
			return;
		}
		
		if((board[0][2].equals(board[1][2]) && board[1][2].equals(board[2][2]) && !board[0][2].equals('_'))){
			winner = currentPlayer;
			return;
		}
		
		if((board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals('_'))){
			winner = currentPlayer;
			return;
		}
		
		if((board[2][0].equals(board[1][1]) && board[1][1].equals(board[0][2]) && !board[2][0].equals('_'))){
			winner = currentPlayer;
			return;
		}
	}

	@Override
	public String toString() {
		return "TicTacToeGame [Players=" + Arrays.toString(getPlayers()) + ", Board=" + getBoard() + "]";
	}
	
	

}
