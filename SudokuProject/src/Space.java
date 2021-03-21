//Represents a space on the Sudoku puzzle

public class Space {
	
	private int x;
	private int y;
	
	public Space(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
