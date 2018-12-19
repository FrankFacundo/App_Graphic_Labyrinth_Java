package ui;


import javax.swing.JMenuItem;
public final class InitFromFileMenuItem extends JMenuItem
{
  private final DrawingApp drawingApp;

  public InitFromFileMenuItem (DrawingApp drawingApp)
  {
    super("Intialize from file");
    this.drawingApp = drawingApp;
  }
  
}


