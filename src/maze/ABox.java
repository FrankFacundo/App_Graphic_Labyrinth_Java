package maze;

/**
 *	ABox represents the arrival box (the arrival point in the maze) 
 * 
 */

public final class ABox extends MBox {

	/**
	 * The constructor
	 * @param maze, the maze to which the arrival box is linked
	 * @param column, the column at which the arrival box will be placed
	 * @param row, the row at which the arrival box will be placed
	 * 
	 */
	public ABox(Maze maze, int column, int row) {

		super(maze , column, row);

	}

	@Override
	public boolean isEmpty() {

		return false;

	}

	@Override
	public char getChar() {

		return 'A';

	}

	@Override
	public String getLabel() {

		return "ARRIVAL";

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

		return true;

	}

}
