package tictactoe;
import java.util.ArrayList;
//import java.awt;


public class Board {
	
	
	ArrayList<ArrayList<Square>> squaresList = new ArrayList<ArrayList<Square>>();  // Row x, column y

	
	
	public Board(int size) {
		
		// Create a squareList and initiate it
		for(int i = 0; i < size; i++)  {
	        squaresList.add(new ArrayList<Square>(size));
		}
		
		
		
		
		
	}
	
	

	
}
