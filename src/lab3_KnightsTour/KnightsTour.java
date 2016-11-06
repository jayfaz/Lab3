package lab3_KnightsTour;

public class KnightsTour {
	
	private int size;
	private int[][] theBoard;
	private int tour;
	
	public KnightsTour(int size) {
		this.size = size;
		theBoard = new int[size][size];
	}
	
	public boolean ableToMove(int row,int col) {
		if(row >= 0 && col >= 0 && row < size && col < size) {
			return true;
		}
			return false;
	}
	
	public void run(int row, int col) {
		if(findPath(row, col, 0)) {
			for(int i = 0; i < theBoard.length; i++) {
				for(int j = 0; j < theBoard.length; j++) {
					System.out.print("   " + theBoard[i][j]);
				}
				System.out.println();
			}
		} else {
			System.out.println("No Possible Solutions");
		}
	}
	
	public boolean findPath(int row, int col, int i) {
		if(theBoard[row][col] != 0) {
			return false;
		}
		theBoard[row][col] = tour++;
		if(i == size * size - 1) { //finished
			return true;
		}
		if(ableToMove(row + 2, col + 1) && findPath(row + 2, col + 1, i + 1)) {
			return true;
		} else if(ableToMove(row + 1, col + 2) && findPath(row + 1, col + 2, i + 1)) { //checks all possible directions in an "L" shape
			return true;
		} else if(ableToMove(row - 1, col + 2) && findPath(row - 1, col + 2, i + 1)) {
			return true;
		} else if(ableToMove(row - 2, col + 1) && findPath(row - 2, col + 1, i + 1)) {
			return true;
		} else if(ableToMove(row - 2, col - 1) && findPath(row - 2, col - 1, i + 1)) {
			return true;
		} else if(ableToMove(row - 1, col - 2) && findPath(row - 1, col - 2, i + 1)) {
			return true;
		} else if(ableToMove(row + 1, col - 2) && findPath(row + 1, col - 2, i + 1)) {
			return true;
		} else if(ableToMove(row + 2, col - 1) && findPath(row + 2, col - 1, i + 1)) {
			return true;
		} else {
			theBoard[row][col] = 0; //go back 1 step
			tour--;
			return false;
		}
	}
}
