package ui;
import javax.swing.*;
public final class ColorChooser extends JButton
{
  private final DrawingApp drawingApp;

  public ColorChooser (DrawingApp drawingApp)
  {
    super("Choose color");
    this.drawingApp = drawingApp;
  }
}
