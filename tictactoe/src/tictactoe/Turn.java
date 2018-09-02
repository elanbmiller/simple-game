package tictactoe;

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
