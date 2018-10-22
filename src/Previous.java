import java.util.ArrayList;
import java.util.HashMap;

public class Previous implements PreviousInterface{

	// We could use hashmap (associative array instead of two lists)
	
	/**
	 * This list will contain the vertexes 
	 */
	//private ArrayList<VertexInterface> vertexes;
	/**
	 * This list will contain the previous vertexes (associated with the vertexes in the vertexes list)
	 * Same indexes as in pathList list
	 */
	//private ArrayList<VertexInterface> previousVertexes;
	
	private final HashMap<VertexInterface, VertexInterface> previousMap; 

	/**
	 * The constructor initializes both the vertex and the previous vertex list
	 */
	public Previous(){

		//this.vertexes = new ArrayList<VertexInterface>();
		//this.previousVertexes = new ArrayList<VertexInterface>();
		this.previousMap = new HashMap<VertexInterface, VertexInterface>(); // will contain the vertex and the previous vertex (father) 

	}

	public VertexInterface getPreviousVertex(VertexInterface vertex) {

		/*
		if (this.vertexes.contains(vertex)){
			int index = this.vertexes.indexOf(vertex);
			return this.previousVertexes.get(index);

		} else {
			return null;
		}*/

		return this.previousMap.get(vertex);
		
		

	}

	public void setPreviousVertex(VertexInterface vertex, VertexInterface previousVertex) {
		/*
		if (this.vertexes.contains(vertex)){
			
			int index = this.vertexes.indexOf(vertex);
			this.previousVertexes.set(index, previousVertex);

		} else {
			this.vertexes.add(vertex);
			this.previousVertexes.add(previousVertex);

		}*/
		this.previousMap.put(vertex, previousVertex);

	}

	// By going through the previous vertexes we will find the shortest path
	// returns the path from the vertex to the source 
	public ArrayList<VertexInterface> getShortestPath(VertexInterface vertex) {
		
		ArrayList<VertexInterface> path = new ArrayList<VertexInterface>();

		while (vertex != null) {
			
			path.add(vertex);
			vertex = this.getPreviousVertex(vertex);
		}

		return path;
	}
	

}
