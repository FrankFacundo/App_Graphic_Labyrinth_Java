package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
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

			//MazeAppModel.saveToFile() ;
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



