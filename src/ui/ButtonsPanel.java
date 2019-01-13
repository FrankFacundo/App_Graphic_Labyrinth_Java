package ui;

import java.awt.*;
import javax.swing.*;

public class ButtonsPanel extends JPanel{

	private final SolveButton solveButton;
	private final ReinitializeButton reinitializeButton;

	public ButtonsPanel(MazeApp app) {

		super();
		// this.setLayout(new BorderLayout());
		this.setBackground(Color.GRAY);

		// this.setLayout(new GridLayout(3,1)); 
		this.add(solveButton = new SolveButton(app));
		this.add(reinitializeButton = new ReinitializeButton(app));	

	}

	public SolveButton getSolveButton()
	{
		return solveButton;
	}
	
	public void notifyForUpdate() {

		this.solveButton.notifyForUpdate() ;
		this.reinitializeButton.notifyForUpdate() ;

	}
}

