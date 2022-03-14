package com.mancala;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.mancala.model.Board;
import com.mancala.model.Players;


class MancalaGameApplicationTests {
	
	private static Board board= null;
	
	@BeforeAll
	public static void setup() {
		board = new Board();
	}

	@Test
	void testFindIndexForInvalidLetter() {
		char findLetter = 'Z';

		assertEquals(-1, board.findIndex(findLetter));
	}
	
	@Test
	void testFindIndexForValidLetter() {
		char findLetter = 'B';

		assertEquals(1, board.findIndex(findLetter));
	}
	
	@Test
	void testCheckSideIsEmptyValid() {
		assertEquals(0, board.checkSideEmpty());
	}

	@Test
	void testPlayerMove() {
		Players p = new Players("Hrishi",1);
		//checking for player Turn: 1 for player1
		assertEquals(1,board.makeMove(p));
		
	}
}
