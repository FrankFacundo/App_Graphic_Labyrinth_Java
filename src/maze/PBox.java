package maze;


// import java.io.PrintWriter;

import maze.*;

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
	

}

