package dijsktra;
import java.util.*;

/**
 * Previous vertexes' class: by going through the previous vertexes we will find the shortest path
 *
 */

public final class Previous implements PreviousInterface{

	private Hashtable<VertexInterface, VertexInterface> previousTable = new Hashtable<VertexInterface,VertexInterface>();

	public VertexInterface getValue(VertexInterface vertex) {

		return this.previousTable.get(vertex);

	}

	public void setValue(VertexInterface vertex, VertexInterface previousVertexVal) {

		this.previousTable.put(vertex, previousVertexVal);

	}

	public ArrayList<VertexInterface> getShortestPath(VertexInterface vertex){

		ArrayList<VertexInterface> shortestPath = new ArrayList<VertexInterface>();

		while (vertex != null) {

			shortestPath.add(vertex);
			vertex = this.getValue(vertex);

		}

		return shortestPath;		

	}

}
