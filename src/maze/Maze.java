package maze;

import java.io.*;
import java.util.*;
import dijsktra.*;

public final class Maze implements GraphInterface{

	// To determine the size of the maze
	private int width;
	private int height; 

	private MBox[][] boxes;
	private MBox depart;
	private MBox arrival;

	public Maze(int width, int height){

		this.width = width;
		this.height = height;

		this.boxes = new MBox[this.width][this.height];

		// Cases initialization
		for(int i = 0; i < height; i++) {

			for(int j = 0; j < width; j++) {

				this.setBox(i,j,'E');

			}

		}

	}

	/**
	 * To get the vertex (cannot be a wall) that has the smallest pi distance to the root and that hasn't been analyzed yet
	 * @param pi contains all distances from root to the other vertexes
	 * @param aSet, set which contains the already analyzed vertexes
	 * @return the vertex with the smallest pi value  
	 */
	@Override
	public VertexInterface getShortestDistanceVertex(PiInterface pi, ASetInterface aSet) {

		int minimalLength = Integer.MAX_VALUE ;
		MBox pivot = null;

		for(int i = 0; i < height; i++) {

			for(int j = 0; j < width; j++) {

				MBox box = this.boxes[j][i];

				if (!aSet.contains(box) && pi.getValue(box) < minimalLength && !box.isWall()) {

					minimalLength = pi.getValue(box);
					pivot = box;

				}

			}
		}

		return pivot;

	}


	/**
	 * To get the number of boxes in the maze that are not walls 
	 * @return the number of boxes that are not walls 
	 */
	@Override
	public int getSize() {

		int notWallBoxes = 0;

		for(int i = 0; i < height; i++) {

			for(int j = 0; j < width; j++) {

				if( !this.boxes[j][i].isWall())
					notWallBoxes++;
			}
		}


		return notWallBoxes;
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

		case 'X':
			this.boxes[row][column] = new PBox(this, column, row);
			break; 

		default:
			return;


		}

	}

	public void setBox(int column, int row, MBox mbox) {

		this.boxes[column][row] = mbox;

	}


	public MBox getBox(int column, int row){

		return this.boxes[column][row];

	}


	@Override
	public ArrayList<VertexInterface> getAllVertexes() {

		ArrayList<VertexInterface> allVertexes = new ArrayList<VertexInterface>();

		for (int i = 0 ; i < this.height ; i++) {
			MBox[] row = boxes[i];

			for (int j = 0 ; j < this.width ; j++) {

				allVertexes.add(row[j]);

			}
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
			if(!successor.isWall()) {
				// this.addEdge(box, successor, 1);
				// box.addAdjacentVertex(successor, 1);
				successors.add(successor);

			}
		}

		// lower neighbors
		if (row < this.height - 1) { 
			successor = boxes[column][row+1];
			if(!successor.isWall()) {
				// this.addEdge(box, successor, 1);
				// box.addAdjacentVertex(successor, 1);
				successors.add(successor);

			}
		}

		// left neighbors
		if (column > 0) { 
			successor = boxes[column-1][row];
			if(!successor.isWall()) {
				// this.addEdge(box, successor, 1);
				// box.addAdjacentVertex(successor, 1);
				successors.add(successor);
			}
		}

		// right neighbors
		if (column < width - 1) { 
			successor = boxes[column+1][row];
			if(!successor.isWall()) {
	
				successors.add(successor);
			}
		}


		return successors;

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


	// Getter for the case's symbol (char) 
	public char getBoxSymbol(int column, int row) {	
		
		try {
			char symbol = this.boxes[column][row].getChar();
			return symbol;

		} catch (Exception e) {
			System.err.println("Error: impossible to access this case");
			return ' ';

		}
	}	

	// To change the case's symbol 
	public void setBoxSymbol(int column, int row, char c) {  

		if (row < 0 || column < 0 || row > this.height-1 || column > this.width-1)	{
			System.err.println("Error: impossible to edit this case");
			// JOptionPane.showMessageDialog(null, "Impossible to edit this case", "Case error", JOptionPane.ERROR_MESSAGE);
			return;
		} else {    	
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

			}
		}    

	}

	public void setBoxes(MBox[][] boxes) {

		this.boxes = boxes;
	}

	public MBox[][] getBoxes() {
		return this.boxes;
	}


	// To verify that the maze is valid 
	public boolean isValid() {

		boolean valid = false; 

		int i = 0;
		int a = 0; 
		int d = 0;

		while (i < this.height && !valid) {

			int j = 0; 
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
	
	/**
	 * To get the departure box 
	 * @return The departure box
	 */
	public final VertexInterface getDepartureBox() {


		for (int i = 0 ; i < this.height ; i++) {

			for (int j = 0 ; j < this.width ; j++) {

				if (this.getBoxSymbol(j, i) == 'D') {
					return this.getBox(j, i);
				}

			}

		}

		return null;

	}


	/**
	 * To get the arrival box 
	 * @return The arrival box
	 */
	public final VertexInterface getArrivalBox() {


		for (int i = 0 ; i < this.height ; i++) {

			for (int j = 0 ; j < this.width ; j++) {

				if (this.getBoxSymbol(j, i) == 'A') {
					return this.getBox(j, i);
				}

			}

		}

		return null;
	}

	/**
	 * This method is used to find the path from the departure box to the arrival box
	 * @see Dijkstra 
	 */
	public final void findShortestPath() throws NullPointerException{

		int i = 0;
		int j; 
		int flags = 0;


		while (i < this.height && flags < 2) {
			j = 0;
			while (j < this.width && flags < 2) {

				if (this.getBoxSymbol(j, i) == 'D') {
					this.depart = getBox(j,i);
					// Console Trace
					System.out.println("Got the departure case in "+getBox(j,i).toString());
					flags++;
				} else if (this.getBoxSymbol(j,i) == 'A'){
					this.arrival = getBox(j,i);
					// Console Trace
					System.out.println("Got the arrival case in "+getBox(j,i).toString());
					flags++;
				}

				j++;

			}

			i++;
		}

		PreviousInterface p = (Previous) Dijsktra.dijkstra(this, this.getDepartureBox());    

		ArrayList<VertexInterface> shortestPath = p.getShortestPath(this.getArrivalBox());
		// Console Trace
		System.out.println("The shortest path has: "+ shortestPath.size() + " elements");

		for ( i = 0 ; i < this.height ; i++) {

			for (j = 0 ; j < this.width ; j++) {

				if (shortestPath.contains(this.boxes[j][i])) {
					// Console Trace
					System.out.println("The case: "+ this.boxes[j][i] + " is in the path");
				}

			}

		}

		this.printShortestPath(shortestPath); 
	}


	// To print the shortest path
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

			int departColumn = this.depart.getColumn();
			int departRow = this.depart.getRow();
			this.setBoxSymbol(departRow, departColumn, 'D'); 

			int arrivalColumn = this.arrival.getColumn();
			int arrivalRow = this.arrival.getRow();
			this.setBoxSymbol(arrivalRow, arrivalColumn, 'A'); 

			i = 0;
			while (i < this.height) {
				j = 0;
				while (j < this.width) {

					System.out.print(this.getBox(j, i).getChar());

					j++;

				}

				System.out.println();
				i++;
			}

		}
	}

}
