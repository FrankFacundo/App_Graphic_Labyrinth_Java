package maze;

public class WBox extends MBox {
	
	public WBox(Maze maze, int column, int row) {
		super(maze, column, row);
	}
	
	public void setLabel() {
		
	}
	
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
	
}
