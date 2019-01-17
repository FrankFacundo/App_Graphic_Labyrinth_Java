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
		JOptionPane.showMessageDialog(null, "Click on a case in the maze to change its type \n\n" 
				+ "The color WHITE is for an EMPTY case\n"
				+ "The color GREEN is for a DEPART case\n"
				+ "The color RED is for an ARRIVAL case\n"
				+ "The color GRAY is for a WALL case\n",
				"Instruction", JOptionPane.INFORMATION_MESSAGE);

	}

}
