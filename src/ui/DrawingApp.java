package ui;
import java.util.Observable;

import javax.swing.*;

import com.sun.prism.Graphics;

import model.Model;
import maze.Maze;

public class DrawingApp extends JFrame 
{
	private final DrawingMenuBar drawingMenuBar;
	private final WindowPanel windowPanel;
	private Model model = new Model() ;
	private Maze maze;

	public DrawingApp() {
		super("Maze by Sheila & Frank");

		drawingMenuBar = new DrawingMenuBar(this);
		this.setJMenuBar(drawingMenuBar);
		this.setContentPane(windowPanel = new WindowPanel(this));

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}


	public void paintComponents(java.awt.Graphics g) {

		super.paintComponents(g);
		int h = this.getHeight();
		int w = this.getWidth();

		for(int i = 0; i < 10; i++) {

			for(int j = 0; j < 10; j++) {

				this.maze.paint(i, j, g, h, w);
			}
		}


	}

	public void update(Observable observable, Object parameter) {
		windowPanel.notifyForUpdate() ;	
	}

	public Model getModel() {
		return this.model;
	}


	public void setModel(Model model) {
		this.model = model;
	}

}
