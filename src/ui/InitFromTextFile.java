package ui;


import javax.swing.JMenuItem;
public final class InitFromTextFile extends JMenuItem
{
  private final DrawingApp drawingApp;

  public InitFromTextFile (DrawingApp drawingApp)
  {
    super("Intialize from file");
    this.drawingApp = drawingApp;
  }
  
}


