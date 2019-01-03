package maze;
import java.awt.Graphics;


public class EBox extends MBox
{
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
	public void paint(Graphics g, int h, int w) {
		
		g.drawRect(5, 5, w - 10, h - 10);
		
	}
	
	@Override
	public void draw(Graphics g, int h, int w) {
		
		g.drawRect(5, 5, w - 10, h - 10);
		
	}
	
}
