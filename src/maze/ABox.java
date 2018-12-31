package maze;

import java.util.ArrayList;

import java.util.HashMap;

//import com.sun.prism.Graphics;
import java.awt.Graphics;

import dijsktra.VertexInterface;

public class ABox extends MBox
{
	
	public ABox(Maze maze, int column, int row)
	{
		super(maze , column, row);
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
	
		return 'A';
	}
	

	@Override
	public void paint(Graphics g, int h, int w) {
		
		g.drawRect(5, 5, w - 10, h - 10);
		
	}
	
	
}
