package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.*;

public class Model extends Observable {


	private final ArrayList<Case> editedCases  = new ArrayList<Case>(10) ;
	private Case selectedCase = new Case(); 


	public Case getSelectedCase() {
		return selectedCase;
	}

	public final void paintCases(Graphics g) {
		for (Case c : editedCases)
			c.paint(g,false,false) ;

		if (selectedCase != null)
			selectedCase.paint(g,true,false) ;

		if (currentCase != null)
			currentCase.paint(g,false,true) ;
	}	


}
