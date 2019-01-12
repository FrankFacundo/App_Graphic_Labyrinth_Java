package maze;

import dijsktra.VertexInterface;

public  abstract class MBox implements VertexInterface{
	
	private Maze maze;
	private int column; 
	private int row;

	
	public MBox(Maze maze, int column, int row){
	
		this.maze = maze;
		this.column = column;
		this.row = row;
		
	}

	public abstract String getLabel();	
		
	public int getColumn() {
		
		return this.column;
	}


	public int getRow() {
		
		return this.row;
	}
	
	public abstract char getChar();
	
	public String toString() {
		
		return "(" + this.column + "," + this.row  +")";
		
	}

	
	
	@Override
	public int getDistanceTo(VertexInterface anotherVertex) {
		
		return 1;
	}
	
	/**
	 * To compare two boxes' types 
	 * @param vertex, the first box 
	 * @return true if the boxes have the same type, else false
	 */
	public boolean hasSameType(VertexInterface vertex) {
		
		return vertex.getLabel() == this.getLabel();
		
	}
	
	
	/** 
	 * To know whether the box is a empty or not
	 * @return true if the box is empty, else false 
	 * @see EBox
	 */
	public abstract boolean isEmpty();
	
	/** 
	 * To know whether the box is a wall or not
	 * @return true if the box is a wall, else false 
	 * @see WBox
	 */
	public abstract boolean isWall();
	
	/** To know whether the box is a start or not
	 * @return true if the box is the depart, else false 
	 * @see DBox
	 */
	public abstract boolean isDepart();
	
	/** To know whether the box is a exit or not
	 * @return true if the box is the arrival, else false 
	 * @see ABox
	 */
	public abstract boolean isArrival();
	
	
	
}
