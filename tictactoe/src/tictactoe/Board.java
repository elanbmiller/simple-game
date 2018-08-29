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

	public Status GetStatusAtLocation(int x, int y) {
		// TODO: 
		return squaresList.get(x).get(y).GetStatus();
	}

	public void ChangeStatusAtLocation(int x, int y, Status newStatus) {
		// TODO:
		squaresList.get(x).get(y).ChangeStatus(newStatus);
	}

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
			for(int i = 1; i < size; ++i){
				Status thisSquare = squaresList.get(downLeftStartX + i).get(downLeftStartY - i).GetStatus();
				if(thisSquare == Status.q || thisSquare != downLeftDiagonal){
					stillMatched = false;
					break;
				}
				if(stillMatched){
					return downLeftDiagonal;
				}
			}
		}
		
		return q;
	}




}
