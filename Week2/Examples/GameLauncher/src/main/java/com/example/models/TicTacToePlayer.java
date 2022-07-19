package com.example.models;

public class TicTacToePlayer extends Player{

	private Character symbol;
	
	public TicTacToePlayer() {
		super();
	}
	
	public TicTacToePlayer(String name) {
		super(name);
	}
	
	public TicTacToePlayer(String name, Character symbol) {
		super(name);
		this.symbol = symbol;
	}
	
	public Character getSymbol() {
		return symbol;
	}
	
	public void setSymbol(Character symbol) {
		this.symbol = symbol;
	}
	
}
