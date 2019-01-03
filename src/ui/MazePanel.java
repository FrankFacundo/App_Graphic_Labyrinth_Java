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
	
	/*
	public void paintComponents(Graphics g) {
		
		super.paintComponent(g);
		int h = this.getHeight();
		int w = this.getWidth();
		
		for(int i = 0; i < 10; i++) {
			
			for(int j = 0; j < 10; j++) {

				maze[i][j].paint(g, h, w);
			}
		}
		
		
	}
	*/
	
	@Override
	protected void paintComponent(Graphics g)  {
      // Paint the background
      super.paintComponent(g) ;
		
      // Ask the model to draw the cases
      app.getModel().paintCase(g) ;
   }
	
	public void notifyForUpdate() 
	{
	   repaint() ;		
	}

}


