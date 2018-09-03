import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import tictactoe.*;

class TerminationTests {

	@Test
	void basicWin() {
		Board board = new Board(3);
		ArrayList<ArrayList<Square>> squaresList = board.get_squares_list();
		Square xSquare = new Square(Status.x);
		Square qSquare = new Square(Status.q);
		squaresList.get(0).add(xSquare);
		squaresList.get(0).add(qSquare);
		squaresList.get(0).add(qSquare);
		squaresList.get(1).add(xSquare);
		squaresList.get(1).add(qSquare);
		squaresList.get(1).add(qSquare);
		squaresList.get(2).add(xSquare);
		squaresList.get(2).add(qSquare);
		squaresList.get(2).add(qSquare);
		assertEquals(Status.x, board.CheckForWin());
	}
	
	@Test
	void basicTie() {
		Board board = new Board(3);
		ArrayList<ArrayList<Square>> squaresList = board.get_squares_list();
		Square xSquare = new Square(Status.x);
		Square oSquare = new Square(Status.o);
		squaresList.get(0).add(xSquare);
		squaresList.get(0).add(oSquare);
		squaresList.get(0).add(xSquare);
		squaresList.get(1).add(oSquare);
		squaresList.get(1).add(xSquare);
		squaresList.get(1).add(xSquare);
		squaresList.get(2).add(oSquare);
		squaresList.get(2).add(xSquare);
		squaresList.get(2).add(oSquare);
		assertEquals(true, board.is_tie());
		
	}

	@Test
	void xWinsByColumn() {
		int maxSizeToTest = 10;
		
		//we'll check to make sure it returns x as winner up to size 10
		for (int size = 1; size < maxSizeToTest; size++) {
			Board board = new Board(size);
			ArrayList<ArrayList<Square>> squaresList = board.get_squares_list();
			Square xSquare = new Square(Status.x);
			Square qSquare = new Square(Status.q);
			
			//go down the columns and set them as x's
			for (int row = 0; row < size; row++) {
				squaresList.get(row).add(xSquare);
				
				//set everything else to q
				for (int leftOver = 1; leftOver < size; leftOver++) {
					squaresList.get(row).add(qSquare);
				}
				
			}
			assertEquals(Status.x, board.CheckForWin());
		}
	}

	//same as previous test, but now x wins by rows
	@Test
	void xWinsByRow() {
		int maxSizeToTest = 10;
		for (int size = 1; size < maxSizeToTest; size++) {
			Board board = new Board(size);
			ArrayList<ArrayList<Square>> squaresList = board.get_squares_list();
			Square xSquare = new Square(Status.x);
			Square qSquare = new Square(Status.q);
			
			for (int col = 0; col < size; col++) {
				squaresList.get(0).add(xSquare);
				
				//fill in rest of column beneath the top row
				for (int leftOver = 1; leftOver < size; leftOver++) {
					squaresList.get(leftOver).add(qSquare);
				}
				
			}
			assertEquals(Status.x, board.CheckForWin());
		}
	}
	
	//same as previous test, but now x wins by diagonal
	@Test
	void xWinsByDiagonal() {
		int maxSizeToTest = 10;
		for (int size = 1; size < maxSizeToTest; size++) {
			Board board = new Board(size);
			ArrayList<ArrayList<Square>> squaresList = board.get_squares_list();
			Square xSquare = new Square(Status.x);
			Square qSquare = new Square(Status.q);
			
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					if (row == col) {
						squaresList.get(row).add(xSquare);
					}
					else {
						squaresList.get(row).add(qSquare);
					}
				}
				
			}
			assertEquals(Status.x, board.CheckForWin());
		}
	}
	
	
	//Tests for o wins
	@Test
	void oWinsByColumn() {
		int maxSizeToTest = 10;
		
		//we'll check to make sure it returns x as winner up to size 10
		for (int size = 1; size < maxSizeToTest; size++) {
			Board board = new Board(size);
			ArrayList<ArrayList<Square>> squaresList = board.get_squares_list();
			Square oSquare = new Square(Status.o);
			Square qSquare = new Square(Status.q);
			
			//go down the columns and set them as x's
			for (int row = 0; row < size; row++) {
				squaresList.get(row).add(oSquare);
				
				//set everything else to q
				for (int leftOver = 1; leftOver < size; leftOver++) {
					squaresList.get(row).add(qSquare);
				}
				
			}
			assertEquals(Status.o, board.CheckForWin());
		}
	}

	//same as previous test, but now x wins by rows
	@Test
	void oWinsByRow() {
		int maxSizeToTest = 10;
		for (int size = 1; size < maxSizeToTest; size++) {
			Board board = new Board(size);
			ArrayList<ArrayList<Square>> squaresList = board.get_squares_list();
			Square oSquare = new Square(Status.o);
			Square qSquare = new Square(Status.q);
			
			for (int col = 0; col < size; col++) {
				squaresList.get(0).add(oSquare);
				
				//fill in rest of column beneath the top row
				for (int leftOver = 1; leftOver < size; leftOver++) {
					squaresList.get(leftOver).add(qSquare);
				}
				
			}
			assertEquals(Status.o, board.CheckForWin());
		}
	}
	
	//same as previous test, but now o wins by diagonal
	@Test
	void oWinsByDiagonal() {
		int maxSizeToTest = 10;
		for (int size = 1; size < maxSizeToTest; size++) {
			Board board = new Board(size);
			ArrayList<ArrayList<Square>> squaresList = board.get_squares_list();
			Square oSquare = new Square(Status.o);
			Square qSquare = new Square(Status.q);
			
			for (int row = 0; row < size; row++) {
				for (int col = 0; col < size; col++) {
					if (row == col) {
						squaresList.get(row).add(oSquare);
					}
					else {
						squaresList.get(row).add(qSquare);
					}
				}
				
			}
			assertEquals(Status.o, board.CheckForWin());
		}
	}

}
