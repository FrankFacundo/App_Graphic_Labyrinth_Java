package ui;

import java.awt.*;
import javax.swing.*;

public final class MazePanel extends JPanel {

	private final MazeApp app;

	public MazePanel(MazeApp app) {
		
		super();
		this.app = app;

		this.setPreferredSize(new Dimension(650,650));

		this.initializeEmptyMaze(this.app.getModel().getSize());
	}


	public void initializeEmptyMaze(int size) {

		this.setLayout(new GridLayout(size,size));
		
		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {

				this.add(app.getModel().getCase(j, i));

			}

		}

	}

	public void notifyForUpdate() {
		this.repaint() ;		
	}

}