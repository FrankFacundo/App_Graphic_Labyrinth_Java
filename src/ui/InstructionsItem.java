package ui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public final class InstructionsItem extends JMenuItem implements ActionListener
{
  private final MazeApp MazeApp;

  public InstructionsItem (MazeApp MazeApp)
  {
    super("Instructions");
    this.MazeApp = MazeApp;
    addActionListener(this) ;
  }
  
	public void actionPerformed(ActionEvent evt){
		JOptionPane.showMessageDialog(null, "Click in cases to change the states in the Maze \n\n"
				+ "The color WHITE is an EMPTY case\n"
				+ "The color GREEN is a DEPART case\n"
				+ "The color RED is an ARRIVAL case\n"
				+ "The color GRAY is a WALL case\n",
				"Instruction", JOptionPane.INFORMATION_MESSAGE);

	}
  
}
