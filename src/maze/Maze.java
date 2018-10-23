package maze;

import java.util.ArrayList;

import dijsktra.GraphInterface;
import dijsktra.VertexInterface;

public class Maze implements GraphInterface{
	
	private int size; 
	private int[][] vertexMatrix;
	
	public Maze(int size){
		
		this.size = size;
		this.vertexMatrix = new int[this.size][this.size];
	}
	

	@Override
	public ArrayList<VertexInterface> getAllVertexes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getWeight(VertexInterface vertex1, VertexInterface vertex2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VertexInterface getSourceVertex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addVertex(VertexInterface vertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(VertexInterface vertex1, VertexInterface vertex2,
			int weight) {
		// TODO Auto-generated method stub
		
	}

}
