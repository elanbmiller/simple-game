package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import tictactoe.Board;
import tictactoe.Square;

class TerminationTests {

	@Test
	void xWinsByColumn() {
		int maxSizeToTest = 10;
		for (int size = 1; size < maxSizeToTest; size++) {
			Board board = new Board(size);
			ArrayList<ArrayList<Square>> squaresList = new ArrayList<ArrayList<Square>>();  // Row x, column y
			for (int row = 0; row < size; row++) {
				
			}
		}
	}

}
