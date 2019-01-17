package ui;
import javax.swing.*;
public final class MenuBar extends JMenuBar
{
  private FileMenu fileMenu;
  private HelpMenu helpMenu;

  public MenuBar (MazeApp MazeApp)
  {
    super();

    add(fileMenu = new FileMenu(MazeApp));
    add(helpMenu = new HelpMenu(MazeApp));
  }
}
