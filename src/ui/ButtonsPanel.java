package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public final class ButtonsPanel extends JPanel {
	
	private final MazeApp app;
	private final SolveButton solveButton;
	
	public ButtonsPanel(MazeApp app) {
		super();
		this.app = app;
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(500,100));
		
		add(solveButton = new SolveButton(app));
		
	}
	
	public void notifyForUpdate() {
		solveButton.notifyForUpdate() ;
	}
}
