package ui;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import model.Model;

public final class QuitMenuItem extends JMenuItem implements ActionListener {
	private final DrawingApp app;

	public QuitMenuItem (DrawingApp app) {
		super("Quit");
		this.app = app;
		addActionListener(this) ;
	}


	@Override
	public void actionPerformed(ActionEvent evt){
		Model model = app.getModel();

		//if (!model.isSolved()) {
			int response = JOptionPane.showInternalOptionDialog(this,
					"You are about to quit the application. Do you want to save this maze before quitting?",
					"Quit Maze by Sheila & Frank",
					JOptionPane.YES_NO_CANCEL_OPTION,
					JOptionPane.WARNING_MESSAGE,
					null,null,null) ;
			
			
			switch (response) {
			case JOptionPane.CANCEL_OPTION:
				return ; // go back to the application 
			case JOptionPane.OK_OPTION:
				//drawingAppModel.saveToFile() ;
				break ;
			case JOptionPane.NO_OPTION:
				break ;
			}
		//} 
		
		System.exit(0) ;
	}



}



