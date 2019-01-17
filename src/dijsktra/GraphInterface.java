package dijsktra;
import java.util.ArrayList;

/**
 * Graph's interface
 *
 */

public interface GraphInterface {

	/**
	 * To get the weight of the distance between two vertexes 
	 * @return the weight of the distance between two vertexes
	 */
	public int getWeight(VertexInterface vertex1, VertexInterface vertex2);

	/**
	 * To get all the vertexes of the graph
	 * @return an array containing all the vertexes
	 */
	public ArrayList<VertexInterface> getAllVertexes();

	/**
	 * To get the all the successors of a given vertex
	 * @param vertex, the vertex whose successors we want to find
	 * @return an array containing all the successors of vertex
	 */
	public ArrayList<VertexInterface> getSuccessors(VertexInterface vertex);

	/**
	 * To get the vertex whose distance is the shortest among the vertexes other in aSet
	 * @param pi, contains all the distances from the root to other vertexes
	 * @param aSet, the set containing the analyzed vertexes
	 * @return the vertex whose path to root has the lowest weight 
	 */
	public VertexInterface getShortestDistanceVertex(PiInterface pi, ASetInterface aSet);

	/**
	 * To get the number of vertexes the the graph
	 * @return the number of vertexes in the graph
	 */
	public int getSize();

}
