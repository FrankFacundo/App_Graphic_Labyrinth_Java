package ui;
import javax.swing.*;
public final class FileMenu extends JMenu
{
  private final QuitMenuItem quitMenuItem;
  private final SaveToFileMenuItem saveToFileMenuItem;
  private final InitFromFileMenuItem initFromFileMenuItem;

  public FileMenu (MazeApp MazeApp)
  {
    super("Options");

    add(initFromFileMenuItem = new InitFromFileMenuItem(MazeApp));
    add(saveToFileMenuItem = new SaveToFileMenuItem(MazeApp));
    add(quitMenuItem = new QuitMenuItem(MazeApp));

    
  }
}
