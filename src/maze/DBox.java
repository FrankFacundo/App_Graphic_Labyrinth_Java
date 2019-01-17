package maze;

/**
 *	DBox represents the departure box (the depart  point in the maze) 
 * 
 */

public final class DBox extends MBox {

	public DBox(Maze maze, int column, int row) {

		super(maze, column, row);

	}

	@Override
	public boolean isEmpty() {

		return false;

	}


	@Override
	public char getChar() {

		return 'D';
	}

	@Override
	public String getLabel() {

		return "DEPART";
	}


	@Override
	public boolean isWall() {

		return false;
	}


	@Override
	public boolean isDepart() {

		return true;
	}


	@Override
	public boolean isArrival() {

		return false;
	}

}

