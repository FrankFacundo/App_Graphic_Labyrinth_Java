package ui;
import javax.swing.*;
public final class FileMenu extends JMenu
{
  private final QuitMenuItem quitMenuItem;

  public FileMenu (DrawingApp drawingApp)
  {
    super("File");

    add(quitMenuItem = new QuitMenuItem(drawingApp));
  }
}
