public interface ASetInterface {
    
    // To add a vertex to the set
	public void addVertex(VertexInterface vertex);
	
    // To get the index of a vertex in the set
    public int getIndexOfVertex(VertexInterface vertex);
    
	// To verify if a vertex is in the set
    public boolean hasVertex(VertexInterface vertex);
	
	// To get the values of all vertexes
	public VertexInterface[] getVertexes();
	
	// To get the number of vertexes in the set
    public int getLength();


}
