package ui;
import javax.swing.JButton;
import javax.swing.JMenuItem;
import maze.Maze;

public class SolveButton extends JButton{

	private final MazeApp app;

	public SolveButton (MazeApp app) {
		super("Find shortest path");
		this.app = app;
	}

	//calculates the shortest path between the depart case and the arrival one
	public final void calculateShortestPath(Maze maze)  {   
		/*

		try {

			((Maze) maze).calculateShortestPath();	

		} catch (NullPointerException e) {
			System.err.println("Erreur: Aucun labyrinthe n'est chargé");
			Component frame = null;
			JOptionPane.showMessageDialog(frame, "Aucun labyrinthe n'est chargé !", "Erreur", JOptionPane.ERROR_MESSAGE);   

		} finally {
			Window[] windows = Window.getWindows();
			for(int i=0 ; i < windows.length ; i++)
			{
				windows[i].repaint();				
			}
		}
	}  
		 */
	}
	
	
	public void notifyForUpdate() {
	  // Case selectedCase  = app.getModel().getSelectedCase() ;

	  // setEnabled(selectedCase != null) ;		
	}
	
	

}
