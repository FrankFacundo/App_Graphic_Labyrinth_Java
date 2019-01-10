package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import maze.ABox;
import maze.DBox;
import maze.EBox;
import maze.MazeReadingException;
import maze.WBox;
import model.Model;


public final class InitFromFileMenuItem extends JMenuItem implements ActionListener {
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
			String path = selectedFile.getAbsolutePath();
			System.out.println(path);
			try {
				FileReader fr = new FileReader(path);
				BufferedReader bufferedReader = new BufferedReader(fr);	

				// the object already exists so height and width are already determined
				for (int i = 0 ; i < this.MazeApp.getModel().getSize() ; i++) {

					String row = bufferedReader.readLine();

					// If the row we are reading is null 
					if (row == null) {

						// System.err.println("Insufficient number of rows");
						throw new MazeReadingException(path, i, " Insufficient number of rows." );

					} else {

						// we check the size
						if (row.length() < this.MazeApp.getModel().getSize()) {

							// System.err.println("The row "+ i + 1 + " does not contain enough cases");
							throw new MazeReadingException(path, i, "The row " + i + 1 +
									" does not contain enough cases" );

						} else if (row.length() > this.MazeApp.getModel().getSize()) {


							// System.err.println("The row "+ i + 1 + " contains too many cases");
							throw new MazeReadingException(path, i, "The row " + i + 1 + " contains too many cases" );

						} else {

							for (int j = 0 ; j < this.MazeApp.getModel().getSize() ; j++)
							{
								this.MazeApp.getModel().setSelectedCase(j, i);
								switch (row.charAt(j)) 
								{
								case 'D' :
									this.MazeApp.getModel().setSelectedColor('D');
									break;
								case 'A' :
									this.MazeApp.getModel().setSelectedColor('A');
									break;
								case 'W' :
									this.MazeApp.getModel().setSelectedColor('W');
									break;
								case 'E' :
									this.MazeApp.getModel().setSelectedColor('E');
									break;         	
								default :

									//System.err.println("Invalid character");
									throw new MazeReadingException(path, i, " Unknown character: " +
											this.MazeApp.getModel().getMaze().getBoxSymbol(j, i) + "." );

								}
								this.MazeApp.getModel().changeCaseType();
							} 

						}

					}

				}


				//MazeApp.getModel().getMaze().initFromTextFile(path);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}



}


