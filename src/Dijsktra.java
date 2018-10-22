import java.util.ArrayList;

public class Dijsktra {

	// necessary to pass aSet empty as attribut ?
	// what if r is the source att of the graph? 
	// pi attribut not neccessary 
	
	private static final PreviousInterface dijkstra(GraphInterface graph){
		/**
		 * "aSet" is initially empty
		 */
		Pi pi = new Pi();
		Previous prev = new Previous();
		
		VertexInterface r = graph.getSourceVertex();
		ASet aSet = new ASet();
		ArrayList<VertexInterface> allVertexes = graph.getAllVertexes();
		int n = allVertexes.size();	
		
	
		//"aSet" receives the root vertex "r"
		aSet.addVertex(r);
		
		//We assign great values to all vertexes 
		for (VertexInterface v : allVertexes)
		{
			pi.setPi(v, Integer.MAX_VALUE);
		}
		
		//The Pi value of root vertex receives 0 
		pi.setPi(r,0);
		
		//The first pivot is root "r"
		VertexInterface pivot = r;
		int piPivot = 0;
		
		
		// We search the Pi value for all vertexes except for root
		for (int i = 1 ; i<n ; i++)
		{

			ArrayList<VertexInterface> pivotSuccessors = pivot.getAdjacentVertexes();
			
			
			for (VertexInterface v : pivotSuccessors)
			{
				if (!aSet.containsVertex(v))
				{
					int newPi = piPivot + graph.getWeight(pivot, v);
					
					if (newPi < pi.getPi(v))
					{
						pi.setPi(v, newPi);
						
						prev.setPreviousVertex(v, pivot);
					}
				}
			}

			VertexInterface newPivot = null;
			int piNewPivot = Integer.MAX_VALUE;
			
			//We search the new pivot and its Pi value
			for (VertexInterface v : allVertexes)
			{
				if (!aSet.containsVertex(v))
				{
					int piV = pi.getPi(v);
					if (piV < piNewPivot)
					{
						newPivot = v;
						piNewPivot = piV;


					}
				}
			}	
			
			//if there are no more vertexes to process then we return the previous values (path)
			if (newPivot == null)
			{
				return prev;
			}
			
			pivot = newPivot;
			piPivot = piNewPivot;
			aSet.addVertex(pivot);		
		}		

		return prev;

	}
	
	public static void main(String[] args) {
				
		
		Vertex v1 = new Vertex("Lima");
		Vertex v2 = new Vertex("Ica");
		Vertex v3 = new Vertex("Trujillo");
		Vertex v4 = new Vertex("Arequipa");
		Vertex v5 = new Vertex("Cuzco");
		Vertex v6 = new Vertex("Loreto");

		
		Graph graph = new Graph(v1);
		graph.addVertex(v1);
		graph.addVertex(v2);
		graph.addVertex(v3);
		graph.addVertex(v4);
		graph.addVertex(v5);
		graph.addVertex(v6);
		

		graph.addEdge(v1, v2, 3);
		graph.addEdge(v1, v3, 5);
		graph.addEdge(v1, v4, 6);
		graph.addEdge(v1, v5, 7);

		graph.addEdge(v2, v3, 1);
		graph.addEdge(v2, v4, 5);
		graph.addEdge(v2, v6, 7);
		
		graph.addEdge(v3, v4, 2);
		
		graph.addEdge(v4, v5, 2);
		graph.addEdge(v4, v6, 5);
		
		graph.addEdge(v5, v6, 2); 
		
		System.out.println("The graph: \n" + graph.toString());
		
		// System.out.println("Number of vertexes adjacents to the source : "+v1.getAdjacentVertexesAndDistances().size());
		
		PreviousInterface previous = dijkstra(graph);
		
		ArrayList <VertexInterface> previousVertexes = previous.getShortestPath(v3);
		
		System.out.println("The shortest path to " + v3.getValue() + ": ");

		
		String str = "";
		for(VertexInterface v : previousVertexes) {
			
			str += "<-" + v.toString();
			
		}
		str = str.substring(("<-").length());
		System.out.println(str);
		
		System.out.println("Number of vertexes in the shorstest path: "+previousVertexes.size());
	}
	
	
	

}