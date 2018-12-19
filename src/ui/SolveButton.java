package ui;
import javax.swing.JButton;
import javax.swing.JMenuItem;

import maze.Maze;

public class SolveButton extends JButton{

  private final DrawingApp app;

  public SolveButton (DrawingApp app) {
    super("Find shortest path");
    this.app = app;
  }
  
 //calculates the shortest path between the depart case and the arrival one
  public final void calculateShortestPath(Maze maze)  {   

  
}
  
}
