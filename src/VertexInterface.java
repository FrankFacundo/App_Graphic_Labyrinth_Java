public interface VertexInterface {
    
    // To get the index of current vertex 
         public int getIndex();
    
    // To get the distance to another vertex (weight)
    	public int getDistance(VertexInterface vertex);
    	
	// To add an adjacent vertex 
        public void addAdjacentVertex(VertexInterface vertex);
        
    // To get all adjacent vertexes
        public ArrayList<VertexInterface> getAdjacentVertexes(); 


}
