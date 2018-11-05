package maze;

import java.util.ArrayList;
import java.util.HashMap;

import dijsktra.VertexInterface;

public abstract class DBox extends MBox
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
	public String getLabel() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getDistanceTo(VertexInterface anotherVertex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addAdjacentVertex(VertexInterface vertex, int distance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<VertexInterface> getAdjacentVertexes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<VertexInterface, Integer> getAdjacentVertexesAndDistances() {
		// TODO Auto-generated method stub
		return null;
	}
}
