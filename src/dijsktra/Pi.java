package dijsktra;
import java.util.Hashtable;

/**
 * Pi's class will contain the vertexes and the corresponding distance source-vertex
 *
 */

public final class Pi implements PiInterface {

	/**
	 * A HashTable will contain the vertexes and the corresponding distance source-vertex
	 */
	private final Hashtable<VertexInterface, Integer> piTable;

	public Pi() {

		this.piTable = new Hashtable<VertexInterface, Integer>(100);

	}

	/**
	 * To get the value of the distance between a vertex and the source 
	 * @param vertex, the vertex
	 * @return the value of the distance
	 */
	public int getValue(VertexInterface vertex) {

		return this.piTable.get(vertex).intValue();

	}

	/**
	 * To set the distance from the source to a vertex
	 * @param vertex, the vertex
	 * @param newPi, the distance to be set 
	 */
	public void setValue(VertexInterface vertex, int newPi) {

		this.piTable.put(vertex, new Integer(newPi));

	}

}
