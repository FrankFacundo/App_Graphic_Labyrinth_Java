package maze;
import dijsktra.VertexInterface;

/**
 *	MBox is the super class used for all the other boxes
 * 
 */

public abstract class MBox implements VertexInterface{

	private Maze maze;
	private int column; 
	private int row;

	/**
	 * The constructor
	 * @param maze, the maze to which the box is linked
	 * @param column, the column at which the box will be placed
	 * @param row, the row at which the box will be placed
	 * 
	 */
	public MBox(Maze maze, int column, int row){

		this.maze = maze;
		this.column = column;
		this.row = row;

	}

	public abstract String getLabel();	

	/** 
	 * To get the column of the current box 
	 * @return the column of the current box 
	 * 
	 */
	public int getColumn() {

		return this.column;
	}

	/** 
	 * To get the row of the current box 
	 * @return the row of the current box 
	 * 
	 */
	public int getRow() {

		return this.row;
	}

	/** 
	 * To get the char 
	 * @return the char representing the current box 
	 * 
	 */
	public abstract char getChar();

	public String toString() {

		return "(" + this.column + "," + this.row  +")";

	}

	public int getDistanceTo(VertexInterface anotherVertex) {

		return 1;
		
	}

	/**
	 * To compare two boxes' types  (by their label)
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
