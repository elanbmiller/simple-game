package tictactoe;

import java.io.BufferedReader;
import java.io.Console;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileHandler {

	int boardSize;



	public FileHandler (Main main) {

	}



	public Board GetBoardFromSavedGame(String fileName) throws IOException {

		int xScore, yScore, boardSize;
		Boolean isXTurn;

		// Read the first line:
		try {

			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String xScoreString, yScoreString, boardSizeString, currentMoveString;
			xScoreString = in.readLine();
			yScoreString = in.readLine();
			boardSizeString = in.readLine();
			currentMoveString = in.readLine();
			xScore = Integer.parseInt(xScoreString);
			yScore = Integer.parseInt(yScoreString);
			boardSize = Integer.parseInt(boardSizeString);

			if (currentMoveString == "x") {
				isXTurn = true;
			} else {
				isXTurn = false;
			}


			ArrayList<ArrayList<Status>> statusList = new ArrayList<ArrayList<Status>>();

			for (int i = 0; i < boardSize; i++) {
				String currentLine = in.readLine();
				String[] valuesOfLine = currentLine.split(",");
				statusList.add(new ArrayList<Status>() );

				for (int j = 0; j < boardSize; j++) { // VALUES OF LINE TOOO
					String currentVal = valuesOfLine[i];

					switch(currentVal) {
					case "q":
						statusList.get(i).add(Status.q);
						break;
					case "o":
						statusList.get(i).add(Status.o);
						break;
					case "x":
						statusList.get(i).add(Status.x);
						break;
					default:
						System.out.println("ERROR");
					}
				}

			}

			Board returnBoard = new Board(xScore, yScore, boardSize, isXTurn, statusList);

			return returnBoard;

		} finally {
			System.out.println("FUCK");
		}



		//https://stackoverflow.com/questions/10960213/how-to-read-comma-separated-values-from-text-file-in-java



	}



	// For Saving
	public void SaveCurrentGame(Main main) {

	}











}
