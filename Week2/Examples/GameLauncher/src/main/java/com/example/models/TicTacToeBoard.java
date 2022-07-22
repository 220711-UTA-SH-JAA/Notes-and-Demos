package com.example.models;

public class TicTacToeBoard implements Board{
	
	private static Character[][] board;
	
	public TicTacToeBoard() {
		this.board = new Character[3][3];
	}
	
	public static void initializeBoard() {
		//An empty will be specified by every array index being an underscore
		//[00, 01, 02]
		//[10, 11, 12]
		//[20, 21, 22]
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[i].length; j++) {
				board[i][j] = '_';
			}
		}
	}
	
	public static Character[][] getBoard() {
		return board;
	}
	
	public static void setBoard(Character[][] newBoard) {
		board = newBoard;
	}
	
	public String toString() {
		StringBuilder builder = new StringBuilder("\n");
		for(int i=0; i<board.length; i++) {
			builder.append("[");
			for(int j=0; j<board[i].length; j++) {
				builder.append(" " + board[i][j] + " ");
			}
			builder.append("]\n");
		}
		return builder.toString();
		
	}

}
