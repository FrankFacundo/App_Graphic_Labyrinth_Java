package ui;

import java.io.File;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import model.Model;


public final class InitFromFileMenuItem extends JMenuItem implements ActionListener
{
  private final MazeApp MazeApp;

  public InitFromFileMenuItem (MazeApp MazeApp)
  {
    super("Intialize from file");
    this.MazeApp = MazeApp;
    addActionListener(this) ;
  }

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showOpenDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			System.out.println(selectedFile.getAbsolutePath());
		}
	}
  
}


