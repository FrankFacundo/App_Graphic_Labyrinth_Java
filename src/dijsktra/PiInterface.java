package dijsktra;
public interface PiInterface {

	/**
	 * To get the distance from the source (depart point) to a vertex
	 * @param vertex, the vertex
	 * @return the distance between the source and the vertex
	 */
	public int getValue(VertexInterface vertex);

	/**
	 * To set the distance from the source to a vertex
	 * @param vertex, the vertex
	 * @param newPi, the distance to be set 
	 */
	public void setValue(VertexInterface vertex, int newPi);


}
