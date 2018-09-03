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

		int xScore, oScore, boardSize;
		Boolean isXTurn;

		try {

			BufferedReader in = new BufferedReader(new FileReader(fileName));
			String xScoreString, oScoreString, boardSizeString, currentMoveString;
			xScoreString = in.readLine(); // First line is xScore
			oScoreString = in.readLine();  // Second line is oScore
			boardSizeString = in.readLine();
			currentMoveString = in.readLine();
			xScore = Integer.parseInt(xScoreString);
			oScore = Integer.parseInt(oScoreString);
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

			Board returnBoard = new Board(xScore, oScore, boardSize, isXTurn, statusList);

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
