package tictactoe;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.*;

public class Main extends JFrame{

	public Main() {
		super("Main");
		super.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		super.add(new JLabel("Tic Tac Toe"));
		//TODO: Create board w/ board_size
		int dimension = this.get_dim();
		JFrame frame = new JFrame("Flow Layout");
		frame.setLayout(new GridLayout(dimension,dimension));
		frame.setSize(500,500);  
		frame.setVisible(true);  
		
		//TODO: Check if there's an unifinished game, if so, load it
		//otherwise populate initial frame w/ question marks
		
		this.populate_init_frame(dimension, frame);
		
		super.pack();
		super.setVisible(true);
	}

	public void populate_init_frame(int dimension, JFrame frame) {
		//Create buttons
		for (int i = 0; i < dimension*dimension; i++) {
			JButton button = new JButton("?");
			frame.add(button);
		}
	}

	public int get_dim() {
		int value = Integer.parseInt(JOptionPane.showInputDialog("Input Dimension"));
		return value;
	}

	public static void main(String[] args) {

		new Main();
	}

}
