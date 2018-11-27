// hello I'm making a comment to update my branch

package maze;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dijsktra.GraphInterface;
import dijsktra.VertexInterface;

public class Maze implements GraphInterface{

	// The determine the size
	private final static String PATH = "/Users/Sheila/Desktop/maze.txt";
	private int width;
	private int height; 

	private MBox[][] boxes;

	private VertexInterface depart;
	private VertexInterface arrival;

	private boolean end = false; 


	public Maze(int width, int height){

		this.width = width;
		this.height = height;
		// or +2 to have walls in the end 

		this.boxes = new MBox[this.width][this.height];

		// Cases initialization
		for(int i = 0; i < height; i++) {

			for(int j = 0; j < width; j++) {

				this.setBox(i,j,'E');

			}

		}

	}

	private void setBox(int column, int row, char type){

		switch (type) {

		case 'E':
			// pay attention when accessing directly to this.boxes [row][column]
			this.boxes[row][column] = new EBox(this, column, row);
			break; 

		case 'W':
			this.boxes[row][column] = new WBox(this, column, row);
			break; 


		case 'A':
			this.boxes[row][column] = new ABox(this, column, row);


			break; 

		case 'D':
			this.boxes[row][column] = new DBox(this, column, row);
			break; 

		default:
			return;


		}

	}


	public MBox getBox(int column, int row){

		return this.boxes[column][row];

	}


	@Override
	public ArrayList<VertexInterface> getAllVertexes() {

		ArrayList<VertexInterface> allVertexes = new ArrayList<VertexInterface>();

		for (int i = 0 ; i < this.height ; i++)
		{
			MBox[] row = boxes[i];
			for (int j = 0 ; j < this.width ; j++)

				allVertexes.add(row[j]);
		}

		return allVertexes;

	}

	/**
	 * 
	 * @param vertex
	 * @return the list of vertexes accessible to a vertex 
	 */
	public final ArrayList<VertexInterface> getAccessibleVertexes(VertexInterface vertex) 
	{
		MBox box = (MBox)vertex ; 
		ArrayList<VertexInterface> accessibleVertexes = new ArrayList<VertexInterface>();

		int row = box.getRow();
		int column = box.getColumn();
		MBox neighbor;

		// upper neighbors
		if (row > 0) { 
			neighbor = boxes[column][row-1];
			if (neighbor.isEmpty())
				accessibleVertexes.add(neighbor);
		}

		// lower neighbors
		if (row < this.height - 1) { 
			neighbor = boxes[column][row+1];
			if (neighbor.isEmpty())
				accessibleVertexes.add(neighbor);
		}

		// left neighbors
		if (column > 0) { 
			neighbor = boxes[column-1][row];
			if (neighbor.isEmpty())
				accessibleVertexes.add(neighbor);
		}

		// right neighbors
		if (column < width - 1) { 
			neighbor = boxes[column+1][row];
			if (neighbor.isEmpty())
				accessibleVertexes.add(neighbor);
		}	

		return accessibleVertexes;
	}


	/**
	 * Weight between two neighbor cases 
	 * */
	@Override
	public int getWeight(VertexInterface vertex1, VertexInterface vertex2) {
		
		return 1;
	}

	@Override
	public VertexInterface getSourceVertex() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addVertex(VertexInterface vertex) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addEdge(VertexInterface vertex1, VertexInterface vertex2,
			int weight) {
		// TODO Auto-generated method stub

	}

	public void createFromTextFile(String textFileName) throws FileNotFoundException, IOException, Exception {




	}

	public void saveToTextFile(String textFileName) throws FileNotFoundException, IOException, Exception {

		PrintWriter pw = null;

		try {

			pw = new PrintWriter(textFileName);
			// the row 
			for (int i = 0; i < this.height; i++) {

				MBox[] rows = boxes[i] ;
				
				for (int j = 0 ; j < this.width ; j++) {	
					
					pw.print(rows[j].getChar());
					// System.out.print("index: "+ rows[j].getLabel());
				} 
				
				// System.out.println();
				pw.println();

			}

		} catch (Exception e) {

			System.err.println("Printer failed");
		} finally {

			if (pw != null)
			{
				try {
					pw.close(); 
				} catch (Exception e) {
					
					System.err.println("Failed to close file");
				};		
			}		

		}

	}
	
	public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
		
		System.out.println("hello, I will try to save to a file");
		
		Maze maze = new Maze(10, 10);
		
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
		maze.saveToTextFile(Maze.PATH);
		
		
		
	}


}
