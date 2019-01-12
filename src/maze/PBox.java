package maze;


// import java.io.PrintWriter;


public class PBox extends MBox {
	
	public 	PBox(Maze maze, int column, int row) {
		super(maze, column, row);
	}

	/*
	public final void writeCharTo(PrintWriter pw) {
		pw.print('X');
	}
	*/

	@Override
	public char getChar() {
		
		return 'X';
	}

	@Override
	public String getLabel() {
		
		return "STEP";
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isWall() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isDepart() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isArrival() {
		// TODO Auto-generated method stub
		return false;
	}
	

}

