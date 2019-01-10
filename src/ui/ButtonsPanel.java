package ui;

import java.awt.*;
import javax.swing.*;

public class ButtonsPanel extends JPanel{

	private final SolveButton solveButton;

	public ButtonsPanel(MazeApp app) {

		super();
		// this.setLayout(new BorderLayout());
		this.setBackground(Color.GRAY);

		// this.setLayout(new GridLayout(3,1)); 
		this.add(solveButton = new SolveButton(app));	

	}

	public void notifyForUpdate() {

		this.solveButton.notifyForUpdate() ;

	}
}

