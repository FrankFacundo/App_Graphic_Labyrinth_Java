package maze;

import dijsktra.VertexInterface;

public abstract class MBox implements VertexInterface{
	
	private int column; 
	private int row;
	private String label;
	
	public MBox(int column, int row, String label){
		
		this.column = column;
		this.row = row;
		this.label = label;
		
	}

	public String getLabel() {
		
		return this.label;
		
		
	}
	
	public int getColumn() {
		
		return this.column;
	}


	public int getRow() {
		
		return this.row;
	}

	
}
