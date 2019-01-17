package dijsktra;

/**
 * Vertex's interface
 *
 */

public interface VertexInterface {

	/**
	 * To get the String associated with the vertex
	 * @return the String associated to the vertex
	 */
	public String getLabel();

	/**
	 * To get a String representation of the position of the vertex (x coordinate, y coordinate) 
	 * @return the String representation of the vertex's coordinates
	 */
	public String toString();

	/**
	 * To get the distance to another vertex (weight)
	 * @param anotherVertex, the other vertex
	 * @return the distance between the current and the other vertex
	 */
	public int getDistanceTo(VertexInterface anotherVertex);

	/**
	 * To determine whether two vertexes are from a same type or not (label comparison)
	 * @param vertex, the other vertex
	 * @return true if the two vertexes are from the same type, else false 
	 * */
	public boolean hasSameType(VertexInterface vertex);

}
