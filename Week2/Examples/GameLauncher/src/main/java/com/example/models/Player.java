package com.example.models;

public class Player {
	
	//private values
	private String name;
	private int score;
	
	//construtors
	public Player() {
		//By default, if we call the no args we want to
		//initialize these default values
		this.name="";
		this.score=0;
	}
	
	public Player(String name) {
		this.name = name;
		this.score=0;
	}
	
	//mutators
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}

}
