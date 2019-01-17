package ui;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.Model;

public final class  CasePanel extends JButton implements ActionListener {

	private final MazeApp mazeApp;
	private int column; 
	private int row;
	private int numberOfClicks;

	public CasePanel(MazeApp mazeApp, int column, int row) {

		super();
		this.mazeApp = mazeApp;
		this.column = column;
		this.row = row;

		this.addActionListener(this); // its own action listener
		this.setBackground(Color.WHITE); // default 
		//this.setOpaque(true);

	}

	// If the case is clicked 
	@Override
	public void actionPerformed(ActionEvent e) {

		this.mazeApp.getModel().setSelectedCase(this.column, this.row);
		this.numberOfClicks++;

		switch (numberOfClicks) {

		case 1: this.mazeApp.getModel().setSelectedColor('W'); break;
		case 2: this.mazeApp.getModel().setSelectedColor('D'); break;
		case 3: this.mazeApp.getModel().setSelectedColor('A'); break;
		case 4: this.mazeApp.getModel().setSelectedColor('E'); numberOfClicks = 0; break;

		}

		this.mazeApp.getModel().changeCaseType();

	}

	protected final void paintComponent(Graphics g) {
		// Paint the background
		super.paintComponent(g) ;
		// Block if the maze was solved 
		if (this.mazeApp.getModel().getIsSolved()) {

			this.setEnabled(false);
		} else {
			this.setEnabled(true);
			
		}

		/*
		if (this.mazeApp.getModel().getIsSolved()) {

			this.setEnabled(false);
		}*/


	}

	public void notifyForUpdate() {

		repaint();	

	}

}