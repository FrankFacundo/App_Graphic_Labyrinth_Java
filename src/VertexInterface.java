import java.util.ArrayList;

public interface VertexInterface {

	// To get the value of current vertex 
	public int getValue();

	// To get the distance to another vertex (weight)
	public int getDistanceTo(VertexInterface anotherVertex);

	// To set the distance to a vertex (?)
	public void setDistanceTo(VertexInterface anotherVertex, int distance);

	// To add an adjacent vertex 
	public void addAdjacentVertex(VertexInterface vertex);

	// To get all adjacent vertexes
	public ArrayList<VertexInterface> getAdjacentVertexes(); 


}
