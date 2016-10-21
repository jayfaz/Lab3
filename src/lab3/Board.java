package lab3;
import java.awt.Point;

public class Board {
	
	private int size;
	private Point[][] theBoard;
	private Knight knight;
	
	public Board(int size) {
		this.size = size;
		theBoard = new Point[size][size];
	}
	
	public boolean moveIsValid(int row,int col) {
		if(row <= size && col <= size) {
			
		}
	}

}
