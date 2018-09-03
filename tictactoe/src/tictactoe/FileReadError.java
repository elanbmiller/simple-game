package tictactoe;

public class FileReadError extends Error {
	String errorBody;
	
	FileReadError(String _errorBody) {
		errorBody = _errorBody;
	}
	
	public String toString() {
		return "ERROR: FileReadError --> " + errorBody;
	}
}
