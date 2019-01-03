package dijsktra;
import java.util.ArrayList;

public interface GraphInterface {

	// To get all the vertexes 
	public ArrayList<VertexInterface> getAllVertexes();

	// To get the weight of an edge joining two vertexes 
	public int getWeight(VertexInterface vertex1, VertexInterface vertex2);


	// Test method 
	public VertexInterface getSourceVertex();

	// Test method 
	public void setSourceVertex(VertexInterface sourceVertex);

	// Test method 
	// To add a vertex to the graph 
	public void addVertex(VertexInterface vertex); // TO DO deleted afterwards

	// Test method 
	// To add an edge to the graph
	/**
	 * Adds an edge of a certain weight from vertex1 to vertex2 
	 * @param vertex1 the source of the edge 
	 * @param vertex2 the target of the edge
	 * @param weight the new edge's weight
	 */
	public void addEdge(VertexInterface vertex1, VertexInterface vertex2, int weight); // TO DO deleted afterwards


}
