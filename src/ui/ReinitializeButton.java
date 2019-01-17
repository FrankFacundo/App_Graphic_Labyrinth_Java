package ui;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ReinitializeButton extends JButton implements ActionListener {
	
	private final MazeApp mazeApp;
	
	public ReinitializeButton (MazeApp mazeApp) {

		super("Reinitialize");
		this.mazeApp = mazeApp;

		this.addActionListener(this); 

	}
	


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		this.mazeApp.getModel().reinitializeMaze();
		
		
	}
	
	protected final void paintComponent(Graphics g) {
	
		super.paintComponent(g) ;
		
		// If no modifications were made in the maze we cannot reinitialize 
		if(this.mazeApp.getModel().getIsModified()) {
			
			this.setEnabled(true);
		} else {
			this.setEnabled(false);
		}


	}

	
	public void notifyForUpdate() {

		repaint();	
	}
}
