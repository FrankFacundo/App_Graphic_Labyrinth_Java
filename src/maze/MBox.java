package maze;

import java.util.ArrayList;
import java.util.HashMap;

//import com.sun.prism.Graphics;

import java.awt.Graphics;

import dijsktra.VertexInterface;

public  abstract class MBox implements VertexInterface{
	
	private Maze maze;
	private int column; 
	private int row;
	private String label;
	
	public MBox(Maze maze, int column, int row){
	
		this.maze = maze;
		this.column = column;
		this.row = row;
		this.label = "(" + this.column + "," + this.row  + ")";
		
	}

	public String getLabel() {
		
		return this.label;
		
		
	}
	
	public int getColumn() {
		
		return this.column;
	}


	public int getRow() {
		
		return this.row;
	}
	
	public boolean isEmpty()
	{
		return true;
	}
	
	public abstract char getChar();

	
	@Override
	public int getDistanceTo(VertexInterface anotherVertex) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void addAdjacentVertex(VertexInterface vertex, int distance) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<VertexInterface> getAdjacentVertexes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HashMap<VertexInterface, Integer> getAdjacentVertexesAndDistances() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract void paint(Graphics g, int h, int w);
	
}
