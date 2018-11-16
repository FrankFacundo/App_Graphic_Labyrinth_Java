import java.util.ArrayList;

public interface GraphInterface {

	// To get the number of vertex in the graph 
	public int getNbVertex();

	// To get all the vertexes 
	public ArrayList<VertexInterface> getAllVertexes();

	// To get the weight of an edge joining two vertexes 
	public int getWeight(VertexInterface vertex1, VertexInterface vertex2);

	// To add a vertex to the graph 
   public void addVertex(VertexInterface vertex);

	// To add an edge to the graph
	public void addEdge(VertexInterface vertex1, VertexInterface vertex2, int weight);

	// To get the shortest path from a source to a vertex
	public void findShortestPath(VertexInterface source, VertexInterface vertex);



}
