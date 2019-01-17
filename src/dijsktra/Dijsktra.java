package dijsktra;
import java.util.ArrayList;

/**
 * Dijsktra's class which will allow us to find the shortest path by using Dijsktra's algorithm
 *
 */

public final class Dijsktra {

	/**
	 * Public method of Dijkstra's algorithm 
	 * @param g, the graph whose shortest path will be found
	 * @param r, the root vertex (source) for which we will find the shortest path to all others vertexes in the graph
	 * @return a Previous object which will contain all the shortest paths which depart from the root vertex
	 */
	public static PreviousInterface dijkstra(GraphInterface graph, VertexInterface r) {

		ASetInterface aSet = new ASet();
		PiInterface pi = new Pi();
		PreviousInterface previous = new Previous();

		return Dijsktra.dijkstra(graph,r,aSet,pi,previous);

	}

	/**
	 * To apply Dijkstra's algorithm to a given graph, departing from a given root vertex
	 * @param g, the graph whose shortest path will be found
	 * @param r, the root vertex (source) for which we will find the shortest path to all others vertexes in the graph
	 * @param aSet, a set which will contain the analyzed vertexes
	 * @param pi, a Pi object which will contain the distances to the root vertex
	 * @param previous, a Previous object which will contain the shortest paths
	 * @return a Previous object which will contain all the shortest paths which depart from the root vertex
	 */
	private static PreviousInterface dijkstra(GraphInterface graph, VertexInterface r, ASetInterface aSet, PiInterface pi, PreviousInterface previous) {

		// All the vertex from the graph/maze
		ArrayList<VertexInterface> allvertex = graph.getAllVertexes();

		// The first pivot is root "r" (source vertex)
		VertexInterface pivot = r;
		// The successors of pivot (accessible and adjacent vertexes) 
		ArrayList<VertexInterface> pivotSuccessors;
		// The aSet's first element is the root 
		aSet.add(r);
		// The Pi value of the root vertex receives 0 
		pi.setValue(r, 0);

		// Initialization: we assign great values to all vertexes, except for root
		for(VertexInterface v : allvertex) {

			if (!v.hasSameType(r)) {

				pi.setValue(v, Integer.MAX_VALUE);
			}
		}

		// We compare distances for all accessible vertexes that are not yet in aSet
		int i = 1; 
		int newPi;

		while (i < graph.getSize() && pivot != null) {

			pivotSuccessors = graph.getSuccessors(pivot);

			for(VertexInterface v : pivotSuccessors) {   

				if (!aSet.contains(v)) {

					newPi = pi.getValue(pivot) + graph.getWeight(pivot, v);

					if (newPi <  pi.getValue(v)) {

						pi.setValue(v, newPi);
						previous.setValue(v, pivot);  

					}
				}	
			}
			// We get the vertex in aSet whose distance is the shortest to root 
			pivot = graph.getShortestDistanceVertex(pi, aSet);
			aSet.add(pivot);
			i++;
		}

		return previous;
	}

}
