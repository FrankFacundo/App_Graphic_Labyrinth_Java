package ui;
import javax.swing.*;
public final class DrawingMenuBar extends JMenuBar
{
  private FileMenu fileMenu;

  public DrawingMenuBar (DrawingApp drawingApp)
  {
    super();

    add(fileMenu = new FileMenu(drawingApp));
  }
}