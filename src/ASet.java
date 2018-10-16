import java.util.ArrayList;

public class ASet implements ASetInterface {

	/**
	 * The list of vertexes, whose distances have already been calculated thanks to Dijsktra's algorithm
	 */
	private ArrayList<VertexInterface> vertexes;

	public ASet(){

		this.vertexes = new ArrayList<VertexInterface>();
	}


	public void addVertex(VertexInterface vertex) {

		this.vertexes.add(vertex);

	}


	public boolean containsVertex(VertexInterface vertex) {

		return vertexes.contains(vertex);
	}


	public ArrayList<VertexInterface> getVertexes() {

		return this.vertexes;
	}



}
