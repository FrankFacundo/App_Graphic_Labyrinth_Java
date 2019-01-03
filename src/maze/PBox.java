package maze;

import java.awt.Graphics;
// import java.io.PrintWriter;

import maze.MBox;
import maze.Maze;

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
	public void paint(Graphics g, int h, int w) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g, int h, int w) {
		// TODO Auto-generated method stub
		
	}
}

