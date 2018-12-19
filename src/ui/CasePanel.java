package ui;

import java.awt.Graphics;
import javax.swing.*;

public final class  CasePanel extends JPanel{
	
	private final DrawingApp app;
	
	public CasePanel(DrawingApp app) {
		super();
		this.app = app;
	}
	
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
