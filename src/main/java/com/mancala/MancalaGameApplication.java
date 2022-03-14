package com.mancala;

import java.util.Scanner;

import com.mancala.model.Board;
import com.mancala.model.Players;

public class MancalaGameApplication {

	public static void main(String[] args) {

		Board board = new Board();
		Players[] players = new Players[2];
		int current = 0;
		Scanner input = new Scanner(System.in);

		System.out.println("Welcome to Mancala Game.");
		printGameBoard();

		System.out.println("\nEnter Name of First Player");
		players[0] = new Players(input.nextLine(), 1);
		System.out.println("\nEnter Name of Second Player");
		players[1] = new Players(input.nextLine(), 2);

		System.out.println("Welcome " + players[0].getName() + " and  " + players[1].getName() + ".");
		boolean loop = true;
		int playerIndex = 0;

		do {
			// check if label is present, if yes then get the position of it.
			playerIndex = board.makeMove(players[playerIndex]);

			if (playerIndex == 0)
				loop = false;
			else
				playerIndex--; // assuming return value as 0,1,2.

			current = playerIndex;
		} while (loop);

	}

	private static void printGameBoard() {
		Board board = new Board();
		board.printBoard();

	}

}
