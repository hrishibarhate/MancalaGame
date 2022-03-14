package com.mancala.model;

public class Players {

	String name;
	private int playerNumber, start, end, mancala;

	public Players() {
		name = "none";
		playerNumber = 0;
	}
	
	public Players(String playerName, int currentPlayer) {
		name= playerName;
		playerNumber = currentPlayer;
		if(currentPlayer == 1) {
			start = 0;
			end= 5;
			mancala = 6;
		} else {
			start = 7;
			end= 12;
			mancala = 13;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getMancala() {
		return mancala;
	}

	public void setMancala(int mancala) {
		this.mancala = mancala;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}
	
	
	
}