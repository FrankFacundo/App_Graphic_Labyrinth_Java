import ui.DrawingApp;

public class MainTest {
	
	public static void main(String[] args)  {
		
		new DrawingApp();
	}

}



/*
import java.io.FileNotFoundException;
import java.io.IOException;

import maze.Maze;

public class MainTest {
	
	// we will read from data/labyrinthe.txt
	private final static String READINGPATH = "data/labyrinthe.txt";
	
	// save to path data/labyrinthe2.txt
	private final static String WRITINGPATH = "data/labyrinthe2.txt";
	

	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {

	
		Maze maze = new Maze(10, 10);
		
		maze.initFromTextFile(MainTest.READINGPATH);
		
		maze.saveToTextFile(MainTest.WRITINGPATH);
		
		/*
	
		// Testing saveToTextFile
		maze.setBox(1, 2, 'W'); // column number starts at 0, so 1 is for second column
		// 2 is for third row 
		maze.setBox(1, 3, 'A');
		maze.setBox(2, 3, 'D');
		maze.setBox(3, 3, 'W');
		// make it empty 
		//maze.setBox(3, 3, 'E');
	
		System.out.println(maze.getBox(1,2).getLabel());
		System.out.println(maze.getBox(1,2).getChar());
		System.out.println(maze.getBox(1,3).getLabel());
		System.out.println(maze.getBox(1,3).getChar());
		System.out.println(maze.getBox(2,3).getLabel());
		System.out.println(maze.getBox(3,3).getLabel());
		System.out.println(maze.getBox(3,3).getChar());
		
		maze.saveToTextFile(MainTest.WRITINGPATH);
		
		*/

/*

}


}
*/