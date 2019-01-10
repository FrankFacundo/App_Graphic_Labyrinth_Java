package maze;

public class EBox extends MBox {
	
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
	
	
}
