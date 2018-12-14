package ui;
import javax.swing.*;
public final class FileMenu extends JMenu
{
  private final QuitMenuItem quitMenuItem;
  private final SaveToFileMenuItem saveToFileMenuItem;
  private final InitFromTextFile initFromFileMenuItem;

  public FileMenu (DrawingApp drawingApp)
  {
    super("Options");

    add(initFromFileMenuItem = new InitFromTextFile(drawingApp));
    add(saveToFileMenuItem = new SaveToFileMenuItem(drawingApp));
    add(quitMenuItem = new QuitMenuItem(drawingApp));
   //hola

    
  }
}
