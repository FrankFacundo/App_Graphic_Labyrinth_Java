package ui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.*;

public final class ButtonsPanel extends JPanel {
	
	private final DrawingApp app;
	private final SolveButton solveButton;
	
	public ButtonsPanel(DrawingApp app) {
		super();
		this.app = app;
		setBackground(Color.GRAY);
		setPreferredSize(new Dimension(500,100));
		
		add(solveButton = new SolveButton(app));
		
	}
}