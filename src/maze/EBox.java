package maze;

import java.util.ArrayList;
import java.util.HashMap;

import dijsktra.VertexInterface;

public class EBox extends MBox
{
	public EBox(Maze maze , int column, int row)
	{
		super(maze, column, row);
	}
{
	
	public boolean isEmpty()
	{
		return true;
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

	@Override
	public char getChar() {
		// TODO Auto-generated method stub
		return 'E';
	}
	
	public void getLabel()
	{
		
	}
}
