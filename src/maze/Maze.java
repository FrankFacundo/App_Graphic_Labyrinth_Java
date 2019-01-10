package maze;

import java.awt.Graphics;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JOptionPane;

import dijsktra.*;

public class Maze implements GraphInterface{

	// To determine the size
	private int width;
	private int height; 

	private MBox[][] boxes;

	private VertexInterface depart;
	private VertexInterface arrival;

	private boolean solved = false; 


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

	public void setBox(int column, int row, char type) {

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

		for (int i = 0 ; i < this.height ; i++) {
			MBox[] row = boxes[i];
			for (int j = 0 ; j < this.width ; j++)

				allVertexes.add(row[j]);
		}

		return allVertexes;

	}

	/**
	 * 
	 * @param vertex
	 * @return the list of a vertexe's successors
	 */
	public final ArrayList<VertexInterface> getSuccessors(VertexInterface vertex) {

		MBox box = (MBox)vertex ; 
		MBox successor;
		ArrayList<VertexInterface> successors = new ArrayList<VertexInterface>();

		int row = box.getRow();
		int column = box.getColumn();

		// upper neighbors
		if (row > 0) { 
			successor = boxes[column][row-1];
			successors.add(successor);
		}

		// lower neighbors
		if (row < this.height - 1) { 
			successor = boxes[column][row+1];
			successors.add(successor);
		}

		// left neighbors
		if (column > 0) { 
			successor = boxes[column-1][row];
			successors.add(successor);
		}

		// right neighbors
		if (column < width - 1) { 
			successor = boxes[column+1][row];
			successors.add(successor);
		}	

		return successors;

	}


