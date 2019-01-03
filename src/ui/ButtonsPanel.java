package ui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public final class ButtonsPanel extends JPanel {
	
	private final MazeApp app;
	private final SolveButton solveButton;
	
	public ButtonsPanel(MazeApp app) {
		super();
		this.app = app;
		
		setPreferredSize(new Dimension(512,128));
		setBackground(Color.GRAY);
		
		add(solveButton = new SolveButton(app), BorderLayout.CENTER);
		
	}
	
	public void notifyForUpdate() {
		solveButton.notifyForUpdate() ;
	}
}
