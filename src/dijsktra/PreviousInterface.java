package dijsktra;
import java.util.ArrayList;

/**
 * Previous vertexes' interface 
 *
 */

public interface PreviousInterface {
 
	/**
	 * To get the previous vertex's value
	 * @param vertex, the vertex whose previous vertex we are looking for
	 * @return the previous vertex 
	 */
	public VertexInterface getValue(VertexInterface vertex);

	/**
	 * To set the previous vertex's value
	 * @param vertex, the vertex whose previous vertex we want to set
	 * @param previousVertex, the previous vertex we want to set 
	 */
	public void setValue(VertexInterface vertex, VertexInterface previousVertexVal);

	/**
	 * By going through the previous vertexes we will find the shortest path
	 * @param vertex
	 * @return a list of vertexes describing the shortest path
	 */
	public ArrayList<VertexInterface> getShortestPath(VertexInterface vertex);

}
