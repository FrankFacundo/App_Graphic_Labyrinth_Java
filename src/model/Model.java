package model;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;

import javax.swing.*;

import maze.MBox;

public class Model extends Observable {


	private  boolean  gameOver  = false ;
	// booléen disant si le modèle a été modifié afin de proposer une sauvegarde en cas de fermeture de l'application

	private MBox[][] boxes;

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
