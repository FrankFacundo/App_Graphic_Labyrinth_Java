package dijsktra;
import java.util.ArrayList;

public interface ASetInterface {
    
	/**
	 * To add a vertex to the set
	 * @param vertex, the vertex to add
	 */
	public void addVertex(VertexInterface vertex);
    
	/**
	 * To verify whether a vertex is contained in ASet or not
	 * @param vertex, the vertex
	 * @return true if vertex is contained in ASet, else false
	 */
    public boolean containsVertex(VertexInterface vertex);
	
    /**
     * To get the list of all vertexes in ASet
     * @return the list of vertexes in ASet
     */
	public ArrayList<VertexInterface> getVertexes();
	

}
