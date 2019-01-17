package dijsktra;
import java.util.HashSet;

/**
 * ASet's interface
 *
 */

public interface ASetInterface {

	/**
	 * To add a vertex to the set
	 * @param vertex, the vertex to add
	 */
	public void add(VertexInterface vertex);

	/**
	 * To verify whether a vertex is contained in ASet or not
	 * @param vertex, the vertex
	 * @return true if vertex is contained in ASet, else false
	 */
	public boolean contains(VertexInterface vertex);

	/**
	 * To get the list of all vertexes in ASet
	 * @return the list of vertexes in ASet
	 */
	public HashSet<VertexInterface> getVertexes();

}
