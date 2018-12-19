package ui;

import javax.swing.JMenuItem;
public final class SaveToFileMenuItem extends JMenuItem
{
  private final DrawingApp drawingApp;

  public SaveToFileMenuItem (DrawingApp drawingApp)
  {
    super("Save to file");
    this.drawingApp = drawingApp;
  }
  
}
