package ui;
import java.util.Observable;
import java.util.Observer;

import javax.swing.*;

import model.Model;

public class MazeApp extends JFrame implements Observer {
	
	private final MenuBar menuBar;
	private final WindowPanel windowPanel;
	private Model model = new Model(this) ;

	public MazeApp() {
		super("Maze by Sheila & Frank");
		
		this.setIconImage(new ImageIcon(""+System.getProperty("user.dir")+"/data/icon.png").getImage());
		
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
	
	public WindowPanel getWindowPanel()
	{
		return this.windowPanel;
	}
	
	public void update(Observable observable, Object parameter) {
		
		this.windowPanel.notifyForUpdate() ;	
	}

}
