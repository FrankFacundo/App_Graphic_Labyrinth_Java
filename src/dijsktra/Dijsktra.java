package dijsktra;
import java.util.ArrayList;

public class Dijsktra {


	// Public method of Dijkstra's algorithm
	public static PreviousInterface dijkstra(GraphInterface graph, VertexInterface r) {
		// what if r is the source attribute of the graph? 

		Pi pi = new Pi();
		Previous prev = new Previous();
		ASet aSet = new ASet(); // initially empty 

		graph.setSourceVertex(r);
		
		ArrayList<VertexInterface> allVertexes = graph.getAllVertexes();
		int n = allVertexes.size();	

		//"aSet" receives the root vertex "r"
		aSet.add(r);

		//Initialization: we assign great values to all vertexes 
		for (VertexInterface v : allVertexes) {
			pi.setValue(v, Integer.MAX_VALUE);
		}

		//The Pi value of root vertex receives 0 
		pi.setValue(r,0);

		//The first pivot is root "r"
		VertexInterface pivot = r;
		int piPivot = 0;


		// We search the Pi value for all vertexes except for root
		for (int i = 1 ; i<n ; i++) {

			ArrayList<VertexInterface> pivotSuccessors = graph.getSuccessors(pivot);
			//ArrayList<VertexInterface> pivotSuccessors = pivot.getSuccessors();
			int j = 0;
			//System.out.println(pivot.getLabel()+i+" has this number of adjacent accessible vertexes: "+ pivotSuccessors.size());
			if(pivotSuccessors!=null)
			for (VertexInterface v : pivotSuccessors) {

				if (!aSet.contains(v)) {
					int newPi = piPivot + graph.getWeight(pivot, v);
					 System.out.println(j+"times doing weight: "+ graph.getWeight(pivot, v));

					if (newPi < pi.getValue(v)) {
						pi.setValue(v, newPi);
						prev.setValue(v, pivot);
					}
				}

				//System.out.println("adding element number "+j);
			}

			j++;

			VertexInterface newPivot = null;
			int piNewPivot = Integer.MAX_VALUE;

			//We search the new pivot and its Pi value

			for (VertexInterface v : allVertexes) {
				if (!aSet.contains(v)) {
					int piValue = pi.getValue(v);

					// System.out.println("pi value: "+ piValue);
					// System.out.println("v value: "+ v);
					if (piValue < piNewPivot) {
						// System.out.println("I do this once");
						newPivot = v;
						piNewPivot = piValue;

						// System.out.println("setting newpivot to " + v);
						// System.out.println("after setting " + newPivot);
					} else {
						// System.out.println("setting newpivot to " + v);
						System.out.println("after setting " + newPivot);

					}
				}
			}	

			//If there are no more vertexes to process then we return the previous values (path)

			// on passe par ce for une fois
			if (newPivot == null) {

				//System.out.println("newPivotnull");
				// System.out.println("number of vertexes in prev: "+prev.getShortestPath(r));
				return prev;
			}

			// on ne vient pas ici 
			pivot = newPivot;
			piPivot = piNewPivot;
			aSet.add(pivot);	


		}		

		System.out.println("We get to the end once at least: "+prev.getShortestPath(r));
		return prev;

		

	}

	public static void main(String[] args) {


		Vertex v1 = new Vertex("Lima");
		Vertex v2 = new Vertex("Ica");
		Vertex v3 = new Vertex("Trujillo");
		Vertex v4 = new Vertex("Arequipa");
		Vertex v5 = new Vertex("Cuzco");
		Vertex v6 = new Vertex("Loreto");


		Graph graph = new Graph();
		//graph.setSourceVertex(v1);

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

		// System.out.println("Number of vertexes adjacent to the source : "+v1.getAdjacentVertexesAndDistances().size());

		PreviousInterface previous = dijkstra(graph, v1);

		System.out.println("The graph: \n" + graph.toString());


		ArrayList <VertexInterface> previousVertexes = previous.getShortestPath(v3);

		System.out.println("The shortest path to " + v3.getLabel() + ": ");


		String str = "";
		for(VertexInterface v : previousVertexes) {

			str += "<-" + v.toString();

		}
		str = str.substring(("<-").length());
		System.out.println(str);

		System.out.println("Number of vertexes in the shortest path: "+previousVertexes.size());
	}

}