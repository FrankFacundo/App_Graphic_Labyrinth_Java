package ui;

import java.awt.*;
import javax.swing.*;

public final class InfoPanel extends JPanel {

	private final MazeApp mazeApp;
	private final JLabel label;

	public InfoPanel(MazeApp mazeApp) {

		this.mazeApp = mazeApp;
		
		this.setBackground(Color.GRAY);
		this.setLayout(new BorderLayout());

		this.label = new JLabel("");

		this.add(label, BorderLayout.CENTER);   
		this.label.setHorizontalAlignment(JLabel.CENTER);

	}

	@Override
	protected final void paintComponent(Graphics g) {

		super.paintComponent(g) ;

		if (this.mazeApp.getModel().getIsSolved()) {
			this.label.setText("Shortest path found!");
			
		} else if (this.mazeApp.getModel().getSelectedCase()!= null) {
			this.label.setText(this.mazeApp.getModel().getSelectedCase().getLabel() + " case set");
		} else {
			// No selected case
			this.label.setText("");
		}

	}

	public void notifyForUpdate() {
		
		repaint();	
		
	}

}