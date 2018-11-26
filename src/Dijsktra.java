import java.util.ArrayList;

public class Dijsktra {

	private static PiInterface Dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, 
									PiInterface pi, PreviousInterface prev){
		/**
		 * "a" is initially empty
		 */
		ArrayList<VertexInterface> allVertices = g.getAllVertexes();
		int n = allVertices.size();	
		//"a" receive the root vertex "r"
		a.addVertex(r);
		
		//We assign to all the vertexes very large values
		for (VertexInterface x : allVertices)
		{
			pi.setPi(x, Integer.MAX_VALUE);
		}
		
		//The value Pi of root vertex receive 0 
		pi.setPi(r,0);
		//The first pivot is root "r"
		VertexInterface pivot = r;
		int piPivot = 0;
		
		//It search the Pi value for all vertexes except the root
		for (int i = 1 ; i<n ; i++)
		{
			ArrayList<VertexInterface> pivotSuccessors = pivot.getAdjacentVertexes();
			for (VertexInterface y : pivotSuccessors)
			{
				if (!a.containsVertex(y))
				{
					int newPi = piPivot + g.getWeight(pivot, y);
					if (newPi < pi.getPi(y))
					{
						pi.setPi(y,newPi);
						prev.setPreviousVertex(y, pivot);
					}
				}
			}

			VertexInterface newPivot = null;
			int piNewPivot = Integer.MAX_VALUE;
			//It search the new pivot and its Pi value
			for (VertexInterface v : allVertices)
			{
				if (!a.containsVertex(v))
				{
					int piV = pi.getPi(v);
					if (piV < piNewPivot)
					{
						newPivot = v;
						piNewPivot = piV;

					}
				}
			}	
			//if there are no more vertexes to process then we return Pi values
			if (newPivot == null)
			{
				return pi;
			}
			
			pivot = newPivot;
			piPivot = piNewPivot;
			a.addVertex(pivot);		
		}		

		return pi;

	}

}