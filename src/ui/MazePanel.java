package ui;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public final class MazePanel extends JPanel {

	private final DrawingApp app;
	private final ArrayList <CasePanel> cases = new ArrayList<CasePanel>();

	public MazePanel(DrawingApp app) {
		super();
		this.app = app;

		this.setPreferredSize(new Dimension(500,500));
		this.setLayout(new GridLayout(10,10));

		this.initializeEmptyMaze(10);
	}


	public void initializeEmptyMaze(int size) {
		for(int i = 0; i < 100; i++) {

			cases.add(new CasePanel(app));
			this.add(cases.get(i));
		}

	}

}


