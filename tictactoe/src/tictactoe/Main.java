package tictactoe;
import java.awt.Color;
import java.awt.FlowLayout;
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

public class Main extends JFrame{

	Board board;
	Status current_player = Status.x;

	public Main() {
		super("Main");
		super.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
		super.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent event) {
				quitGame();
			}
		});
		super.add(new JLabel("Tic Tac Toe"));


		//TODO: Check if there's an unifinished game, if so, load it
		//otherwise populate initial frame w/ question marks

		//TODO: Create board w/ board_size
		int dimension = this.get_dim();

		board = new Board(dimension);

		//Current Player is automatically set to X
		this.current_player = Status.x;

		JFrame frame = new JFrame("Flow Layout");
		frame.setLayout(new GridLayout(dimension,dimension));
		frame.setSize(500,500);  
		frame.setVisible(true);  


		this.populate_init_frame(dimension, frame);

		System.out.println(board.get_squares_list());

		super.pack();
		super.setVisible(true);

	}
	
	private void quitGame() {
		//TODO: prompt user to ask if they want to save, then save
		
		this.dispose();
		System.exit(0);
	}

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
						}


					}
				});
				tmp.add(button);
				frame.add(button);
			}
			updated_squares_list.set(i, tmp);
		}
		System.out.println(updated_squares_list);
		board.set_squares_list(updated_squares_list);
	}

	public int get_dim() {
		try {
			int value = Integer.parseInt(JOptionPane.showInputDialog("You're about to play tic tac toe. Enter a size for the board."));
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

	public Status getPlayer() {
		return current_player;
	}

	public void nextTurn() {
		if(current_player == Status.x) {
			current_player = Status.o;
		} else {
			current_player = Status.x;
		}
	}

	public static void main(String[] args) {
		Main game = new Main();

	}

}
