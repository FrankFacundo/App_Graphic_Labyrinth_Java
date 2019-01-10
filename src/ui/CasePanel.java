package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

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

		// this.mazeApp.getModel().setModified(true);

		this.mazeApp.getModel().setSelectedCase(this.column, this.row);
		
		//this.mazeApp.getModel().updateTextInPanel(this);

		/*
		System.out.println("the selected case " + this.mazeApp.getModel().getSelectedCase());
		System.out.println("the case is in column: "+this.mazeApp.getModel().getSelectedCase().getColumn()+" and row"+
					this.mazeApp.getModel().getSelectedCase().getRow()); */


		this.numberOfClicks++;
		//System.out.println("the number of clicks: "+numberOfClicks);

		switch (numberOfClicks) {

		case 1: this.mazeApp.getModel().setSelectedColor('W'); break;
		case 2: this.mazeApp.getModel().setSelectedColor('D'); break;
		case 3: this.mazeApp.getModel().setSelectedColor('A'); break;
		case 4: this.mazeApp.getModel().setSelectedColor('E'); numberOfClicks = 0; break;

		}

		this.mazeApp.getModel().changeCaseColor();
		
	


		// System.out.println("the color has changed to: "+this.mazeApp.getModel().getSelectedColor());	


	}

	public void notifyToUpdate() {

		this.repaint() ;	
        
	}
	
	



	/*
	// Bellot ?
	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);

		int xcoord = this.getWidth();
		int ycoord = this.getHeight();

		g.drawRect(5, 5, xcoord - 10, ycoord - 10);
		// first parameters are for x and y coordinates 
		// second parameters are for the width and height of the case

		// ens d elements qui servent a redessiner la fenetre, case par case, au moins le paneau : matrice de cases 
	}

	 */



}
