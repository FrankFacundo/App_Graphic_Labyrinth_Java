package ui;
import javax.swing.*;

public class DrawingApp extends JFrame 
{
	private final DrawingMenuBar drawingMenuBar;
	private final WindowPanel panel;
	
	public DrawingApp()
	{
		super("Maze by Sheila & Frank");

		drawingMenuBar = new DrawingMenuBar(this);
		this.setJMenuBar(drawingMenuBar);
		this.setContentPane(panel = new WindowPanel(this));
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
		this.setVisible(true);
	}
}
