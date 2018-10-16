import java.util.ArrayList;

public class Pi implements PiInterface {

	/**
	 * This list will contain the vertexes 
	 */
    private ArrayList<VertexInterface> vertexes;
    /**
     * This list will contain the distance source-vertex
     * Same indexes as in pathList list
     */
    private ArrayList<Integer> distances;

    /**
     * The constructor initializes both the vertex and the distance list
     */
	public Pi() {
		
		this.vertexes = new ArrayList<VertexInterface>();
		this.distances = new ArrayList<Integer>();
		
	}
    
	public int getPi(VertexInterface vertex) {
		
		if (this.vertexes.contains(vertex)){
			  int index = this.vertexes.indexOf(vertex);
			  return this.distances.get(index);
			  
			} else {
				return -1;
			}
	}

	public void setPi(VertexInterface vertex, int newPi) {
		
		this.vertexes.add(vertex);
		this.distances.add(newPi);
		
	}

}
