package com.example.models;

//Now we can create an instance of Game through this child class
//To inherit from interfaces, we must use the implements keyword
public class TicTacToeGame extends Game implements IPlayable{

	//Using shadowing we learned from inheritance lets name this specific game
	public static final String NAME = "Tic Tac Toe";

	@Override
	void calculateWinner() {
		//We will calculate if the win condition has been met, in a little bit
		//Check Notes-And-Demos/Week2/GameLauncher for implementation
	}

	@Override
	public void play() {
		// TODO Auto-generated method stub
		//Check Notes-And-Demos/Week2/GameLauncher for implementation
	}
	
}
