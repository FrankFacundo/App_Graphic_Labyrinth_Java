// hello I'm making a comment to update my brunch

package maze;

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
	

	public MBox getBox(int row, int column){
		
		return this.boxes[column][row];
		
	}
	
	
	
	
	
	

	@Override
	public ArrayList<VertexInterface> getAllVertexes() {
		// TODO Auto-generated method stub
		return null;
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

}
