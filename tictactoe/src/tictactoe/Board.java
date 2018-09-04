package tictactoe;
import java.util.ArrayList;
//import java.awt;


/**
 * Encapsulates all the information regarding the tic tac toe game board.
 * @author Elan, Micah, Noah, Ian
 *
 */
public class Board {


	private ArrayList<ArrayList<Square>> squaresList = new ArrayList<ArrayList<Square>>();  // Row x, column y
	int xScore = 0;
	int oScore = 0;
	boolean isXTurn; //TODO:
	int size;

	/**
	 * Called on creation of a new game after receiving the game board size from the user input.
	 * Initializes the squaresList parameter with empty lists of squares and sets isXTurn to true. 
	 * @param _size indicates the width and height of the board to be created
	 */
	public Board(int _size) {
		size = _size;
		// Create a squareList and initiate it
		for(int i = 0; i < _size; i++)  {
			squaresList.add(new ArrayList<Square>(_size));
		}
		//X's turn in beginning
		this.isXTurn = true;
	}

	public Board(int _xScore, int _oScore, int _size, boolean _isXTurn, ArrayList<ArrayList<Status>> statusList) {
		// TODO:
		// Create a squareList and initiate it
		size = _size;
		xScore = _xScore;
		oScore = _oScore;
		isXTurn = _isXTurn;
		
		ArrayList<ArrayList<Square>> tempSquaresList = new ArrayList<ArrayList<Square>>();
		
		int rowNum = 0;
		for (ArrayList<Status> row: statusList) {
			tempSquaresList.add(new ArrayList<Square>());
			for (Status statusValue: row) {
				tempSquaresList.get(rowNum).add(new Square(statusValue));
			}
			rowNum++;
		}
		
		squaresList = tempSquaresList;
	}
	
	public String SerializeCurrentState() {
		StringBuilder sb = new StringBuilder();
		sb.append(xScore);
		sb.append('\n');
		sb.append(oScore);
		sb.append('\n');
		sb.append(size);
		sb.append('\n');
		if (isXTurn) {
			sb.append("x");
		} else {
			sb.append("o");
		}
		sb.append('\n');
		
		
		
		// Now do the board:
		
		for (int i = 0; i < squaresList.size(); i++) {
			for (int j = 0; j < squaresList.get(i).size(); j++) {
				
				switch(squaresList.get(i).get(j).GetStatus()) {
				case x:
					sb.append("x");
					break;
				case o:
					sb.append("o");
					break;
				case q:
					sb.append("q");
					break;
				}
				
				sb.append(",");
				
			}
			sb.deleteCharAt(sb.lastIndexOf(",")); // Semi-Sloppy way to delete the last comma
			sb.append('\n');
		}		
		return sb.toString();
	}

	/**
	 * This will be used to update the board after a player has made a move.
	 * @param updated_squares_List indicates the new squaresList for this board
	 */
	public void set_squares_list(ArrayList<ArrayList<Square>> updated_squares_List) {
		this.squaresList = updated_squares_List;
	}

	/**
	 * Gets the current boards squaresList indicating where everything is
	 * @return this.squaresList which contains the square info on the board
	 */
	public ArrayList<ArrayList<Square>> get_squares_list(){
		return this.squaresList;
	}

	public Status GetStatusAtLocation(int x, int y) {
		return squaresList.get(x).get(y).GetStatus();
	}

	public void ChangeStatusAtLocation(int x, int y, Status newStatus) {
		squaresList.get(x).get(y).ChangeStatus(newStatus);
	}

	/**
	 * @return the status of the winner if there is a winner, otherwise it returns q indicating no one has won yet
	 */
	public Status CheckForWin(){
		int size = squaresList.size();
		//Check Columns

		for(int i = 0; i < size; ++i){
			Status thisCol = squaresList.get(i).get(0).GetStatus();
			if(thisCol != Status.q){
				boolean stillMatched = true;
				for(int j = 1; j < size; ++j){
					Status thisSquare = squaresList.get(i).get(j).GetStatus();
					if(thisSquare == Status.q || thisSquare != thisCol){
						stillMatched = false;
						break;
					}
				}
				if(stillMatched){
					return thisCol;
				}
			}
		}

		//check rows
		for(int i = 0; i < size; ++i){
			Status thisRow = squaresList.get(0).get(i).GetStatus();
			if(thisRow != Status.q){
				boolean stillMatched = true;
				for(int j = 1; j < size; ++j){
					Status thisSquare = squaresList.get(j).get(i).GetStatus();
					if(thisSquare == Status.q || thisSquare != thisRow){
						stillMatched = false;
						break;
					}
				}
				if(stillMatched){
					return thisRow;
				}
			}
		}

		//Check Diagonals
		Status downRightDiagonal = squaresList.get(0).get(0).GetStatus();
		if(downRightDiagonal != Status.q){
			boolean stillMatched = true;
			for(int i = 1; i < size; ++i){
				Status thisSquare = squaresList.get(i).get(i).GetStatus();
				if(thisSquare == Status.q || thisSquare != downRightDiagonal){
					stillMatched = false;
					break;
				}
			}
			if(stillMatched){
				return downRightDiagonal;
			}
		}

		int downLeftStartX = 0;
		int downLeftStartY = size-1;
		Status downLeftDiagonal = squaresList.get(downLeftStartX).get(downLeftStartY).GetStatus();
		if(downLeftDiagonal != Status.q){
			boolean stillMatched = true;
			for(int i = 0; i < size; ++i){
				Status thisSquare = squaresList.get(downLeftStartX + i).get(downLeftStartY - i).GetStatus();
				if(thisSquare == Status.q || thisSquare != downLeftDiagonal){
					stillMatched = false;
					break;
				}
			}
			if(stillMatched){
				return downLeftDiagonal;
			}
		}

		return Status.q;
	}

	/**
	 * To be called if there is no winner yet. This will check if the board is full, which indicates that the game is a tie.
	 * @return true indicating that the game is a tie or false otherwise
	 */
	public boolean is_tie(){
		for(int i = 0; i < size; ++i){
			for (int j = 0; j < size; j++) {
				if (squaresList.get(i).get(j).GetStatus() == Status.q) {
					return false;
				}
			}
		}
		return true;
	}
	/**
	 * Return the size of the board (i.e. its dimensions).
	 * @return size
	 */
	public int getSize() {
		return size;
	}

	public boolean getIsXTurn() {
		return isXTurn;
	}
	
	public void setIsXTurn(boolean turn) {
		isXTurn = turn;
	}
	

}
