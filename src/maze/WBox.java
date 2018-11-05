package maze;

import java.util.ArrayList;
import java.util.HashMap;

import dijsktra.VertexInterface;

public abstract class WBox extends MBox
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
		return true;
	}

	public String getLabel() {
		return super.getLabel();
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
