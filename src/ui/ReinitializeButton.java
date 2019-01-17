package ui;

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

	
	public void notifyForUpdate() {

		repaint();	
	}
}
