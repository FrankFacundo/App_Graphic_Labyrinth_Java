package dijsktra;
import java.util.Hashtable;

public class Pi implements PiInterface {


    // HashTable will contain the vertexes and the corresponding distance source-vertex
	private final Hashtable<VertexInterface, Integer> piTable;

	
	public Pi() {
		
		this.piTable = new Hashtable<VertexInterface, Integer>();
		
	}
    
	public int getValue(VertexInterface vertex) {
	
		
		return piTable.get(vertex).intValue();
		
	}

	public void setValue(VertexInterface vertex, int newPi) {
		
		piTable.put(vertex, new Integer(newPi));
	
		
	}

}
