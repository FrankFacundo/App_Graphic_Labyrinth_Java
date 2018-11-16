package maze;

import dijsktra.VertexInterface;

public  abstract class MBox implements VertexInterface{
	
	private Maze maze;
	private int column; 
	private int row;
	private String label;
	
	public MBox(Maze maze, int column, int row, String label){
	
		this.maze = maze;
		this.column = column;
		this.row = row;
		this.label = "(" + this.row + "," + this.column + ")";
		
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
	
	public boolean isEmpty()
	{
		return true;
	}
	
	public abstract char getChar();

	
}
