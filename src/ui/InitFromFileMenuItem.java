package ui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

import maze.ABox;
import maze.DBox;
import maze.EBox;
import maze.MazeReadingException;
import maze.WBox;
import model.Model;


public final class InitFromFileMenuItem extends JMenuItem implements ActionListener {
	private final MazeApp MazeApp;

	public InitFromFileMenuItem (MazeApp MazeApp)
	{
		super("Intialize from file");
		this.MazeApp = MazeApp;
		addActionListener(this) ;
	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		this.MazeApp.getModel().initFromFile();
	}



}


