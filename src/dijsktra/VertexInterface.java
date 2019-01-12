package dijsktra;

public interface VertexInterface {

	/**
	 * To get the String associated with the vertex
	 * @return the String associated to the vertex
	 */
	public String getLabel();
	
	/**
	 * 
	 * @return the String representation of the vertex
	 */
	public String toString();
	

	/**
	 * To get the distance to another vertex (weight)
	 * @param anotherVertex, the other vertex
	 * @return the distance between the current and the other vertex, -1 if anotherVertex is not adjacent to the current vertex
	 */
	public int getDistanceTo(VertexInterface anotherVertex);

	/**
	 * Determines whether a vertex has the same type or not
	 * */
	public boolean hasSameType(VertexInterface vertex);


}
