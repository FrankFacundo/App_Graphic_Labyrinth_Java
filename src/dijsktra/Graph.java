package dijsktra;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;

public class Graph implements GraphInterface {


	// The list that will contain the graph's vertexes 
	private ArrayList<VertexInterface> vertexes;
	private VertexInterface source; 

	// The constructor must contain the source vertex (?)
	public Graph() {

		// this.source = sourceVertex; 
		this.vertexes = new ArrayList<VertexInterface>();
	}


	public void setSourceVertex(VertexInterface sourceVertex){

		this.source = sourceVertex;
	}
	
	public VertexInterface getSourceVertex(){

		return this.source;
	}

	public int getWeight(VertexInterface vertex1, VertexInterface vertex2) {

		return vertex1.getDistanceTo(vertex2);
	}


	public void addVertex(VertexInterface vertex) {

		this.vertexes.add(vertex);

	}


	public void addEdge(VertexInterface vertex1, VertexInterface vertex2, int weight) {

		vertex1.addAdjacentVertex(vertex2, weight);

	}


	public ArrayList<VertexInterface> getAllVertexes() {

		return this.vertexes;
	}


	public String toString() {

		
		String str = "Source: " + this.source + "\nPaths:\n";
		
		for (VertexInterface vertex : this.getAllVertexes()) {
			

		    Iterator<Entry<VertexInterface, Integer>> it = vertex.getAdjacentVertexesAndDistances().entrySet().iterator();
		   
		    while (it.hasNext()) {
		    	str += vertex.toString();
		        Entry<VertexInterface, Integer> pair = it.next();
		        str += "-" + pair.getValue() + "->" + pair.getKey() + "\n";
		     
		    }
		    
		    str += "\n";
			
		}
	

		return str;


	}


	@Override
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {
		
		return null;
	}


}
