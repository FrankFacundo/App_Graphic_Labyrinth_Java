package ui;
import javax.swing.*;

public final class HelpMenu extends JMenu
{
	private final InstructionsItem instructionsItem;

	public HelpMenu (MazeApp MazeApp)
	{
		super("Help");
		add(instructionsItem = new InstructionsItem(MazeApp));

	}
}
