public interface ASetInterface {
    
    // To add a vertex to the set
	public void add(VertexInterface vertex);
	
	// To set the values of the vertexes in the set
	public void setASet(VertexInterface[]vertexes);
	
	// To get the set values (vertexes)
	public VertexInterface[] getASetVertex();
	
	// To get the number of vertexes in the set
    public int getLengthASet();
	
	// To verify if a vertex is in the set
    public boolean isVertexInASet(VertexInterface vertex);

    // To get the index of a vertex in the set, -1 if the vertex is not in the set
    public int getIndexOfVertex(VertexInterface vertex);


}
