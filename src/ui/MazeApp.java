package ui;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import com.sun.prism.Graphics;

import model.Model;
import maze.Maze;

public class MazeApp extends JFrame implements Observer {
	
	private final MenuBar menuBar;
	private final WindowPanel windowPanel;
	private Model model = new Model(this) ;

	public MazeApp() {
		super("Maze by Sheila & Frank");

		this.setJMenuBar(menuBar = new MenuBar(this));		
		this.setContentPane(windowPanel = new WindowPanel(this));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.pack();
		this.setVisible(true);
		this.model.addObserver(this);
		
	}

	public Model getModel() {
		
		return this.model;
	}

	public void setModel(Model model) {
		
		this.model = model;
	}
	
	public void update(Observable observable, Object parameter) {
		
		this.windowPanel.notifyForUpdate() ;	
	}

}
