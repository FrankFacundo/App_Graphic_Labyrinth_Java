package ui;

import javax.swing.JMenuItem;
public final class SaveToFileMenuItem extends JMenuItem
{
  private final MazeApp MazeApp;

  public SaveToFileMenuItem (MazeApp MazeApp)
  {
    super("Save to file");
    this.MazeApp = MazeApp;
  }
  
}
