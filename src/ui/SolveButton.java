package ui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import maze.Maze;

public class SolveButton extends JButton implements ActionListener {

	private final MazeApp mazeApp;

	public SolveButton (MazeApp mazeApp) {

		super("Find shortest path");
		this.mazeApp = mazeApp;

		//this.setBorder(BorderFactory.createLineBorder(Color.black));
		// this.setPreferredSize(new Dimension(100,100));
		this.addActionListener(this); 

		// this.repaint(); // paint or update

	}

	//calculates the shortest path between the depart case and the arrival one
	public final void calculateShortestPath(Maze maze)  {   

		try {

			if (this.mazeApp.getModel().findShortestPath()) {

				this.setEnabled(false);

			} else {

				JOptionPane.showMessageDialog(null, "Impossible to find the shortest path. "
						+ "A unique case for the depart and another one for the arrival must be chosen. "
						+ "These cases must be separated by at least one case.",
						"Maze solving error", JOptionPane.ERROR_MESSAGE);
			}
			//((Maze) maze).findShortestPath();	


		} catch (Exception e) {
			System.err.println("Error: Impossible to solve");

			JOptionPane.showMessageDialog(null, "Impossible to solve.", "Error maze", JOptionPane.ERROR_MESSAGE);   

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

		this.calculateShortestPath(this.mazeApp.getModel().getMaze());
		this.mazeApp.getModel().repaintMaze();

		if (this.mazeApp.getModel().getIsSolved()) {
			this.mazeApp.getModel().blockCases();
		}
	}

	public void notifyForUpdate() {

		/*if (this.mazeApp.getModel().getIsSolved()) {
			this.setEnabled(false);
		} // fix this
		*/
		repaint();	
	}

}