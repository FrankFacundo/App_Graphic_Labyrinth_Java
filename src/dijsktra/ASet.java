package dijsktra;
import java.util.HashSet;

/**
 * ASet's class which represents the ASet: a list containing the vertexes whose distances have already been calculated thanks to Dijsktra's algorithm
 *
 */

public final class ASet implements ASetInterface {

	private HashSet<VertexInterface> vertexes = new HashSet<VertexInterface>();

	public void add(VertexInterface vertex) {

		this.vertexes.add(vertex);

	}

	public boolean contains(VertexInterface vertex) {

		return this.vertexes.contains(vertex);
	}

	public HashSet<VertexInterface> getVertexes() {

		return this.vertexes;
	}

}
