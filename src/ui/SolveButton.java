package ui;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import maze.Maze;

public class SolveButton extends JButton implements ActionListener {

	private final MazeApp mazeApp;

	public SolveButton (MazeApp mazeApp) {
		super("Find shortest path");
		this.mazeApp = mazeApp;
		
		this.addActionListener(this); // its own action listener
		// this.setBackground(Color.WHITE); // default 
	
		// this.repaint(); // paint or update
		
	}

	//calculates the shortest path between the depart case and the arrival one
	public final void calculateShortestPath(Maze maze)  {   


		try {

			((Maze) maze).findShortestPath();	


		} catch (Exception e) {
			System.err.println("Error: Impossible to solve");

			JOptionPane.showMessageDialog(null, "No maze to solve.", "Error maze", JOptionPane.ERROR_MESSAGE);   

		} finally {

			/*
				Window[] windows = Window.getWindows();
				for(int i=0 ; i < windows.length ; i++)
				{
					windows[i].repaint();	
			 */			
		}

	}



	@Override
	public void actionPerformed(ActionEvent e) {

		System.out.println("Where's the shortest path?");
		this.calculateShortestPath(this.mazeApp.getModel().getMaze());

	}
	
	public void notifyForUpdate() {
		repaint();	
	}





}
