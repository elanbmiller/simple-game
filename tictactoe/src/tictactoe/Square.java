package tictactoe;

import javax.swing.JButton;

enum Status {
	x,
	o,
	q; // Question MArk or NONE
}


/**
 * This class encapsulates the squares that populate the board in the game of tic tac toe.
 * These squares will simply hold information indicating whether they've been clicked (a user 
 * won't be able to click a square that has already been chose) and their status (x--indicating 
 * player x chose this, o--indicating o chose this, and q which means the square hasn't been chosen).
 * @author Elan, Micah, Noah, Ian
 *
 */
public class Square extends JButton {
	
	private Status status;
	private boolean isBlocked = false;
	
	
	/**
	 * Basic Square Constructor.
	 * Creates a square that has the specified status
	 * @param status the enum status to be associated with the Square (x, o or q)
	 */
	public Square(Status status) {
		super(status.toString());
		this.status = status;
	}
	
	/**
	 * @return the status associated with the Square
	 */
	public Status GetStatus() {
		return status;
	}
	
	/**
	 * Changes the square's status. This is to be used when x or o clicks a q square and changes 
	 * it to x or o. The square's isBlocked status is also set to true. Also, the square's text
	 * is set to the updated status
	 * @param newStatus a new status to be associated with the square
	 */
	public void ChangeStatus(Status newStatus) {
		this.status = newStatus;
		this.isBlocked = true;
		this.setText(newStatus.toString());
	}
	
	/**
	 * @return this.isBlocked an indicator whether the square has been clicked
	 */
	public boolean isBlocked() {
		return this.isBlocked;
	}
	
	
}
