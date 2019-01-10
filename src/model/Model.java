package model;

import java.awt.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import javax.swing.*;

import dijsktra.Dijsktra;
import dijsktra.Previous;
import dijsktra.VertexInterface;
import maze.*;
import ui.*;

public class Model extends Observable {

	private MazeApp mazeApp;
	private Maze maze;
	private CasePanel[][] cases;
	private MBox selectedCase;
	private Color selectedColor;
	private final int size = 10; // the maze will be size*size 
	private boolean isValid;

	private boolean modified;

	private boolean isSolved; // will be true when the shortest path has been found 
	// private MBox[][] modifiedBoxes;


	public Model(MazeApp mazeApp) {

		this.mazeApp = mazeApp;
		this.maze = new Maze(size, size);

		this.isValid = this.isValid();

		this.modified = false; 
		this.isSolved = false;

		this.initialize();

	}

	// Initialization 
	public void initialize() {

		MBox[][] boxes = new MBox[this.size][this.size];
		CasePanel[][] casePanel = new CasePanel[this.size][this.size];

		for(int i = 0; i< this.size ;i++) {

			for(int j = 0; j < this.size ;j++) {

				boxes[i][j] = new EBox(this.maze, i, j);
				casePanel[i][j]  = new CasePanel(mazeApp, i, j);

			}

		}

		this.maze.setBoxes(boxes);
		this.cases = casePanel;

	}


	/**
	 * To verify that the maze is valid
	 * @return true if he maze is valid (one unique depart and one unique arrival point), else false
	 */
	public boolean isValid() {

		boolean valid = true;

		int i = 0; 
		int a = 0; int d = 0;
		MBox depart = null; MBox arrival = null;

		while (i < this.size && valid) {

			int j = 0; 
			
			while (j < this.size && valid) {
	
				// System.out.println("this box is: "+this.maze.getBox(j,i).getLabel());
				if (this.maze.getBoxSymbol(j, i) == 'D') {
					depart = this.maze.getBox(j, i);
					d++;

				} else if (this.maze.getBoxSymbol(j,i) == 'A'){
					arrival = this.maze.getBox(j, i);
					a++;
				}


				j++;

			}
			
			if (a > 1 || d > 1) {
				valid = false;
			}

			i++;

		}

		if(depart!= null & arrival!= null) {
			
			if (this.maze.getSuccessors(depart).contains(arrival)){
				valid = false;
			}
			
		} else {
			valid = false;
		}

		this.isValid = valid;
		// System.out.println("Validation: "+this.isValid);
		return valid;
		
		
	} 


	public boolean getIsValid() {

		return this.isValid;
	}


	public void setModified(boolean modified) {

		this.modified = modified;
	}



	public MBox getSelectedCase() {

		return this.selectedCase;
	}

	/**
	 * To set the current selected case
	 * @parameter column the column of the (eventually new) current selected case
	 * @parameter row the row of the (eventually new) current selected case
	 */
	public void setSelectedCase(int column, int row) {

		this.selectedCase = this.maze.getBox(column, row);
		setChanged() ;
		notifyObservers() ;
	}


	public Maze getMaze() {

		return this.maze;
	}


	public boolean getIsSolved() {

		return this.isSolved;
	}


	public void setIsSolved(boolean isSolved) {

		this.isSolved = isSolved;
	}


	public int getSize() {

		return this.size;
	}


	public CasePanel getCase(int column, int row) {

		return this.cases[column][row];
	}

	public void createCase(int column, int row) {

		this.cases[column][row] = new CasePanel(mazeApp, column, row);
	}


	public void setCase(int j, int i) {

		if (this.selectedColor == Color.RED ) {
			this.putABox(j, i);

		} else if(this.selectedColor == Color.GREEN ) {
			this.putDBox(j, i);

		} else if(this.selectedColor == Color.WHITE) {
			this.putEBox(j,i);

		} else if(this.selectedColor == Color.GRAY) {
			this.putWBox(j,i);
		}
	}

	public void putABox(int j, int i) {

		ABox abox = new ABox(this.maze, j, i);
		this.maze.setBox(j, i, abox);
		this.selectedCase = abox;

	}
	
	public void putEBox(int j, int i) {

		EBox ebox = new EBox(this.maze, j, i);
		this.maze.setBox(j, i, ebox);
		this.selectedCase = ebox;
	}



