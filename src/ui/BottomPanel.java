package ui;

import java.awt.*;
import javax.swing.*;

public final class BottomPanel extends JPanel {

	private final InfoPanel infoPanel;
	private final ButtonsPanel buttonsPanel;

	public BottomPanel(MazeApp app) {

		super();

		this.setPreferredSize(new Dimension(650,100));
		this.setBackground(Color.GRAY);
		this.setLayout(new GridLayout(3,1)); 

		this.add(infoPanel = new InfoPanel(app));
		this.add(buttonsPanel = new ButtonsPanel(app));

	}
	
	public ButtonsPanel getButtonsPanel () {
		
		return this.buttonsPanel;
	}

	public void notifyForUpdate() {

		this.infoPanel.notifyForUpdate() ;
		this.buttonsPanel.notifyForUpdate() ; // the solve button will be deactivated if the shortest path has been found 

	}
}
