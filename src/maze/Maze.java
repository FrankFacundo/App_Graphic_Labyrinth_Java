// hello I'm making a comment to update my branch

package maze;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import dijsktra.GraphInterface;
import dijsktra.VertexInterface;

public class Maze implements GraphInterface{
	
	// The determine the size
	private int width;
	private int height; 
 
	private MBox[][] boxes;
	
	private VertexInterface depart;
	private VertexInterface arrival;
	
	private boolean gameOver = false; 
	

	public Maze(int width, int height){
		
		this.width = width;
		this.height = height;
		// or +2 to have walls in the end 
		
		this.boxes = new MBox[this.width][this.height];
		
		// Cases initialization
		for(int i = 0; i < width; i++) {
		
			for(int j = 0; j < height; j++) {
				
				this.setBox(i,j,'E');
				
			}
			
		}
		
	}
	
	private void setBox(int row, int column, char type){
		
		switch (type) {
		
		case 'E':
			this.boxes[column][row] = new EBox(this, column, row);
		break; 
		
		case 'W':
			this.boxes[column][row] = new WBox(this, column, row);
		break; 
		
		
		case 'A':
			this.boxes[column][row] = new ABox(this, column, row);
			
			
		break; 
		
		case 'D':
			this.boxes[column][row] = new DBox(this, column, row);
		break; 
		
		default:
			return;
		
		
		}
		
	}
	

	public MBox getBox(int column, int row){
		
		return this.boxes[column][row];
		
	}
	

	@Override
	public ArrayList<VertexInterface> getAllVertexes() {
		
		ArrayList<VertexInterface> allVertexes = new ArrayList<VertexInterface>();

		for (int i = 0 ; i < this.height ; i++)
		{
			MBox[] row = boxes[i];
			for (int j = 0 ; j < this.width ; j++)
				
				allVertexes.add(row[j]);
		}

		return allVertexes;
	
	}
	
	/**
	 * 
	 * @param vertex
	 * @return the list of vertexes accessible to a vertex 
	 */
	public final ArrayList<VertexInterface> getAccessibleVertexes(VertexInterface vertex) 
	{
		MBox box = (MBox)vertex ; 
		ArrayList<VertexInterface> accessibleVertexes = new ArrayList<VertexInterface>();
		
		int row = box.getRow();
		int column = box.getColumn();
		MBox neighbor;
		
		// upper neighbors
		if (row > 0) { 
			neighbor = boxes[column][row-1];
			if (neighbor.isEmpty())
				accessibleVertexes.add(neighbor);
		}

		// lower neighbors
		if (row < this.height - 1) { 
			neighbor = boxes[column][row+1];
			if (neighbor.isEmpty())
				accessibleVertexes.add(neighbor);
		}
		
		// left neighbors
		if (column > 0) { 
			neighbor = boxes[column-1][row];
			if (neighbor.isEmpty())
				accessibleVertexes.add(neighbor);
		}
		
		// right neighbors
		if (column < width - 1) { 
			neighbor = boxes[column+1][row];
			if (neighbor.isEmpty())
				accessibleVertexes.add(neighbor);
		}	
		
		return accessibleVertexes;
	}
	

	@Override
	public int getWeight(VertexInterface vertex1, VertexInterface vertex2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VertexInterface getSourceVertex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addVertex(VertexInterface vertex) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addEdge(VertexInterface vertex1, VertexInterface vertex2,
			int weight) {
		// TODO Auto-generated method stub
		
	}
	
	public void createFromTextFile(String textFileName) throws FileNotFoundException, IOException, Exception {
	
	}
	
	public void saveToTextFile(String textFileName) throws FileNotFoundException, IOException, Exception {

	}
	

}
