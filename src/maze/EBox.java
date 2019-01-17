package maze;

/**
 *	EBox represents an empty box in the maze  
 * 
 */

public final class EBox extends MBox {

	/**
	 * The constructor
	 * @param maze, the maze to which the empty box is linked
	 * @param column, the column at which the empty box will be placed
	 * @param row, the row at which the empty box will be placed
	 * 
	 */
	public EBox(Maze maze , int column, int row) {
		
		super(maze, column, row);
		
	}

	@Override
	public boolean isEmpty() {
		
		return true;
		
	}

	@Override
	public char getChar() {

		return 'E';
	}

	@Override
	public String getLabel() {

		return "EMPTY";
		
	}

	@Override
	public boolean isWall() {

		return false;
		
	}

	@Override
	public boolean isDepart() {

		return false;
		
	}

	@Override
	public boolean isArrival() {

		return false;
		
	}

}
