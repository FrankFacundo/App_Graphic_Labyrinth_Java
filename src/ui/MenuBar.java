package ui;
import javax.swing.*;
public final class MenuBar extends JMenuBar
{
  private FileMenu fileMenu;

  public MenuBar (MazeApp MazeApp)
  {
    super();

    add(fileMenu = new FileMenu(MazeApp));
  }
}
