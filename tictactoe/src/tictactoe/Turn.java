package tictactoe;

/**
 * @boolean isXsTurn is used to keep track of which player's turn it is
 *
 * @method changeTurn() is used to NOT the current player turn to change it
 *
 * @method isItXsTurn() is the getter for isXsTurn
 */

public class Turn {
	boolean isXsTurn;
	
	public Turn() {
		this.isXsTurn = true;
	}
	
	public void changeTurn() {
		this.isXsTurn = !this.isXsTurn;
	}
	
	public boolean isItXsTurn() {
		return this.isXsTurn;
	}
}
