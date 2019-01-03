package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public final class  CasePanel extends JButton implements ActionListener{
	
	private final MazeApp mazeApp;
	int column; 
	int row;
	
	public CasePanel(MazeApp mazeApp, int column, int row) {
		
		super();
		
		this.mazeApp = mazeApp;
		this.column = column;
		this.row = row;
		
		this.addActionListener(this); // its own action listener
		this.setBackground(Color.WHITE); // default 
		this.repaint(); // paint or update
		
	}
	
	// If an event occurs
	@Override
	public void actionPerformed(ActionEvent e) {
		
		// this.mazeApp.getModel().setModified(true);
		
		this.mazeApp.getModel().setSelectedCase(this.column, this.row);
		
		// this.mazeApp.getModel().colorSelection();
		
		
	}
	
	
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


	
}
