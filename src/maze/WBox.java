package maze;

/**
 *	WBox represents a wall box in the maze
 * 
 */

public final class WBox extends MBox {
	
	public WBox(Maze maze, int column, int row) {
		
		super(maze, column, row);
		
	}
	

	@Override
	public boolean isEmpty() {
		
		return false;
		
	}

	@Override
	public char getChar() {
		
		return 'W';
	}

	@Override
	public String getLabel() {
		
		return "WALL";
	}

	@Override
	public boolean isWall() {
		
		return true;
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
