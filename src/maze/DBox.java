package maze;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import dijsktra.VertexInterface;

public class DBox extends MBox
{
	public DBox(Maze maze, int column, int row)
	{
		super(maze, column, row);
	}
	
	public void setLabel()
	{
		
	}
	
	public boolean isEmpty()
	{
		return false;
	}


	@Override
	public char getChar() {
	
		return 'D';
	}
	
	@Override
	public void paint(Graphics g, int h, int w) {
		
		g.drawRect(5, 5, w - 10, h - 10);
		
	}
}
