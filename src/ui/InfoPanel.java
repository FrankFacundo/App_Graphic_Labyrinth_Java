package ui;

import java.awt.*;
import javax.swing.*;

public final class InfoPanel extends JPanel {

	private final MazeApp mazeApp;
	private final JLabel label;

	public InfoPanel(MazeApp mazeApp) {


		this.mazeApp = mazeApp;

		// this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());



		this.label = new JLabel("");
		// this.label.setPreferredSize(new Dimension(128,16));

		// this.addActionListener(this);
		//this.setLayout(new FlowLayout());
		this.add(label, BorderLayout.CENTER);   
		this.label.setHorizontalAlignment(JLabel.CENTER);




	}

	@Override
	protected final void paintComponent(Graphics g) {
		// Paint the background
		super.paintComponent(g) ;

		if (this.mazeApp.getModel().getSelectedCase()!= null) 
			this.label.setText(this.mazeApp.getModel().getSelectedCase().getLabel() + " case set");

		/*
		   // Get widget dimension
		   int w = getWidth() ;
		   int h = getHeight() ;

		   // Draw a rectangle
		   g.setColor(this.mazeApp.getModel().getSelectedColor()) ;
		   g.fillRoundRect(4, 4, w-8, h-8, 15, 15) ;

		   // Draw a border
		   g.setColor(Color.BLACK); 
		   g.drawRoundRect(4, 4, w-8, h-8, 15, 15) ;
		 */
	}


	public void notifyForUpdate() {
		repaint();	
	}


}


