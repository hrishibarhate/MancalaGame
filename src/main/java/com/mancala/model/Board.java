package com.mancala.model;

import java.util.Scanner;

public class Board {

	private int[] pits = { 6, 6, 6, 6, 6, 6, 0, 6, 6, 6, 6, 6, 6, 0 };

	private char[] pitLables = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N' };
	private Scanner input = new Scanner(System.in);
	int slotSize = 13;
	int individualSlot = 6;
	private void printTopPlayer() {
				
		for (int i = slotSize; i > individualSlot; i--) {
			System.out.printf("  %c ", pitLables[i]);
		}
		printLine();
		for (int i = slotSize; i > individualSlot; i--) {
			System.out.printf("  %d ", pits[i]);
		}
	}

	private void printBottomPlayer() {
		printLine();
		for (int i = 0; i <= individualSlot; i++) {
			System.out.printf("  %d ", pits[i]);
		}
		printLine();
		for (int i = 0; i <= individualSlot; i++) {
			System.out.printf("  %c ", pitLables[i]);
		}
	}

	private void printLine() {
		System.out.println("\n*****************************\n");
	}

	public void printBoard() {
		printLine();
		printTopPlayer();
		printLine();
		printBottomPlayer();
		printLine();
	}

	public int makeMove(Players player) {
		char choiceLetter;
		int retVal = 0;
		int index = -1;
		printBoard();
		boolean loop = true;
		do {
			System.out.println("\nYour Turn : " + player.getName() + " choose a Pit between "
					+ pitLables[player.getStart()] + " and " + pitLables[player.getEnd()]);
			try {
				choiceLetter = input.next().toUpperCase().charAt(0);
			} catch (IndexOutOfBoundsException e) {
				System.out.println("Invalid Selection");
				choiceLetter = 'Z';
			}
			index = findIndex(choiceLetter);
			if (index != -1 && index >= player.getStart() && index <= player.getEnd() && pits[index] > 0)
				loop = false;
			else {
				System.out.println("Select pits from your side that contains stones. ");
				if (checkSideEmpty() > 0) {
					loop = false;
					System.out.println("Once Side is Empty. Now the game is over.");
					index = -1; // to indicate now no more moves in game.
				}
			}
		} while (loop);

		if (index == -1)
			retVal = 0;
		else {
			int stones = pits[index]; // check no of stones in pit
			pits[index] = 0; // make current pit as 0. All stones are picked.
			while (stones > 0) {
				index++;

				if ((player.getPlayerNumber() == 1 && index == 13) || (player.getPlayerNumber() == 2 && index == 6))
					index++;
				if (index == 14)
					index = 0;
				pits[index]++;
				stones--;
			}
		}
		// Now check for whose turn is next. first check for last stone in pit
		if (player.getPlayerNumber() == 1 && player.getMancala() == index)
			retVal = 1;
		else if (player.getPlayerNumber() == 2 && player.getMancala() == index)
			retVal = 2;
		else if (player.getPlayerNumber() == 1)
			retVal = 2;
		else
			retVal = 1;

		return retVal;
	}

	public int findIndex(char charNeeded) {
		int found = -1;
		for (int i = 0; i < pitLables.length; ++i) {
			if (pitLables[i] == charNeeded) {
				found = i;
				break;
			}
		}
		return found;
	}

	// check if Side is empty returns 0 when no side is empty , 1 when player 1 side
	// is empty 2 for player2 , 3 for both sides.
	public int checkSideEmpty() {
		int retVal = 0;
		int player1 = 0;
		int player2 = 0;

		for (int i = 0; i < 7; i++) {
			if (pits[i] != 0) {
				player1 = 0;
				break;
			} else
				player1 = 1;

		}

		for (int i = 8; i < 12; i++) { // 13
			if (pits[i] != 0) {
				player2 = 0;
				break;
			} else
				player2 = 1;

		}
		retVal = player1 + player2;
		return retVal;
	}
}