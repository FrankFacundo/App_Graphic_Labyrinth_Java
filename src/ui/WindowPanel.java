package ui;
import javax.swing.* ;
import java.awt.*;

public final class WindowPanel extends JPanel {
	
	private final MazePanel mazePanel;
	private final ButtonsPanel buttonsPanel;
	
	public WindowPanel(MazeApp app) {
		super();
		
		setLayout(new BorderLayout());
		
		add(mazePanel = new MazePanel(app),BorderLayout.CENTER);
		add(buttonsPanel = new ButtonsPanel(app),BorderLayout.SOUTH);
		
	}
	
	public void notifyForUpdate() {
	   mazePanel.notifyForUpdate() ;
	   buttonsPanel.notifyForUpdate() ;
	}
	
}

