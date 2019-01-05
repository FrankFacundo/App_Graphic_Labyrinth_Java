package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

import model.Model;
public final class SaveToFileMenuItem extends JMenuItem implements ActionListener
{
  private final MazeApp MazeApp;

  public SaveToFileMenuItem (MazeApp MazeApp)
  {
    super("Save to file");
    this.MazeApp = MazeApp;
    addActionListener(this) ;
  }
  
	public void actionPerformed(ActionEvent evt){
	
	
	
	}
  
}