	public void putWBox(int j, int i) {

		WBox wbox = new WBox(this.maze, j, i);
		this.maze.setBox(j, i, wbox);
		//this.maze.getBoxes()[j][i] = wbox;
		this.selectedCase = wbox;

	}

	public void putDBox(int j, int i) {

		DBox dbox = new DBox(this.maze, j, i);
		this.maze.setBox(j, i, dbox);
		//this.maze.getBoxes()[j][i] = dbox;
		this.selectedCase = dbox;

	}


	/**
	 * A method to be used by initFromFile, or another similar method Frank
	 */
	public void initializeMaze() {

		for (int i = 0; i < this.size; i++) {

			for(int j = 0; j < this.size; j++) {

				switch(this.maze.getBox(j,i).getChar()) {

				case 'A' : 
					this.createCase(j,i);
					this.getCase(j, i).setBackground(Color.RED);
					break;

				case 'D' : 
					this.createCase(i,j);
					this.getCase(i, j).setBackground(Color.GREEN);
					break;

				case 'E' : 
					this.createCase(i,j);
					this.getCase(i, j).setBackground(Color.WHITE);
					break;

				case 'W' : 
					this.createCase(i,j);
					this.getCase(i, j).setBackground(Color.GRAY);
					break;

				}
			}

		}
	}


	/**
	 * To set the current color to the selected one
	 */
	public void setSelectedColor(char charFromButton){

		switch(charFromButton) {
		case 'A':
			this.selectedColor = Color.RED; break;
		case 'D': 
			this.selectedColor = Color.GREEN; break;			
		case 'E': 
			this.selectedColor = Color.WHITE; break;		
		case 'W': 
			this.selectedColor = Color.GRAY; break;		
		}
	}

	public Color getSelectedColor() {

		return this.selectedColor;
	}

	/**
	 * To change a cases's type
	 * For example, from wall(gray) to depart(green) case
	 * Observers will be notified by setCase(int, int) method
	 */
	public void changeCaseType() {

		int column = this.selectedCase.getColumn();
		int row = this.selectedCase.getRow();

		
		// this.isValid = isValid();

		if (this.selectedColor  == Color.GRAY || this.selectedColor == Color.WHITE
				|| (this.selectedColor == Color.RED  || (this.selectedColor == Color.GREEN ))) {


			this.getCase(column, row).setBackground(this.selectedColor);
			this.getCase(column, row).setOpaque(true);
			//this.getCase(column, row).setBorderPainted(false); // MAC


		} 

		/*else if (this.selectedColor == Color.RED && !this.isValid) {
			JOptionPane.showMessageDialog(null, "One unique depart case must be selected.", "Depart case error", JOptionPane.WARNING_MESSAGE);
		} */

		/*else {
			// error on the arrival case 
			JOptionPane.showMessageDialog(null, "One unique arrival case must be selected.", "Arrival case error", JOptionPane.WARNING_MESSAGE);        
		}*/

		this.setCase(column, row);
		
		this.isValid();
		
		// System.out.println("now the box is "+this.maze.getBox(column, row).getLabel());

		// this.selectedCase = null;
		this.modified = true;

	}

	// To reinitialize the maze when the button Restart is clicked Sheila
	/*
	private void reinitializeMaze() {

		int option = JOptionPane.showConfirmDialog(null, "The shortest path has been found for this maze. Do you want to reinitialize the maze?", 
				"Maze reinitialization", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);	

		if(option == JOptionPane.OK_OPTION) {
			for (int i=1 ; i < this.size-1 ; i++)
			{
				for (int j=1 ; j < this.size-1 ; j++)
				{					
					//if(this.getBoxSymbol(j, i) == '*')	{
					this.setCase(j, i, 'E');
				}
			}

			this.isSolved = false;

		} else {

			return;
		}


	}
	 */

	// Finds the shortest path between d and a cases
	
	/**
	 * To find the shortest path between the depart and the arrival cases
	 * @return true if the shortest path has been successfully found, else false
	 */
	public boolean findShortestPath() {		
  
			if (this.isValid()) {

				this.maze.findShortestPath();
				this.isSolved = true;	
				this.initializeMaze();
				
				return true; 
			} else {

				return false; 
			} 
	}  


}