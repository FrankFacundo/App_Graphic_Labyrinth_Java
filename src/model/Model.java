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
	private Color currentColor;
	private final int size = 10; // to begin with
	private boolean isValid;
	
	private boolean modified;


	// will be true when the shortest path has been found 
	private boolean solved	= false; 
	private MBox[][] modifiedBoxes;

	
	public Model(MazeApp mazeApp) {

		this.mazeApp = mazeApp;
		// this.isValid = this.isValid();
		
		this.maze = new Maze(size, size);
		
		this.modified = false; 
		this.solved = false;
		
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


	// To verify that the maze is valid 
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

	
	public boolean getValid() {

		return this.isValid;
	}


	public void setModified(boolean modified) {

		this.modified = modified;

	}


	public void setSelectedCase(int column, int row) {
		this.selectedCase = (MBox) maze.getBox(column, row);
	}


	public MBox getSelectedCase() {

		return this.selectedCase;
	}



	public Maze getMaze() {

		return this.maze;
	}




	public boolean isSolved() {
		return this.solved;
	}


	public void setSolved(boolean solved) {
		this.solved = solved;
	}


	public int getSize() {

		return this.size;
	}



	public void setBox(int i, int j) {

		if (this.currentColor == Color.RED ) {
			this.putABox(i, j);

		} else if(this.currentColor == Color.GREEN ) {
			this.putDBox(i, j);

		} else if(this.currentColor == Color.WHITE) {
			this.putEBox(i,j);

		} else if(this.currentColor == Color.GRAY) {
			this.putWBox(i,j);
		}
	}

	public void putEBox(int i, int j) {
		this.maze.getBoxes()[i][j] = new EBox(this.maze, j, i);
	}

	public void putABox(int i, int j) {
		this.maze.getBoxes()[i][j] = new ABox(this.maze, j, i);
	}
	public void putWBox(int i, int j) {
		this.maze.getBoxes()[i][j] = new WBox(this.maze, j, i);
	}

	public void putDBox(int i, int j) {
		this.maze.getBoxes()[i][j] = new DBox(this.maze, j, i);
	}

	public void setCase(int column, int row) {
		this.cases[column][row] = new CasePanel(mazeApp, column, row);
	}

	public CasePanel getCase(int column, int row) {

		return this.cases[column][row];
	}


	public void initializeMaze() {

		// this.cases = new CasPanel[this.size][this.size];
		for (int i = 0; i < this.size; i++) {

			for(int j = 0; j < this.size; j++) {

				switch(this.maze.getBox(j,i).getChar()) {
				case 'A' : 
					this.setCase(i,j);
					this.getCase(i, j).setBackground(Color.RED);
					break;

				case 'D' : 
					this.setCase(i,j);
					this.getCase(i, j).setBackground(Color.GREEN);
					break;

				case 'E' : 
					this.setCase(i,j);
					this.getCase(i, j).setBackground(Color.WHITE);
					break;

				case 'W' : 
					this.setCase(i,j);
					this.getCase(i, j).setBackground(Color.GRAY);
					break;

				}
			}

		}
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

