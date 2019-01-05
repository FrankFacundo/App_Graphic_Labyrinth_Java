package ui;
import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;


public final class MazePanel extends JPanel {

	private final MazeApp app;
	private final ArrayList <CasePanel> cases = new ArrayList<CasePanel>();

	public MazePanel(MazeApp app) {
		super();
		this.app = app;

		this.setPreferredSize(new Dimension(512,512));
		// this.setLayout(new GridLayout(10,10));

		this.initializeEmptyMaze();
		this.drawMaze();
	}


	public void initializeEmptyMaze() {

		int size = this.app.getModel().getSize();
		this.setLayout(new GridLayout(size,size));

	}

	public void drawMaze() {

		int size = app.getModel().getSize();


		for (int i = 0; i < size; i++) {

			for (int j = 0; j < size; j++) {

				add(app.getModel().getCase(j, i));

			}

		}
	}

	public void notifyForUpdate() {
		repaint() ;		
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

/*

	@Override
	protected void paintComponent(Graphics g)  {
      // Paint the background
      super.paintComponent(g) ;

      // Ask the model to draw the cases
      app.getModel().paintCase(g) ;
   }

 */




