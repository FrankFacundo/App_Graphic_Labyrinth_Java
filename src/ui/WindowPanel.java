package ui;

import javax.swing.* ;
import java.awt.*;

public final class WindowPanel extends JPanel {
	
	private final MazePanel mazePanel;
	private final BottomPanel bottomPanel;
	
	public WindowPanel(MazeApp app) {
		
		super();
		
		setLayout(new BorderLayout());
		
		add(mazePanel = new MazePanel(app),BorderLayout.CENTER);
		add(bottomPanel = new BottomPanel(app),BorderLayout.SOUTH);
		
	}
	
	public BottomPanel getBottomPanel ()
	{
		return this.bottomPanel;
	}
	
	public void notifyForUpdate() {
		
	   mazePanel.notifyForUpdate() ;
	   bottomPanel.notifyForUpdate() ;
	   
	}
	
}