package ui;

import java.io.File;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

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
	
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

		int returnValue = jfc.showSaveDialog(null);
		// int returnValue = jfc.showSaveDialog(null);

		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			String path = selectedFile.getAbsolutePath();
			System.out.println(path);
			
			try {
				MazeApp.getModel().getMaze().saveToTextFile(path);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	}
  
}
