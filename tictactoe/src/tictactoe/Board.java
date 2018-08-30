package tictactoe;
import java.util.ArrayList;
//import java.awt;


public class Board {
	
	
	ArrayList<ArrayList<Square>> squaresList = new ArrayList<ArrayList<Square>>();  // Row x, column y
	int xScore = 0;
	int oScore = 0;
	boolean isXTurn; //TODO:
	int size;
	
	public Board(int _size) {
		size = _size;
		// Create a squareList and initiate it
		for(int i = 0; i < _size; i++)  {
	        squaresList.add(new ArrayList<Square>(_size));
		}
	}
	
	public Board(int _size, int _xScore, int _yScore, boolean _isXTurn, ArrayList<ArrayList<Status>> statusList) {
			
			// Create a squareList and initiate it
		
		}
	
	
	
	public Status GetStatusAtLocation(int x, int y) {
		// TODO: 
	}
	
	public void ChangeStatusAtLocation(int x, int y, Status newStatus) {
		// TODO:
	}
	
	

	
}
