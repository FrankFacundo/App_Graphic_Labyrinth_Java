// hello I'm making a comment to update my branch

package maze;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import dijsktra.GraphInterface;
import dijsktra.VertexInterface;

public class Maze implements GraphInterface{

	// To determine the size
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

	public void setBox(int column, int row, char type){

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

	public void initFromTextFile(String fileName) throws FileNotFoundException, IOException, MazeReadingException, Exception {

		FileReader fr =  null; 
		BufferedReader bufferedReader = null;


		try {

			fr = new FileReader(fileName);
			bufferedReader = new BufferedReader(fr);	

			// the object already exists so height and width are already determined
			for (int i = 0 ; i < this.height ; i++) {

				String row = bufferedReader.readLine();

				// If the row we are reading is null 
				if (row == null) {

					// System.err.println("Insufficient number of rows");
					throw new MazeReadingException(fileName, i, " Insufficient number of rows." );

				} else {

					// we check the size
					if (row.length() < this.width) {

						// System.err.println("The row "+ i + 1 + " does not contain enough cases");
						throw new MazeReadingException(fileName, i, "The row " + i + 1 +
								" does not contain enough cases" );

					} else if (row.length() > this.width) {


						// System.err.println("The row "+ i + 1 + " contains too many cases");
						throw new MazeReadingException(fileName, i, "The row " + i + 1 + " contains too many cases" );

					} else {

						for (int j = 0 ; j < this.width ; j++)
						{
							switch (row.charAt(j)) 
							{
							case 'D' :
								this.boxes[i][j] = new DBox(this, j, i); 
								break;
							case 'A' :
								boxes[i][j] = new ABox(this, j, i);
								break;
							case 'W' :
								boxes[i][j] = new WBox(this, j, i); 
								break;
							case 'E' :
								boxes[i][j] = new EBox(this, j, i);
								break;         	
							default :

								//System.err.println("Invalid character");
								throw new MazeReadingException(fileName, i, " Unknown character: " +
										boxes[j][i] + "." );

							}
						} 

					}

				}

			}

		} finally {

			if (fr != null) {
				try {

					fr.close(); 

				} catch (Exception e) {

					System.err.println("Failed to close file");
				};		
			}

			if (bufferedReader != null) {
				try {

					bufferedReader.close(); 

				} catch (Exception e) {

					System.err.println("Failed to close reader");

				};		
			}


		}


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

	
	public void setSourceVertex(VertexInterface sourceVertex) {
		
		this.depart = sourceVertex;
		
	}

}
