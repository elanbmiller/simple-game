package tictactoe;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class TestFileWrite {

	@Test
	void test() {
		String testFileName = "testFile1.txt";
		String saveFileName = "saveFile2.txt";
		FileHandler fh = new FileHandler();
		Board testBoard; // = new Board(3);
		
		try {
			testBoard = fh.GetBoardFromSavedGame(testFileName);
		} catch (IOException e) {
			System.out.println("Welp, that didn't work");
			testBoard = new Board(3);
			e.printStackTrace();
		}
		
		
		fh.SaveCurrentGame(testBoard, saveFileName);
	
	}
	
	@Test
	void test2() {
		
		String testFileName = "testFile1.txt";
		String saveFileName = "saveFile2.txt";
		FileHandler fh = new FileHandler();
		Board testBoard; // = new Board(3);
		
	
		
		
		
		Board testReloadBoard; // = new Board(3);
		try {
			testBoard = fh.GetBoardFromSavedGame(testFileName);
			fh.SaveCurrentGame(testBoard, saveFileName);
			testReloadBoard = fh.GetBoardFromSavedGame(saveFileName);
			assertEquals(testBoard, testReloadBoard);
		} catch (IOException e) {
			System.out.println("Welp, that didn't work");
			testReloadBoard = new Board(3);
			e.printStackTrace();
		}
	
		
	}

}
