package maze;

import java.util.ArrayList;
import java.util.HashMap;

import dijsktra.VertexInterface;

public class WBox extends MBox
{
	public WBox(int column, int row)
	{
		super(column, row, "W");
	}
	
	public void setLabel()
	{
		
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
