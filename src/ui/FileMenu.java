package ui;
import javax.swing.*;
public final class FileMenu extends JMenu
{
  private final QuitMenuItem quitMenuItem;
  private final SaveToFileMenuItem saveToFileMenuItem;
  private final InitFromFileMenuItem initFromFileMenuItem;

  public FileMenu (DrawingApp drawingApp)
  {
    super("Options");

    add(initFromFileMenuItem = new InitFromFileMenuItem(drawingApp));
    add(saveToFileMenuItem = new SaveToFileMenuItem(drawingApp));
    add(quitMenuItem = new QuitMenuItem(drawingApp));

    
  }
}
