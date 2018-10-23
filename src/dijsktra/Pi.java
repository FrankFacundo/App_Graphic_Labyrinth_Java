package dijsktra;
import java.util.HashMap;

public class Pi implements PiInterface {

	/**
	 * This list will contain the vertexes 
	 */
    //private ArrayList<VertexInterface> vertexes;
    /**
     * This list will contain the distance source-vertex
     * Same indexes as in pathList list
     */
    //private ArrayList<Integer> distances;
	
	private final HashMap<VertexInterface, Integer> piMap;

    /**
     * The constructor initializes both the vertex and the distance list
     */
	public Pi() {
		
		this.piMap = new HashMap<VertexInterface, Integer>();
		
	}
    
	public int getPi(VertexInterface vertex) {
		/*
		if (this.vertexes.contains(vertex)){
			  int index = this.vertexes.indexOf(vertex);
			  return this.distances.get(index);
			  
			} else {
				return -1;
			}*/
		return piMap.get(vertex).intValue();
		
	}

	public void setPi(VertexInterface vertex, int newPi) {
		
		piMap.put(vertex, new Integer(newPi));
		
		//this.vertexes.add(vertex);
		//this.distances.add(newPi);
		
	}

}
