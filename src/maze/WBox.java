package maze;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;

import dijsktra.VertexInterface;

public class WBox extends MBox
{
	
	public WBox(Maze maze, int column, int row)
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
		
		return 'W';
	}

	@Override
	public void paint(Graphics g, int h, int w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g, int h, int w) {
		// TODO Auto-generated method stub
		
	}
}
