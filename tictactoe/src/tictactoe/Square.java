package tictactoe;

enum Status {
	x,
	o,
	q; // Question MArk
}


public class Square {
	
	private Status status;
	
	
	public Square() {
		
	}
	
	public Status GetStatus() {
		return status;
	}
	
	public Status ChangeStatus(Status newStatus) {
		status = newStatus;
		return status;
	}
	
}
