package tictactoe;

import javax.swing.JButton;

enum Status {
	x,
	o,
	q; // Question MArk or NONE
}


public class Square extends JButton {
	
	private Status status;
	private boolean isBlocked = false;
	
	
	public Square(Status status) {
		super(status.toString());
		this.status = status;
	}
	
	public Status GetStatus() {
		return status;
	}
	
	public void ChangeStatus(Status newStatus) {
		this.status = newStatus;
		this.isBlocked = true;
		this.setText(newStatus.toString());
	}
	
	public boolean isBlocked() {
		return this.isBlocked;
	}
	
	
}