	/**
	 * 
	 * @param vertex
	 * @return the list of vertexes accessible to a vertex 
	 */
	public final ArrayList<VertexInterface> getAccessibleVertexes(VertexInterface vertex) {
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
	 * 
	 * @param vertex
	 * @return the weight of an edge joining two cases
	 */
	@Override
	public int getWeight(VertexInterface vertex1, VertexInterface vertex2) {

		if (this.getSuccessors(vertex1).contains(vertex2)) {

			return 1;
		} else {

			return 0;
		}

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

				pw.println();

			}

		} catch (Exception e) {

			System.err.println("Printer failed");
		} finally {

			if (pw != null) {
				try {
					pw.close(); 
				} catch (Exception e) {

					System.err.println("Failed to close file");
				};		
			}		

		}

	}


	// Getter for the case's symbol (char)  ui will call this method
	public char getBoxSymbol(int column, int row) {		
		try {
			char symbol = this.boxes[column][row].getChar();
			return symbol;

		} catch (Exception e) {
			System.err.println("Error: impossible to access this case");

			JOptionPane.showMessageDialog(null, "Impossible to access this case", "Case error", JOptionPane.ERROR_MESSAGE);

			return ' ';

		}
	}	

	// To change the case's symbol 
	public void setBoxSymbol(int column, int row, char c) {  

		if (row <= 0 || column <= 0 || row >= this.height-1 || column >= this.width-1)	{
			System.err.println("Error: impossible to edit this case");
			JOptionPane.showMessageDialog(null, "Impossible to edit this case", "Case error", JOptionPane.ERROR_MESSAGE);
			return;
		}     

		else if (this.solved) {
			this.askToReinit();
			return;
		}

		else {    	
			try {
				switch (c) {
				case 'D' :
					boxes[row][column] = new DBox(this,column,row); break;
				case 'A' :
					boxes[row][column] = new ABox(this,column,row); break;
				case 'W' :
					boxes[row][column] = new WBox(this,column,row); break;
				case 'E' :
					boxes[row][column] = new EBox(this,column,row); break;  
				case 'X' :
					boxes[row][column] = new PBox(this,column,row); break; 

				default :  
					return;
				}

			}  catch (Exception e) {    	

				System.err.println("Error: impossible to edit this case");

				JOptionPane.showMessageDialog(null, "Impossible to edit this case", "Case error", JOptionPane.ERROR_MESSAGE);

			}
		}    

	}




	public void drawBox(int i, int j, Graphics g, int h, int w) {

		this.boxes[i][j].draw(g, h, w);

	}

	public void paintBox(int i, int j, Graphics g, int h, int w) {

		this.boxes[i][j].paint(g, h, w);

	}

	public void setBoxes(MBox[][] boxes) {

		this.boxes = boxes;
	}

	public MBox[][] getBoxes() {
		return this.boxes;
	}




	// To reinitialize the maze
	private void askToReinit() {

		int option = JOptionPane.showConfirmDialog(null, "The shortest path has been found for this maze. Do you want to reinitialize the maze?", 
				"Maze reinitialization", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	

		if(option == JOptionPane.OK_OPTION) {
			for (int i=1 ; i < this.height-1 ; i++)
			{
				for (int j=1 ; j < this.width-1 ; j++)
				{					
					//if(this.getBoxSymbol(j, i) == '*')	{
					setBox(j, i, 'E');
				}
			}

			this.solved = false;

		} else {

			return;
		}


	}

	// To verify that the maze is valid 
	public boolean isValid() {


		boolean valid = false; 

		int i = 0;
		int j = 0; 
		int a = 0; 
		int d = 0;

		while (i < this.height && !valid) {

			while (j < this.width && !valid) {

				if (this.getBoxSymbol(j, i) == 'D') {
					d++;

				} else if (this.getBoxSymbol(j,i) == 'A'){
					a++;
				}

				if (a == 1 && d == 1) {
					valid = true;
				}

				j++;

			}
			j=0; 
			i++;

		}

		return valid;

	}


	// Finds the shortest path between d and a cases

	public void findShortestPath() throws NullPointerException {		

		try {   

			if (this.solved) {

				this.askToReinit();

			} else 
				if (this.isValid()) {


				int i = 0;
				int j = 0; 
				int flags = 0;

				while (i < this.height && flags < 2) {

					while (j < this.width && flags < 2) {

						if (this.getBoxSymbol(j, i) == 'D') {
							this.depart = getBox(j,i);
							flags++;
						} else if (this.getBoxSymbol(j,i) == 'A'){
							this.arrival = getBox(j,i);
							flags++;
						}

						j++;

					}
					j=0;
					i++;
				}


				Previous p = (Previous) Dijsktra.dijkstra(this, depart);      	    	
				ArrayList<VertexInterface> shortestPath = p.getShortestPath(arrival);

				this.printShortestPath(shortestPath); 
				this.solved = true;				
				return;

			} 
			else {

				System.err.println("Impossible to find the shortest path: the maze is not valid. A case for the depart and another one for the arrival must be chosen.");
				JOptionPane.showMessageDialog(null, "Impossible to find the shortest path. A unique case for the depart (green) and another one for the arrival (red) must be chosen. Click a case multiple times to change its type (consequently its color).",
						"Maze solving error", JOptionPane.ERROR_MESSAGE);

				return;
			} 

		} catch(NullPointerException e){

			System.err.println("Error: no maze has been initialized.");
			JOptionPane.showMessageDialog(null, "No maze has been initialized", "Maze error", JOptionPane.ERROR_MESSAGE);

		} finally {

			// repaint cases with paint();
			// TO DO 

		}
	}  


	// To print the shortest path later on 
	private void printShortestPath(ArrayList<VertexInterface> shortestPath) {

		if(shortestPath != null) {

			Iterator<VertexInterface> iterator = shortestPath.iterator();
			int i, j;

			while(iterator.hasNext()) {

				MBox c = (MBox)iterator.next();
				i = c.getRow();
				j = c.getColumn();
				this.setBoxSymbol(i, j, 'X'); 
			}			
		}
	}



	// Test method
	@Override
	public VertexInterface getSourceVertex() {

		return this.depart;
	}

	// Test method
	public void setSourceVertex(VertexInterface sourceVertex) {

		this.depart = sourceVertex;

	}

	// Test method
	@Override
	public void addVertex(VertexInterface vertex) {
		// TODO Auto-generated method stub

	}

	// Test method
	@Override
	public void addEdge(VertexInterface vertex1, VertexInterface vertex2,
			int weight) {
		// TODO Auto-generated method stub

	}


}

