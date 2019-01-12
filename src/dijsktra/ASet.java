package dijsktra;
import java.util.HashSet;


public class ASet implements ASetInterface {

	/**
	 * The vertexes, whose distances have already been calculated
	 * thanks to Dijsktra's algorithm
	 */
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
