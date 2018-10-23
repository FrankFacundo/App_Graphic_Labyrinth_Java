package dijsktra;
import java.util.ArrayList;
import java.util.HashMap;

public interface VertexInterface {


	/**
	 * To get the String value contained in the vertex
	 * @return the String associated to the vertex
	 */
	
	public String getLabel();
	
	/**
	 * 
	 * @return the String representation of the vertex
	 */
	public String toString();
	
	/**
	 * 
	 * @return true if two vertexes are equal, else false
	 */
	public boolean equals(Object o);
	

	/**
	 * To get the distance to another vertex (weight)
	 * @param anotherVertex, the other vertex
	 * @return the distance between the current and the other vertex, -1 if anotherVertex is not adjacent to the current vertex
	 */
	public int getDistanceTo(VertexInterface anotherVertex);


	/**
	 * To add an adjacent vertex
	 * @param vertex, the vertex to add
	 * @param distance, the distance between vertex and the current vertex
	 */ 
	public void addAdjacentVertex(VertexInterface vertex, int distance);

	/**
	 * To get all adjacent vertexes
	 * @return a list containing all adjacent vertexes
	 */
	public ArrayList<VertexInterface> getAdjacentVertexes(); 
	
	public HashMap<VertexInterface, Integer> getAdjacentVertexesAndDistances();


}
