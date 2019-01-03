package ui;


import javax.swing.JMenuItem;
public final class InitFromFileMenuItem extends JMenuItem
{
  private final MazeApp MazeApp;

  public InitFromFileMenuItem (MazeApp MazeApp)
  {
    super("Intialize from file");
    this.MazeApp = MazeApp;
  }
  
}


