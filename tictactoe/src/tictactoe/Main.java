package tictactoe;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.*;

//Button listener from https://alvinalexander.com/java/jbutton-listener-pressed-actionlistener
//window closing execution from https://stackoverflow.com/questions/16372241/run-function-on-jframe-close

/**
 * Main class. Extends JFrame, and uses that to display the game board. Initializes board and displays it. Handles button click events.
 * @author Ian Pearson, Elan Miller, Noah Saffer, Micah Wolfson
 *
 */

public class Main extends JFrame{
	
	Board board;
	Status current_player = Status.x;
	FileHandler fh;
	
	static String fileName = "bestGameOfAllTime.txt";


	/**
	 * Constructor for Main. Initializes as a JFrame, creates a game board, and displays the game elements.
	 */
	public Main() {
		super("X's Turn");
		super.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		super.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				quitGame();
			}
		});

		//TODO: Check if there's an unifinished game, if so, load it
		//otherwise populate initial frame w/ question marks

		//TODO: Create board w/ board_size
		int dimension = this.get_dim();

		board = new Board(dimension);

		//Current Player is automatically set to X
		this.current_player = Status.x;

		this.setLayout(new GridLayout(dimension,dimension));
		this.setSize(500,500);  
		this.setVisible(true);  


		this.populate_init_frame(dimension, this);

		super.pack();
		super.setVisible(true);
		
		fh = new FileHandler();

	}
	
	/**
	 * quitGame(): 
	 * Called on quit (i.e. the user has closed the window); prompts the user to ask if they want to save, and calls the save method if so;
	 * otherwise, disposes of the window and exits the program.
	 */
	private void quitGame() {
		//TODO: prompt user to ask if they want to save, then save
		
		JOptionPane pane = new JOptionPane("Would you like to save your progress?");
		Object[] options = new String[] { "Nah", "For sure" };
		// Nah = 0; For sure = 1
		pane.setOptions(options);
		JDialog dialog = pane.createDialog(new JFrame(), "FileSystem");
		dialog.setVisible(true);
		Object obj = pane.getValue();
		int result = -1;
		for (int k = 0; k < options.length; k++) {
			if (options[k].equals(obj)) {
		        result = k;
			}
		}
		System.out.println("User's choice: " + result);
		
		
		
		
		// If the user wants to save:
		if (result == 1) {
			fh.SaveCurrentGame(board, fileName);
		}
		
		
		this.dispose();
		System.exit(0);
	}
	
	/**
	 * populate_init_frame(int dimension, JFrame frame):
	 * Initializes the board with Square buttons. Loads the Square objects up with the initial value of '?' to represent an empty square. 
	 * Also sets up the event for the buttons, which changes their status (from ? to X or O), then asks the board to evaluate the current game state.
	 * If a user has won, a dialog box will pop up declaring the winner; if it's a tie, it declares the tie. 
	 * 
	 * After initialization, the method sends the board the initialized squares list.
	 * @param dimension: number of squares in each dimension of the board.
	 * @param frame: the JFrame used to hold the buttons.
	 */

	public void populate_init_frame(int dimension, JFrame frame) {
		ArrayList<ArrayList<Square>> updated_squares_list = board.get_squares_list();
		//Create buttons
		for (int i = 0; i < dimension; i++) {
			ArrayList tmp = new ArrayList<Square>();
			for (int j = 0; j < dimension; j++) {
				Square button = new Square(Status.q);
				Font bSize12 = new Font("Arial", Font.PLAIN, 25);
				button.setFont(bSize12);
				button.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						//if button has already been chosen
						if (button.isBlocked()) {
							JOptionPane.showMessageDialog(frame, "SOMEONE ALREADY CHOSE THAT SPOT", "NO NO NO!", JOptionPane.INFORMATION_MESSAGE);
						}
						else {
							//change  status
							button.ChangeStatus(getPlayer());
							if(board.CheckForWin() != Status.q) {
								JOptionPane.showMessageDialog(frame, board.CheckForWin().toString().toUpperCase() + " WON!!!!", "WINNER!", JOptionPane.INFORMATION_MESSAGE);
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								System.exit(0);
							}
							else if (board.is_tie()) {
								JOptionPane.showMessageDialog(frame, "X AND O TIED!", "TIE GAME!", JOptionPane.INFORMATION_MESSAGE);
								try {
									Thread.sleep(100);
								} catch (InterruptedException e1) {
									// TODO Auto-generated catch block
									e1.printStackTrace();
								}
								System.exit(0);
							}
							nextTurn();
							frame.setTitle(getPlayer().toString().toUpperCase() + "'s Turn");
						}


					}
				});
				tmp.add(button);
				frame.add(button);
			}
			updated_squares_list.set(i, tmp);
		}
		board.set_squares_list(updated_squares_list);
	}
	
	/**
	 * get_dim():
	 * Prompts the user for the board size that they want using a JOptionPane.
	 * @return the dimensional value for the board
	 */
	public int get_dim() {
		try {
			int value = Integer.parseInt(JOptionPane.showInputDialog("You're about to play tic tac toe. Enter an integer size for the board."));
			if (value <= 0) {
				JOptionPane.showMessageDialog(null, "Invalid", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
				System.exit(1);
			}
			return value;
		}
		catch(NumberFormatException nfe){
			JOptionPane.showMessageDialog(null, "Invalid", "InfoBox: ", JOptionPane.INFORMATION_MESSAGE);
			System.exit(1);
		}
		return -1;
	}

	/**
	 * Gets the current player.
	 * @return current player.
	 */
	public Status getPlayer() {
		return current_player;
	}

	/**
	 * Switch the current player to the next player.
	 */
	public void nextTurn() {
		if(current_player == Status.x) {
			current_player = Status.o;
		} else {
			current_player = Status.x;
		}
	}

	/**
	 * main():
	 * creates a game object, which in turn runs the game.
	 * @param args
	 */
	public static void main(String[] args) {
		Main game = new Main();

	}

}
