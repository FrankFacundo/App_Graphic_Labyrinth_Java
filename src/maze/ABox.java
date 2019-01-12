package maze;

public class ABox extends MBox {

	public ABox(Maze maze, int column, int row) {
		super(maze , column, row);
	}
	public void setLabel() {

	}

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
