package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;

import model.Model;

public final class QuitMenuItem extends JMenuItem implements ActionListener {
	private final MazeApp app;

	public QuitMenuItem (MazeApp app) {
		super("Quit");
		this.app = app;
		addActionListener(this) ;
	}


	@Override
	public void actionPerformed(ActionEvent evt){
		Model model = app.getModel();

		int n = JOptionPane.showOptionDialog(this,
				"You are about to quit the application. Do you want to save this maze before quitting?",
				"Quit Maze by Sheila & Frank",
				
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.WARNING_MESSAGE,
				null,
				null,
				null);
		if (n == JOptionPane.YES_OPTION) {

			JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());

			int returnValue = jfc.showSaveDialog(null);

			if (returnValue == JFileChooser.APPROVE_OPTION) {
				File selectedFile = jfc.getSelectedFile();
				String path = selectedFile.getAbsolutePath();
				System.out.println(path);
				
				try {
					app.getModel().getMaze().saveToTextFile(path);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			System.exit(0) ;

		} else if (n == JOptionPane.NO_OPTION) {

			System.exit(0) ;

		} else if (n == JOptionPane.CANCEL_OPTION){

			return;

		} else {

			return;
		}


	}



}



