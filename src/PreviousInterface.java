import java.util.ArrayList;

public interface PreviousInterface {
 
	/**
	 * To get the previous vertex
	 * @param vertex, the vertex whose previous vertex we are looking for
	 * @return the previous vertex 
	 */
	public VertexInterface getPreviousVertex(VertexInterface vertex);

	/**
	 * To set the previous vertex
	 * @param vertex, the vertex whose previous vertex we want to set
	 * @param previousVertex, the previous vertex we want to set 
	 */
	public void setPreviousVertex(VertexInterface vertex, VertexInterface previousVertex);

	// By going through the previous vertexes we will find the shortest path
	public ArrayList<VertexInterface> getShortestPath(VertexInterface vertex);

}
