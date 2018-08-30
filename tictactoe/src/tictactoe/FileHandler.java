package tictactoe;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.util.ArrayList;

public class FileHandler {
	
	int boardSize;
	
	
	
	public FileHandler (Main main) {
		
	}
	
	// For Loading
	public int GetBoardSize() {
		
	}
	
	public ArrayList<ArrayList<Status>> StatusValuesListForCurrentGame() {
		
	}
	
	
	public Board GetBoardFromSavedGame(string fileName) {
		//TODO:
		

		int xScore, yScore, boardSize;
		
		// Read the first line:
		try {
			BufferedReader in = new BufferedReader(new FileReader(fileName));
            String xScoreString, yScoreString, boardSizeString;
            xScoreString = in.readLine();
            yScoreString = in.readLine();
            boardSizeString = in.readLine();
            xScore = Integer.parseInt(xScoreString);
            yScore = Integer.parseInt(yScoreString);
            boardSize = Integer.parseInt(boardSizeString);
            
            
            ArrayList<ArrayList<Status>> statusList = new ArrayList<ArrayList<Status>>();
            
            for (int i = 0; i < boardSize; i++) {
        	   	String currentLine = in.readLine();
        	   	String[] valuesOfLine = currentLine.split(",");
        	   	statusList.add(new ArrayList<Status>() );
        	   	
        	   	for (int j = 0; j < boardSize; j++) { // VALUES OF LINE TOOO
        	   		String currentVal
        	   		switch(currentVal) {
        	   		case //TODO:
        	   		}
        	   		statusList[i][j] = 
        	   	}
           }
		} finally {
			System.out.println("FUCK");
		}
		
		
		//https://stackoverflow.com/questions/10960213/how-to-read-comma-separated-values-from-text-file-in-java
		
		
		
	}
	
	
	/*
	public Main LoadFromFile(string fileName) {
		
	}
	*/
	
	// For Saving
	public void SaveCurrentGame(Main main) {
		
	}
	
	
	
	
	
	
	
	
	
	
	
}
