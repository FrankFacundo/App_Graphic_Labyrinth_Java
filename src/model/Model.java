package model;

import java.awt.Graphics;
import java.util.Observable;

import javax.swing.*;

import maze.MBox;

public class Model extends Observable {


	// will be true when the shortest path has been found 
	private boolean solved	= false; 

	//private final ArrayList<Case> editedCases  = new ArrayList<Case>(10) ;
	private MBox selectedCase;

	private MBox[][] cases;

	private MBox[][] modifiedCases;

	public MBox getSelectedCase() {

		return this.selectedCase;
	}

	public MBox[][] getCases() {

		return this.cases;
	}
	
	/**
	 *  Method to paint all cases at the beginning 
	 * 
	 * */
	public final void drawCases(Graphics g) {
		
		for (MBox[] boxLine : this.cases) {
		
			for (MBox box : boxLine) {
				
				box.draw(g, 10, 10);
					
			}
			
		}
			
		//this.selectedCase.paint(g,false,false) ;

		/*
		if (selectedCase != null)
			this.selectedCase.paint(g, 10, 10) ;

		if (currentCase != null)
			currentCase.paint(g,false,true) ;
			
			*/
		
	}
	

	public final void paintCase(Graphics g) {
		//for (Case c : editedCases)
		//this.selectedCase.paint(g,false,false) ;

		if (selectedCase != null)
			this.selectedCase.paint(g, 10, 10) ;

		/*
		if (currentCase != null)
			currentCase.paint(g,false,true) ;
		 */
	}	


	
	public boolean isSolved() {
		return this.solved;
	}

	
	public void setSolved(boolean solved) {
		this.solved = solved;
	}


}
