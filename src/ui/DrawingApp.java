package ui;
import javax.swing.*;

public class DrawingApp extends JFrame 
{
	private final DrawingMenuBar drawingMenuBar;
	
	public DrawingApp()
	{
		super("Maze by Sheila & Frank");

		drawingMenuBar = new DrawingMenuBar(this);
		setJMenuBar(drawingMenuBar);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pack();
		setVisible(true);
	}
}
