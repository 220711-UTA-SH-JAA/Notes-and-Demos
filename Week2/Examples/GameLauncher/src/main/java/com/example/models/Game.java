package com.example.models;

public abstract class Game {

	public static final String NAME = "General Game";
	
	private Board board;
	
	private Player[] players;
	
	abstract void calculateWinner();
	
	public void setPlayers(Player[] players) {
		this.players = players;
	}
	
	public Player[] getPlayers() {
		return players;
	}
	
	public void setBoard(Board board) {
		this.board = board;
	}
	
	public Board getBoard() {
		return this.board;
	}
}
