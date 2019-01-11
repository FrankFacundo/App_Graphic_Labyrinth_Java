package dijsktra;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;

public class Previous implements PreviousInterface{

	// We use Hashtable (associative array instead of two lists)
	private final Hashtable<VertexInterface, VertexInterface> previousTable; 

	/**
	 * The constructor initializes the Hashtable containing both the vertex and the previous vertex
	 */
	public Previous(){

		this.previousTable = new Hashtable<VertexInterface, VertexInterface>(); // will contain the vertex and the previous vertex (father) 

	}

	public VertexInterface getValue(VertexInterface vertex) {


		return this.previousTable.get(vertex);
		

	}

	public void setValue(VertexInterface vertex, VertexInterface previousVertexVal) {
		
		
		this.previousTable.put(vertex, previousVertexVal);

	}

	// By going through the previous vertexes we will find the shortest path
	// returns the path from the vertex to the source 
	public ArrayList<VertexInterface> getShortestPath(VertexInterface vertex) {
		
		ArrayList<VertexInterface> path = new ArrayList<VertexInterface>();

		while (vertex != null) {
			
			path.add(vertex);
			vertex = this.getValue(vertex);
			
			System.out.println("vertex is not null");
		}

		System.out.println("number of elements in shorthest path "+path.size());
		return path;
		
		
	}
	

}
