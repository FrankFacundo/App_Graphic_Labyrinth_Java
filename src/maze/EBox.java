package maze;

public final class EBox extends MBox {

	public EBox(Maze maze , int column, int row) {
		super(maze, column, row);
	}


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
