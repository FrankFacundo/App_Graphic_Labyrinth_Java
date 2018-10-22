import java.util.ArrayList;
import java.util.HashMap;

public class Vertex implements VertexInterface {

	/**
	 * The value of the vertex, shall not be modified
	 */
	private final String value; 
	/**
	 * The list of vertexes that are adjacent to the current vertex
	 */
	
	private final HashMap<VertexInterface, Integer> adjacents; 
	
	//private ArrayList<VertexInterface> adjacents;
	/**
	 * The list of distances between the current vertex and the adjacent ones
	 * Same indexes as in adjacents list
	 */
	//private ArrayList<Integer> distanceToAdjacents;

	/**
	 * Vertex constructor
	 * @param value, the String value contained in the vertex
	 */
	public Vertex(String value){

		this.value = value;
		this.adjacents = new HashMap<VertexInterface, Integer>();
		//this.adjacents = new ArrayList<VertexInterface>();
		//this.distanceToAdjacents = new ArrayList<Integer>();
	}


	/**
	 * To get the String value contained in the vertex
	 * @return the String associated to the vertex
	 */
	public String getValue() {

		return this.value;
	}

	/**
	 * We consider two vertex equal if they contain the same String value 
	 * Adjacent vertexes are not taken into account for the comparison
	 */
	@Override
	public boolean equals(Object o) {
		// If the object is compared with itself then return true   
		if (o == this) { 
			return true; 
		} 

		// Check if o is an instance of Vertex
		//  "null instanceof [type]" also returns false
		if (!(o instanceof Vertex)) { 
			return false; 
		} 

		// Typecast o to Vertex so that we can compare data   
		Vertex v = (Vertex) o; 

		// Compare data and return accordingly 

		if (this.value == null && v.value != null) {
			return false;

		} else if (!this.value.equals(v.value)){
			return false;

		}
		// If we have not entered to the other conditions
		return true; 

	}

	public String toString() {

		return "[" + this.value + "]";

	}


	public int getDistanceTo(VertexInterface anotherVertex) {
		
		
		if (this.adjacents.containsKey(anotherVertex)){
			
			return this.adjacents.get(anotherVertex);
		  
		} else {
			return -1;
		}
		
	}

	
	public void addAdjacentVertex(VertexInterface vertex, int distance) {
		
		this.adjacents.put(vertex, distance);

	}

	public ArrayList<VertexInterface> getAdjacentVertexes() {

		
		ArrayList<VertexInterface> vertexesList = new ArrayList<VertexInterface>();
		
		for(VertexInterface v: this.adjacents.keySet()) {	
			vertexesList.add(v); 
		}
		//ArrayList<VertexInterface> vertexesList = new ArrayList<VertexInterface>(this.adjacents.keySet());
		
		return vertexesList;
		//return (ArrayList<VertexInterface>) this.adjacents.keySet();
	}

	public HashMap<VertexInterface, Integer> getAdjacentVertexesAndDistances() {

		/*
		ArrayList<VertexInterface>  = new ArrayList<VertexInterface>();
		for(VertexInterface v: adjacents.keySet())
			vertexesList.add(v.clone()); */
		
		//ArrayList<VertexInterface> vertexesList = new ArrayList<VertexInterface>(this.adjacents.keySet());
		
		return this.adjacents;
	}



}
