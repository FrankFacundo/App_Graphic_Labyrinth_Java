package maze;

import java.util.ArrayList;
import java.util.HashMap;

import dijsktra.VertexInterface;

public abstract class EBox extends MBox
{
	public EBox(Maze maze , int column, int row)
	{
		super(maze, column, row);
	}
	
	public boolean isEmpty()
	{
		return true;
	}
	
}
