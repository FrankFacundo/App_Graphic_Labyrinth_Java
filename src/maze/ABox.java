package maze;

import java.util.ArrayList;
import java.util.HashMap;

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
}
