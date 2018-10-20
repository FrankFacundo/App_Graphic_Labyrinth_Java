import java.util.ArrayList;

public class Dijsktra {

	private static PiInterface Dijkstra(GraphInterface g, VertexInterface r, ASetInterface a, 
									PiInterface pi, PreviousInterface prev){
		// a is initially empty
		ArrayList<VertexInterface> allVertices = g.getAllVertexes();
		int n = allVertices.size();	
		a.addVertex(r);

		for (VertexInterface x : allVertices)
		{
			pi.setPi(x, Integer.MAX_VALUE);
		}

		pi.setPi(r,0);
		VertexInterface pivot = r;
		int piPivot = 0;

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