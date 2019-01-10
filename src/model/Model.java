package model;

import java.awt.*;
import java.util.Observable;

import javax.swing.*;

import maze.*;
import ui.*;

public class Model extends Observable {

	private MazeApp mazeApp;
	private Maze maze;
	private CasePanel[][] cases;
	private MBox selectedCase;
	private Color selectedColor;
	private final int size = 10; // to begin with
	private boolean isValid;

	private boolean modified;


	// will be true when the shortest path has been found 
	private boolean isSolved	= false; 
	private MBox[][] modifiedBoxes;


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


	// To verify that the maze is valid : 1 depart and 1 arrival point
	public boolean isValid() {

		boolean isValid = false;

		int i = 0;
		int j = 0; 
		int a = 0; 
		int d = 0;

		while (i < this.size && !isValid) {

			while (j < this.size && !isValid) {

				if (this.maze.getBoxSymbol(j, i) == 'D') {
					d++;

				} else if (this.maze.getBoxSymbol(j,i) == 'A'){
					a++;
				}

				if (a == 1 && d == 1) {
					isValid = true;
				}

				j++;

			}

			i++;

		}
		return isValid;
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

	public void putEBox(int j, int i) {
		
		EBox ebox = new EBox(this.maze, j, i);
		this.maze.getBoxes()[j][i] = ebox;
		this.selectedCase = ebox;
	}

	public void putABox(int j, int i) {
		
		ABox abox = new ABox(this.maze, j, i);
		this.maze.getBoxes()[j][i] = abox;
		this.selectedCase = abox;
		
	}
	
	public void putWBox(int j, int i) {
		
		WBox wbox = new WBox(this.maze, j, i);
		this.maze.getBoxes()[j][i] = wbox;
		this.selectedCase = wbox;
		
	}

	public void putDBox(int j, int i) {
		
		DBox dbox = new DBox(this.maze, j, i);
		this.maze.getBoxes()[j][i] = dbox;
		this.selectedCase = dbox;
		
	}


	public void initializeMaze() {

		// this.cases = new CasPanel[this.size][this.size];
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

	// To set the color of the case that we intend to modify
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

	public void changeCaseColor() {

		// System.out.println("In the model the selected case is "+this.selectedCase);
		int column = this.selectedCase.getColumn();
		int row = this.selectedCase.getRow();

		this.isValid = isValid();
		
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
		System.out.println("the symbol in the panel is " + this.maze.getBoxSymbol(
				this.selectedCase.getColumn(), 
				this.selectedCase.getRow()));
		// this.selectedCase = null;
		this.modified = true;
		
		//System.out.println("Here's the selected case: "+this.getSelectedCase().getLabel());
		
	}
	
	
	public void updateTextInPanel() {
		
		
		
	}


}

/*

	public final void paintCase(Graphics g) {
		//for (Case c : editedCases)
		//this.selectedCase.paint(g,false,false) ;

		if (selectedCase != null)
			this.selectedCase.paint(g, 10, 10) ;

	}	

 */


/**
 *  Method to draw all cases at the beginning 
 * 
 * */

/*
	public final void drawCases(Graphics g) {

		for (MBox[] boxLine : this.cases) {

			for (MBox box : boxLine) {

				box.draw(g, 10, 10);

			}

		}

		//this.selectedCase.paint(g,false,false) ;


	}

 */

